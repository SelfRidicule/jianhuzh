package com.zhongzhou.controller.system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhongzhou.controller.base.BaseController;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysUserCriteria;
import com.zhongzhou.log.LogObjectHolder;
import com.zhongzhou.log.annotation.LogInfer;
import com.zhongzhou.utils.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springfox.documentation.annotations.ApiIgnore;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.permission.PermissionHolder;
import com.zhongzhou.service.system.TSysUserService;
import com.zhongzhou.service.system.TSysDepartService;
import com.zhongzhou.service.system.TSysMenuService;
import com.zhongzhou.utils.Consts;

@Api(tags={"登录模块"})
@Controller
public class LoginController extends BaseController {

    private ObjectMapper mapper=new ObjectMapper();

    @Autowired
    private TSysUserService service;
    @Autowired
    private TSysMenuService menuService;
    @Autowired
    private TSysDepartService departService;


    //登录
    @ApiIgnore
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(ModelMap mm,HttpSession session,HttpServletRequest request){
        session.setAttribute("user", null);
        String path = request.getContextPath();
        String BASE_URL = path+"/";
        session.setAttribute("BASE_URL",BASE_URL);
        return "login";
    }
    @ApiOperation("用户登录")
    @LogInfer(logModel = "登录", logType = "登录",remake = "用户登录",ID = "account")
    @RequestMapping(value="/ajaxLogin",method = RequestMethod.POST)
    @ResponseBody
    public HttpResult ajaxLogin(@ApiParam(required=true,value="一个用户对象,account与password不能为空")TSysUser object, HttpSession session, HttpServletRequest request){
        HttpResult result = new HttpResult();
        System.out.println(object.getAccount());
        System.out.println(object.getPassword());
        try {
            TSysUserCriteria example = new TSysUserCriteria();
            if(object.getAccount()==null && "".equals(object.getAccount())){
                throw new Exception("用户名不能为空!");
            }
            if(object.getPassword()==null && "".equals(object.getPassword())){
                throw new Exception("密码不能为空!");
            }
            example.createCriteria().andAccountEqualTo(object.getAccount()).andPasswordEqualTo(object.getPassword());
            List<TSysUser> users = service.selectByExample(example);
            if(users.size()!=1){
                throw new Exception("用户名或者密码错误!");
            }
            TSysUser user = users.get(0);
            //user塞入session中
            session.setAttribute("user", user);
            //BASE_URL塞入session中,页面所有连接前加上BASE_URL 解决页面路径多层问题
            session.setAttribute("BASE_URL",request.getContextPath());

            TSysDepart depart = departService.selectByPrimaryKey(user.getDepartid());
            session.setAttribute("userDepart", depart);
            LogObjectHolder.me().set("user",user);
            //初始化菜单与权限
            initMenuHolder();
            result.setCode(Consts.SUCCESS);
            result.setMsg("登录成功!");
            result.setData(user);
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg(e.getMessage());
            //e.printStackTrace();
        }
        return result;
    }

    @ApiOperation("修改登录密码")
    @LogInfer(logModel = "修改登录密码", logType = "修改",remake = "修改登录密码",ID="account",objectKey = "user")
    @RequestMapping(value="/editPassword")
    @ResponseBody
    public HttpResult editPassword(ModelMap mm, HttpSession session, String oldPassword, String newPassword){
        HttpResult result = new HttpResult();
        try {
            TSysUserCriteria example = new TSysUserCriteria();
            if(StringUtils.isEmpty(getUser().getAccount())){
                throw new Exception("用户名不能为空!");
            }
            if(StringUtils.isEmpty(oldPassword)||StringUtils.isEmpty(newPassword)){
                throw new Exception("密码不能为空!");
            }
            example.createCriteria().andAccountEqualTo(getUser().getAccount()).andPasswordEqualTo(oldPassword);
            List<TSysUser> users = service.selectByExample(example);
            if(users.size()!=1){
                throw new Exception("旧密码不正确!");
            }
            TSysUser user = users.get(0);
            LogObjectHolder.me().set("user",user);
            user.setPassword(newPassword);
            service.updateByPrimaryKeySelective(user);
            result.setCode(Consts.SUCCESS);
            result.setMsg("登录成功!");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg(e.getMessage());
        }
        return result;
    }
    //无权限访问
    @ApiIgnore
    @RequestMapping(value="/noAuth",method = RequestMethod.GET)
    public String freeMarker(ModelMap mm){
        return "auth/noauth";
    }


    public void initMenuHolder(){
        
        List<TSysMenu> menuList = menuService.selectAllWithPermissionByUserGroupId(getUser().getUsergroupid());
//        PermissionHolder.me().setMenuList(menuList);
    	
        //存储 方便使用
//        List<TSysMenu> addMenuList = menuService.selectAllWithMenuByRoleId(getUser().getRoleid());
//        List<TSysMenu> menuList = menuService.selectAllWithPermissionByRoleId(getUser().getRoleid());
        
        PermissionHolder.me().setMenuList(menuList);
        
        
        for (TSysMenu menu:menuList) {
            //将查询出来的菜单列表转成HashMap存储 方便取出
            PermissionHolder.me().set(menu.getMenuurl(),menu);
        }
    }

    @ApiOperation("获取当前登录人的菜单")
    @RequestMapping(value="/menu.json",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object menu(){
        initMenuHolder();
        List<TSysMenu> menuList = PermissionHolder.me().getMenuList();
        List<LyingMenu> lyingMenus = new ArrayList<>();
        //第一层
        for (int i = 0; i < menuList.size(); i++) {
            if(menuList.get(i).getUpmenuid()==0){
                LyingMenu menu = new LyingMenu();
                menu.setHref(menuList.get(i).getMenuurl());
                menu.setIcon(menuList.get(i).getMenuicon());
                menu.setTitle(menuList.get(i).getMenuname());
                List<LyingMenu> lyingMenus1 = new ArrayList<>();
                //第二层
                for (int j = 0; j < menuList.size(); j++) {
                    if(menuList.get(j).getUpmenuid()==0){
                        continue;
                    }
                    if (menuList.get(j).getUpmenuid()==menuList.get(i).getId()){
                        LyingMenu menu1 = new LyingMenu();
                        menu1.setHref(menuList.get(j).getMenuurl());
                        menu1.setIcon(menuList.get(j).getMenuicon());
                        menu1.setTitle(menuList.get(j).getMenuname());
                        lyingMenus1.add(menu1);

                        List<LyingMenu> lyingMenus2 = new ArrayList<>();
                        //第三层
                        for(int k = 0; k < menuList.size(); k++){
                            if(menuList.get(j).getUpmenuid()==0){
                                continue;
                            }
                            if (menuList.get(k).getUpmenuid()==menuList.get(j).getId()){
                                LyingMenu menu2 = new LyingMenu();
                                menu2.setHref(menuList.get(k).getMenuurl());
                                menu2.setIcon(menuList.get(k).getMenuicon());
                                menu2.setTitle(menuList.get(k).getMenuname());
                                lyingMenus2.add(menu2);
                            }
                        }
                        menu1.setList(lyingMenus2);
                    }
                }
                menu.setList(lyingMenus1);
                lyingMenus.add(menu);
            }
        }

        return new Object[]{lyingMenus};
    }


    //导航-首页
    @ApiIgnore
    @RequestMapping(value="/newhomepage")
    public String newhomepage(ModelMap mm){
        return "newhomepage";
    }
    
    //人员管理
    @ApiIgnore
    @RequestMapping(value="/addpersonnel")
    public String addpersonnel(ModelMap mm){
        return "addpersonnel";
    }



    private String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json.toString();
    }






















}

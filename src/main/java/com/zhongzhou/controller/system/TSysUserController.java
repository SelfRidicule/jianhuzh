package com.zhongzhou.controller.system;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zhongzhou.utils.AccessToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import com.github.pagehelper.PageInfo;
import com.zhongzhou.entity.DepartOption;
import com.zhongzhou.entity.DepartVo;
import com.zhongzhou.entity.UserVo;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.entity.system.TSysRoleCriteria;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysUserCriteria;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.service.system.TSysDepartService;
import com.zhongzhou.service.system.TSysMenuService;
import com.zhongzhou.service.system.TSysRoleService;
import com.zhongzhou.service.system.TSysUserService;
import com.zhongzhou.service.system.TSysUsergroupService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags={"用户模块"})
@Controller
@RequestMapping(value="/sysuser")
public class TSysUserController {



    @Autowired
    private TSysUserService service;
    @Autowired
    private TSysMenuService menuService;
    @Autowired
    private TSysUsergroupService usergroupService;
    @Autowired
    private TSysDepartService departService;
    @Autowired
    private TSysRoleService roleService;
    @Autowired
    private TSysUserService tSysUserService;

    //用户列表页
    @ApiIgnore
    @RequestMapping(value="/list",method = RequestMethod.GET)
    public String usergrouplist(ModelMap mm){
        return "user/list";
    }

    //用户input页
    @ApiIgnore
    @RequestMapping(value="/input",method = RequestMethod.GET)
    public String usergroupInput(ModelMap mm,HttpServletRequest request){
        if(!StringUtils.isEmpty(request.getParameter("id"))){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mm.addAttribute("object",service.selectByPrimaryKey(id));
             
        }
        mm.addAttribute("usergroupList",usergroupService.selectByExample(new TSysUsergroupCriteria()));
        mm.addAttribute("departList",departService.selectByExample(new TSysDepartCriteria()));
        mm.addAttribute("roleList",roleService.selectByExample(new TSysRoleCriteria()));
        return "user/input";
    }

    @RequestMapping(value="/userList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult userList(String keyword ,Integer pageSize, Integer pageNum){
        return tSysUserService.pageList( keyword ,  pageSize,  pageNum);
    }

    @RequestMapping(value="/add",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult add(TSysUser user){

        //表单验证
        if(user == null || user.getAccount() == null){
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(Consts.ERROR);
            httpResult.setMsg("请填写帐号信息");
            return httpResult;
        }

        //判断帐号是否已经存在
        TSysUserCriteria tSysUserCriteria = new TSysUserCriteria();
        tSysUserCriteria.createCriteria().andAccountEqualTo(user.getAccount());
        List<TSysUser> sysUserList = tSysUserService.selectByExample(tSysUserCriteria);
        if(sysUserList != null && sysUserList.size() > 0){
            HttpResult httpResult = new HttpResult();
            httpResult.setCode(Consts.ERROR);
            httpResult.setMsg("帐号信息存在!");
            return httpResult;
        }

        //向数据库添加信息
        tSysUserService.insertSelective(user);

        HttpResult httpResult = new HttpResult();
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setMsg("操作成功");
        return httpResult;
    }

    @RequestMapping(value="/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult update(TSysUser user){

        //修改数据
        tSysUserService.updateByPrimaryKeySelective(user);

        HttpResult httpResult = new HttpResult();
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setMsg("操作成功");
        return httpResult;
    }

    @RequestMapping(value="/deleteId",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult deleteId(Integer id){

        //删除
        tSysUserService.deleteByPrimaryKey(id);

        HttpResult httpResult = new HttpResult();
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setMsg("操作成功");
        return httpResult;
    }

    @RequestMapping(value="/queryId",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult queryId(Integer id){

        //查询指定id
        TSysUser tSysUser = tSysUserService.selectByPrimaryKey(id);

        HttpResult httpResult = new HttpResult();
        httpResult.setData(tSysUser);
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setMsg("操作成功");
        return httpResult;
    }


    @ApiOperation("保存用户")
    @RequestMapping(value="/saveUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult saveUser(@ApiParam(required = true,value = "用户对象,有id为修改,无id为新增") TSysUser user){
        HttpResult result = new HttpResult();
        try{
            if (user==null||StringUtils.isEmpty(user.getAccount())) throw new Exception("参数错误!");
            //id为空则新增
            if(user.getId()==null||user.getId()==0){
                TSysUserCriteria criteria = new TSysUserCriteria();
                criteria.createCriteria().andAccountEqualTo(user.getAccount());
                List<TSysUser> list =service.selectByExample(criteria);
                if(list==null||list.size()!=0){
                    throw new Exception("已经存在的账号!");
                }
                user.setPassword(Consts.DEFAULT_PASSWORD);
                user = service.insertSelective(user);
            }else{
                //更新
                service.updateByPrimaryKeySelective(user);
            }
            //返回id
            result.setData(user.getId());
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("删除用户")
    @RequestMapping(value="/delUser",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult delUser(@ApiParam(required = true,value = "用户id数组")@RequestParam(value = "userIds[]")Integer[] userIds){
        HttpResult result = new HttpResult();
        try{
            List<Integer> ids = Arrays.asList(userIds);
            TSysUserCriteria criteria = new TSysUserCriteria();
            criteria.createCriteria().andIdIn(ids);
            service.deleteByExample(criteria);
            //返回id
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("重置用户密码")
    @RequestMapping(value="/resetPwd",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult resetPwd(@ApiParam(required = true,value = "用户id数组")@RequestParam(value = "userIds[]")Integer[] userIds){
        HttpResult result = new HttpResult();
        try{
            List<Integer> ids = Arrays.asList(userIds);
            TSysUserCriteria criteria = new TSysUserCriteria();
            criteria.createCriteria().andIdIn(ids);
            TSysUser user = new TSysUser();
            user.setPassword(Consts.DEFAULT_PASSWORD);
            service.updateByExampleSelective(user,criteria);
            //返回id
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }

    @RequestMapping(value="/queryDepartMans")
    public @ResponseBody HttpResult queryDepartMans(){
    	HttpResult hr=new HttpResult();
    	List<Object> resultlist=new ArrayList<Object>();
    	List<DepartVo> list=service.queryDepartMans();
    	for(DepartVo dv:list){
    		if(!dv.getChildren().isEmpty()){
    			DepartOption dpo=new DepartOption();
    			dpo.setName(dv.getName());
    			dpo.setType("optgroup");
    			resultlist.add(dpo);
    			for(UserVo uv:dv.getChildren()){
    				resultlist.add(uv);
    			}
    		}
    	}
    	hr.setCode(Consts.SUCCESS);
    	hr.setData(resultlist);
    	return hr;
    }
    
    
    
    
    /**
     * 用户注册
     * @throws Exception 
     */
    @RequestMapping(value="/mobile/selfRegister",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult selfRegister( HttpSession session , TSysUser user) throws Exception{
    	
    	
    	TSysUserCriteria criteria = new TSysUserCriteria();
        criteria.createCriteria().andPhoneEqualTo(user.getPhone());
        List<TSysUser> list =service.selectByExample(criteria);
        if(list==null||list.size()!=0){
            throw new Exception("已经存在手机号!");
        }

        //设置施工权限
        user.setRoleper(Consts.ROLE_CONSTRUC);
    	//通过手机注册的用户 状态设置为2 区分  
    	user.setStatus("2");
    	//设置默认账号
    	user.setAccount(UUID.randomUUID().toString().replaceAll("-",""));
    	
    	
    	tSysUserService.insertSelective(user);
    	
    	HttpResult hr=new HttpResult();
    	hr.setCode(Consts.SUCCESS);
    	hr.setMsg("操作成功");
    	hr.setData(user);
    	
    	return hr;
    }
    
    /**
     * 移动端 用户登录
     */
    @RequestMapping(value="/mobile/selfLogin",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult selfLogin( HttpSession session , HttpServletRequest request , TSysUser user){
    	 HttpResult result = new HttpResult();
         try {
             TSysUserCriteria example = new TSysUserCriteria();
            
             example.createCriteria().andPhoneEqualTo(user.getPhone()).andPasswordEqualTo(user.getPassword()).andStatusEqualTo("2");
             List<TSysUser> users = service.selectByExample(example);
             if(users.size()!=1){
                 throw new Exception("手机号码或密码不正确!");
             }
             TSysUser getUser = users.get(0);
             
             //user塞入session中
             session.setAttribute("user", getUser);
             //BASE_URL塞入session中,页面所有连接前加上BASE_URL 解决页面路径多层问题
             session.setAttribute("BASE_URL",request.getContextPath()+"/");
             
             result.setData(getUser);
             result.setCode(Consts.SUCCESS);
             result.setMsg("登录成功!");
         }catch (Exception e){
             result.setCode(Consts.ERROR);
             result.setMsg(e.getMessage());
         }
         return result;
    }
    
    
    /**
     * 移动端 用户验证
     */
    @RequestMapping(value="/mobile/selfVerify",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult selfVerify( HttpSession session , HttpServletRequest request , TSysUser user){
    	 HttpResult result = new HttpResult();
         try {
             TSysUserCriteria example = new TSysUserCriteria();
            
             example.createCriteria().andPhoneEqualTo(user.getPhone()).andUsernameEqualTo(user.getUsername());
             List<TSysUser> users = service.selectByExample(example);
             if(users.size()!=1){
                 throw new Exception("手机号码或密码不正确!");
             }
             
             
             //BASE_URL塞入session中,页面所有连接前加上BASE_URL 解决页面路径多层问题
             session.setAttribute("BASE_URL",request.getContextPath()+"/");
             
             result.setData(users.get(0));
             result.setCode(Consts.SUCCESS);
             result.setMsg("登录成功!");
         }catch (Exception e){
             result.setCode(Consts.ERROR);
             result.setMsg(e.getMessage());
         }
         return result;
    }
    
    
    /**
     * 移动端 用户重置密码
     */
    @RequestMapping(value="/mobile/selfResetPassword",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult selfResetPassword( HttpSession session , HttpServletRequest request , TSysUser user){
    	 HttpResult result = new HttpResult();
         try {
             TSysUserCriteria example = new TSysUserCriteria();
            
             example.createCriteria().andPhoneEqualTo(user.getPhone()).andUsernameEqualTo(user.getUsername());
             List<TSysUser> users = service.selectByExample(example);
             if(users.size()!=1){
                 throw new Exception("手机号码或密码不正确!");
             }
             
             //拿到查询的用户
             TSysUser isUser = users.get(0);
             
             //设置密码
             isUser.setPassword(user.getPassword());
             
             //更新用户
             service.updateByPrimaryKeySelective(isUser);
             
             
             //BASE_URL塞入session中,页面所有连接前加上BASE_URL 解决页面路径多层问题
             session.setAttribute("BASE_URL",request.getContextPath()+"/");
             
             result.setData(isUser);
             result.setCode(Consts.SUCCESS);
             result.setMsg("登录成功!");
         }catch (Exception e){
             result.setCode(Consts.ERROR);
             result.setMsg(e.getMessage());
         }
         return result;
    }


    private ObjectMapper mapper=new ObjectMapper();

    @CrossOrigin
    @RequestMapping(value="/weixin/indexredirects")
    public String indexredirects(HttpServletRequest request, HttpServletResponse response) {

        try {
//            System.out.println("------traffic微信服务器跳转进入接口------");
//            System.out.println("------请求方法------"+request.getMethod());
            HttpResult hr=new HttpResult();
            String code=request.getParameter("code");
//            System.out.println("------traffic获取到的code------"+code);
            String token= AccessToken.getAccessToken();
            String url = "https://qyapi.weixin.qq.com/cgi-bin/user/getuserinfo?access_token="+token+"&code="+code;
            String json = loadJson(url);
            JsonNode node = mapper.readTree(json);

            //判断是否成功 0成功
            if(node.get("errcode").asText().equals("0")){

                //当用户为企业成员
                if(node.get("UserId") != null){
                    String wxId = node.get("UserId").asText();
                    HttpSession session=request.getSession();


                    jumpWxView( session , response ,  wxId);
                }

            }
//            response.sendRedirect("http://jszzkj.cn/jxtraffics/");
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    //普通用户首页
    @CrossOrigin
    @RequestMapping("/weixin/construcWxLogin")
    public @ResponseBody String construcWxLogin(HttpServletRequest request , HttpSession session , HttpServletResponse response){

        String appId = "wx2f2988923f5f24f0";
        String appSecret = "79537c53617fbd4d1c9d2a6675a303e8";

        try {
            String code=request.getParameter("code");
            String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appId+"&secret="+appSecret+"&code="+code+"&grant_type=authorization_code";
            String json = loadJson(url);
            JsonNode node = mapper.readTree(json);
            String openid=node.get("openid").asText();

            if(openid!=null){
//                session.setAttribute("openid",openid);
                TSysUserCriteria example=new TSysUserCriteria();
                example.createCriteria().andWeixinidEqualTo(openid).andStatusEqualTo("3");   //3关注公众号的用户
                List<TSysUser> list=service.selectByExample(example);
                if(list.isEmpty()){
                    TSysUser user=new TSysUser();
                    user.setStatus("3");   //3标识关注服务号的用户
                    user.setAccount(openid);
                    user.setWeixinid(openid);
                    user.setUsername(openid);
                    user.setRoleper(Consts.ROLE_CONSTRUC);

                    service.insertSelective(user);
                    session.setAttribute("user",user);

                    response.sendRedirect("http://jszzkj.cn/jianhuzh/api/v1/yhsq");
                }else{

                    //是 施工权限
                    if(list.get(0).getRoleper() == Consts.ROLE_CONSTRUC){
                        session.setAttribute("user",list.get(0));

                        response.sendRedirect("http://jszzkj.cn/jianhuzh/api/v1/yhsq");
                    }

                }

                return "success";
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return "error";
    }



    /**
     * 跳转页面
     */
    public void jumpWxView(HttpSession session ,HttpServletResponse response , String wxId) throws IOException {

        TSysUserCriteria tSysUserCriteria = new TSysUserCriteria();
        tSysUserCriteria.createCriteria().andWeixinidEqualTo(wxId);

        List<TSysUser> list = tSysUserService.selectByExample(tSysUserCriteria);

        if(list != null && list.size() > 0){
            TSysUser user = list.get(0);

            //只有是交管或者城管才能进入页面
            if(user.getRoleper() == 2 || user.getRoleper() == 3){
                session.setAttribute("user", user);

                response.sendRedirect("http://jszzkj.cn/jianhuzh/api/v1/welcome");
            }
        }

    }


    private String loadJson (String url) {
        StringBuilder json = new StringBuilder();
        try {
            URL urlObject = new URL(url);
            URLConnection uc = urlObject.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"));
            String inputLine = null;
            while ( (inputLine = in.readLine()) != null) {
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

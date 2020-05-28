package com.zhongzhou.controller.system;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.annotations.ApiIgnore;
import com.zhongzhou.entity.system.*;
import com.zhongzhou.service.system.*;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhongzhou.entity.system.TSysRoleCriteria;
import com.zhongzhou.entity.system.TSysRoleMenuPermissionCriteria.Criteria;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.entity.system.TSysUsergroupRole;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Api(tags={"用户权限模块"})
@Controller
@RequestMapping(value="/permission")
public class PermissionController {

    @Autowired
    private TSysRoleService roleService;
    @Autowired
    private TSysRoleMenuService roleMenuService;
    @Autowired
    private TSysRoleMenuPermissionService roleMenuPermissionService;
    @Autowired
    private TSysUsergroupRoleService usergroupRoleService;
    @Autowired
    private TSysUsergroupService usergroupService;
    @Autowired
    private TSysCodeService codeService;
    @Autowired
    private TSysMenuService menuService;



    //角色管理
    @ApiIgnore
    @RequestMapping(value="/rolelist",method = RequestMethod.GET)
    public String freeMarker(ModelMap mm){
        return "role/list";
    }





    //角色管理
    @ApiIgnore
    @RequestMapping(value="/roleInput",method = RequestMethod.GET)
    public String roleInput(ModelMap mm,HttpServletRequest request){

        if(!StringUtils.isEmpty(request.getParameter("id"))){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mm.addAttribute("role",roleService.selectByPrimaryKey(id));
        }
        return "role/input";
    }

    //用户组列表页
    @ApiIgnore
    @RequestMapping(value="/usergrouplist",method = RequestMethod.GET)
    public String usergrouplist(ModelMap mm){
        return "usergroup/list";
    }

    //用户组input页
    @ApiIgnore
    @RequestMapping(value="/usergroupInput",method = RequestMethod.GET)
    public String usergroupInput(ModelMap mm,HttpServletRequest request){
        if(!StringUtils.isEmpty(request.getParameter("id"))){
            Integer id = Integer.parseInt(request.getParameter("id"));
            mm.addAttribute("object",usergroupService.selectByPrimaryKey(id));
        }
        mm.addAttribute("roleList",roleService.selectByExample(new TSysRoleCriteria()));
        return "usergroup/input";
    }

    @ApiOperation("角色列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "一页多少条数据"),@ApiImplicitParam(name = "pageNum", value = "第几页"),@ApiImplicitParam(name = "search", value = "搜索字段")})
    @RequestMapping(value="/roleList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult roleList(Integer pageSize,Integer pageNum,String search){
        HttpResult result = new HttpResult();
        try{
            TSysRoleCriteria criteria = new TSysRoleCriteria();
            if(search!=null&&!search.equals("")){
                criteria.createCriteria().andRolenameLike(search);
            }
            PageInfo info = roleService.selectByExample(criteria,pageSize,pageNum);
            result.setCount(info.getTotal());
            result.setData(info.getList());
            result.setCode(Consts.SUCCESS);
            result.setMsg("获取成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("获取失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("用户组列表")
    @ApiImplicitParams({@ApiImplicitParam(name = "pageSize", value = "一页多少条数据"),@ApiImplicitParam(name = "pageNum", value = "第几页"),@ApiImplicitParam(name = "search", value = "搜索字段")})
    @RequestMapping(value="/usergroupList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult usergroupList(Integer pageSize,Integer pageNum,String search){
        HttpResult result = new HttpResult();
        try{
            TSysUsergroupCriteria criteria = new TSysUsergroupCriteria();
            if(search!=null&&!search.equals("")){
                criteria.createCriteria().andUsergroupnameLike(search);
            }
            PageInfo info = usergroupService.selectByExample(criteria,pageSize,pageNum);
            result.setCount(info.getTotal());
            result.setData(info.getList());
            result.setCode(Consts.SUCCESS);
            result.setMsg("获取成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("获取失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("用户组拥有的角色列表")
    @ApiImplicitParam(name = "id", value = "用户组id")
    @RequestMapping(value="/usergroupRoleList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult usergroupRoleList(Integer id){
        HttpResult result = new HttpResult();
        try{
            TSysUsergroupRoleCriteria criteria = new TSysUsergroupRoleCriteria();
            criteria.createCriteria().andUsergroupidEqualTo(id);
            result.setData(usergroupRoleService.selectByExample(criteria));
            result.setCode(Consts.SUCCESS);
            result.setMsg("获取成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("获取失败!"+e.getMessage());
        }
        return result;
    }


    @ApiOperation("更新角色的菜单")
    @RequestMapping(value="/updateRoleAndMenu",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object updateRoleAndMenu(@ApiParam(required = true,value="角色对象") TSysRole role, @ApiParam(required = true,value="菜单id数组")@RequestParam(value = "menuIds[]")Integer[] menuIds){
        HttpResult result = new HttpResult();
        try{
            if (role==null) throw new Exception("参数错误!");
            //如果roleid为0或者为空 则需要新增role
            if(role.getId()==null||role.getId()==0){
                role.setCreatetime(new Date());
                role = roleService.insertSelective(role);
            }else{
                //如果不是新建的角色,新增菜单关联之前先删除之前的关联
                TSysRoleMenuCriteria criteria = new TSysRoleMenuCriteria();
                criteria.createCriteria().andRoleidEqualTo(role.getId());
                roleMenuService.deleteByExample(criteria);
                //删除 菜单权限关联表时 应该保持原来的权限不动 删除不存在的菜单即可
                //第一步,查出原有的菜单 oldmenulist
                //第二步,对比前端传来的 newmenulist
                //第三步,删除多余的菜单 delmenulist = oldmenulist-newmenulist
                List<TSysMenu> oldmenulist = menuService.selectAllGroupByMenuIDRoleId(role.getId());
                List<Integer> delmenuidlist  = new ArrayList<>();
                if(oldmenulist!=null&&oldmenulist.size()>0){
                    List<Integer> newmenulist = Arrays.asList(menuIds);
                    for (TSysMenu old:oldmenulist){
                        //如果新的菜单id中不存在 旧的 说明这个菜单被删除了
                        if(!newmenulist.contains(old.getId())){
                            delmenuidlist.add(old.getId());
                        }
                    }
                }
                TSysRoleMenuPermissionCriteria criteria1 = new TSysRoleMenuPermissionCriteria();
                Criteria cri = criteria1.createCriteria();
                cri.andRoleidEqualTo(role.getId());
                if(delmenuidlist != null && delmenuidlist.size()>0) {
                	cri.andMenuidIn(delmenuidlist);
                }
                
                
                roleMenuPermissionService.deleteByExample(criteria1);
                //更新role其他字段
                role.setCreatetime(new Date());
                roleService.updateByPrimaryKey(role);
            }

            //插入role_menu关联表
            List<TSysRoleMenu> roleMenus = new ArrayList<>();
            //插入role_menu_permission关联表
            List<TSysRoleMenuPermission> permissionList = new ArrayList<>();
            for (Integer menuId:menuIds) {
                TSysRoleMenu roleMenu = new TSysRoleMenu();
                TSysRoleMenuPermission permission = new TSysRoleMenuPermission();
                roleMenu.setMenuid(menuId);
                roleMenu.setRoleid(role.getId());
                roleMenus.add(roleMenu);

                permission.setRoleid(role.getId());
                permission.setMenuid(menuId);
                permissionList.add(permission);
            }
            roleMenuService.insertBatchSelective(roleMenus);
            roleMenuPermissionService.insertBatchSelective(permissionList);

            //返回roleid
            result.setData(role.getId());
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }

    @ApiOperation("更新用户组与用户组拥有的角色")
    @RequestMapping(value="/updateUsergroupAndRole",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Object updateRoleAndMenu(@ApiParam(required = true,value = "用户组对象") TSysUsergroup object,@ApiParam(required = true,value = "角色id数组")@RequestParam(value = "roleIds[]")Integer[] roleIds){
        HttpResult result = new HttpResult();
        try{
            //判断传进来的值是对的
            if (object==null) throw new Exception("参数错误!");
            //如果id为0或者为空 则需要新增
            if(object.getId()==null||object.getId()==0){
                object.setCreatetime(new Date());
                object = usergroupService.insertSelective(object);
            }else{
                //如果不是新建的用户组,新增角色关联之前先删除之前的关联
                TSysUsergroupRoleCriteria criteria = new TSysUsergroupRoleCriteria();
                criteria.createCriteria().andUsergroupidEqualTo(object.getId());
                usergroupRoleService.deleteByExample(criteria);
            }

            //插入usergroup_Role关联表
            List<TSysUsergroupRole> usergroupRoles = new ArrayList<>();
            for (Integer roleId:roleIds) {
                TSysUsergroupRole usergroupRole = new TSysUsergroupRole();
                usergroupRole.setUsergroupid(object.getId());
                usergroupRole.setRoleid(roleId);
                usergroupRoles.add(usergroupRole);
            }
            usergroupRoleService.insertBatchSelective(usergroupRoles);
            //返回id
            result.setData(object.getId());
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }

    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "角色id")
    @RequestMapping(value="/deleteRole",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult deleteRole(Integer roleId){
        HttpResult result = new HttpResult();
        try{
            roleService.deleteByPrimaryKey(roleId);
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功!");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }
    @ApiOperation("删除用户组")
    @ApiImplicitParam(name = "id", value = "用户组id")
    @RequestMapping(value="/deleteUsergroup",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult deleteUsergroup(Integer id){
        HttpResult result = new HttpResult();
        try{
            usergroupService.deleteByPrimaryKey(id);
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功!");
        }catch (Exception e){
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败!"+e.getMessage());
        }
        return result;
    }
}

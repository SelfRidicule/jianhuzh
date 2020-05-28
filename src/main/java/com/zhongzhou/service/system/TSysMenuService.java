package com.zhongzhou.service.system;

import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface TSysMenuService {
    int countByExample(TSysMenuCriteria example);

    TSysMenu selectByPrimaryKey(Integer id);

    List<TSysMenu> selectByExample(TSysMenuCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysMenu record);

    int updateByPrimaryKey(TSysMenu record);

    int deleteByExample(TSysMenuCriteria example);

    int updateByExampleSelective(TSysMenu record, TSysMenuCriteria example);

    int updateByExample(TSysMenu record, TSysMenuCriteria example);

    int insert(TSysMenu record);

    TSysMenu insertSelective(TSysMenu record);

    List<TSysMenu> selectAllWithPermissionByUserGroupId(Integer userGroupId);

    List<TSysMenu> selectAllWithPermissionByRoleId(Integer roleId);

    List<TSysMenu> selectAllGroupByMenuIDRoleId(Integer roleId);

    List<TSysMenu> selectRoleMenusInAllMenusByUpId(Integer roleId, Integer upId);


    List<TSysMenu> selectAllWithMenuByRoleId( Integer roleid);
}



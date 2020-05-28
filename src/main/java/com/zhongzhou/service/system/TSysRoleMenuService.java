package com.zhongzhou.service.system;

import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;
import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;
import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;

import java.util.List;

public interface TSysRoleMenuService {
    int countByExample(TSysRoleMenuCriteria example);

    TSysRoleMenu selectByPrimaryKey(Integer id);

    List<TSysRoleMenu> selectByExample(TSysRoleMenuCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysRoleMenu record);

    int updateByPrimaryKey(TSysRoleMenu record);

    int deleteByExample(TSysRoleMenuCriteria example);

    int updateByExampleSelective(TSysRoleMenu record, TSysRoleMenuCriteria example);

    int updateByExample(TSysRoleMenu record, TSysRoleMenuCriteria example);

    int insert(TSysRoleMenu record);

    int insertSelective(TSysRoleMenu record);

    int insertBatchSelective(List<TSysRoleMenu> records);
}
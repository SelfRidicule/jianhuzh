package com.zhongzhou.service.system;

import com.zhongzhou.entity.system.TSysRoleMenuPermission;
import com.zhongzhou.entity.system.TSysRoleMenuPermissionCriteria;
import com.zhongzhou.entity.system.TSysRoleMenuPermission;
import com.zhongzhou.entity.system.TSysRoleMenuPermissionCriteria;

import java.util.List;

public interface TSysRoleMenuPermissionService {
    int countByExample(TSysRoleMenuPermissionCriteria example);

    TSysRoleMenuPermission selectByPrimaryKey(Integer id);

    List<TSysRoleMenuPermission> selectByExample(TSysRoleMenuPermissionCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysRoleMenuPermission record);

    int updateByPrimaryKey(TSysRoleMenuPermission record);

    int deleteByExample(TSysRoleMenuPermissionCriteria example);

    int updateByExampleSelective(TSysRoleMenuPermission record, TSysRoleMenuPermissionCriteria example);

    int updateByExample(TSysRoleMenuPermission record, TSysRoleMenuPermissionCriteria example);

    int insert(TSysRoleMenuPermission record);

    int insertSelective(TSysRoleMenuPermission record);

    /**
     * 添加List集合对象对应字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatchSelective(List<TSysRoleMenuPermission> record);
}
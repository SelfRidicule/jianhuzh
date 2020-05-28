package com.zhongzhou.service.system;

import com.zhongzhou.entity.system.TSysUsergroupRole;
import com.zhongzhou.entity.system.TSysUsergroupRoleCriteria;
import com.zhongzhou.entity.system.TSysUsergroupRole;
import com.zhongzhou.entity.system.TSysUsergroupRoleCriteria;
import com.zhongzhou.entity.system.TSysUsergroupRole;

import java.util.List;

public interface TSysUsergroupRoleService {
    int countByExample(TSysUsergroupRoleCriteria example);

    TSysUsergroupRole selectByPrimaryKey(Integer id);

    List<TSysUsergroupRole> selectByExample(TSysUsergroupRoleCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysUsergroupRole record);

    int updateByPrimaryKey(TSysUsergroupRole record);

    int deleteByExample(TSysUsergroupRoleCriteria example);

    int updateByExampleSelective(TSysUsergroupRole record, TSysUsergroupRoleCriteria example);

    int updateByExample(TSysUsergroupRole record, TSysUsergroupRoleCriteria example);

    int insert(TSysUsergroupRole record);

    int insertSelective(TSysUsergroupRole record);

    /**
     * 添加List集合对象对应字段
     * @param record 批量插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertBatchSelective(List<TSysUsergroupRole> record);
}
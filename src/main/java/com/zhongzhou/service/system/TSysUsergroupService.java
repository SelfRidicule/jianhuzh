package com.zhongzhou.service.system;

import com.github.pagehelper.PageInfo;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;

import java.util.List;

public interface TSysUsergroupService {
    int countByExample(TSysUsergroupCriteria example);

    TSysUsergroup selectByPrimaryKey(Integer id);

    List<TSysUsergroup> selectByExample(TSysUsergroupCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysUsergroup record);

    int updateByPrimaryKey(TSysUsergroup record);

    int deleteByExample(TSysUsergroupCriteria example);

    int updateByExampleSelective(TSysUsergroup record, TSysUsergroupCriteria example);

    int updateByExample(TSysUsergroup record, TSysUsergroupCriteria example);

    int insert(TSysUsergroup record);

    TSysUsergroup insertSelective(TSysUsergroup record);

    PageInfo selectByExample(TSysUsergroupCriteria example, Integer pageSize, Integer pageNum);
}
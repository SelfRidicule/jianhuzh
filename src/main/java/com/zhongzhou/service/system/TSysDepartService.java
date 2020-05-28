package com.zhongzhou.service.system;

import com.github.pagehelper.PageInfo;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;

import java.util.List;

public interface TSysDepartService {
    int countByExample(TSysDepartCriteria example);

    TSysDepart selectByPrimaryKey(Integer id);

    List<TSysDepart> selectByExample(TSysDepartCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysDepart record);

    int updateByPrimaryKey(TSysDepart record);

    int deleteByExample(TSysDepartCriteria example);

    int updateByExampleSelective(TSysDepart record, TSysDepartCriteria example);

    int updateByExample(TSysDepart record, TSysDepartCriteria example);

    int insert(TSysDepart record);

    TSysDepart insertSelective(TSysDepart record);

    PageInfo selectByExample(TSysDepartCriteria example, Integer pageSize, Integer pageNum);
}
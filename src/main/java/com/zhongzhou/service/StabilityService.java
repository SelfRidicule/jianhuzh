package com.zhongzhou.service;

import com.zhongzhou.entity.StabilityCriteria;
import com.zhongzhou.entity.Stability;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface StabilityService {
    int countByExample(StabilityCriteria example);

    Stability selectByPrimaryKey(Integer id);

    List<Stability> selectByExample(StabilityCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Stability record);

    int updateByPrimaryKey(Stability record);

    int deleteByExample(StabilityCriteria example);

    int updateByExampleSelective(Stability record, StabilityCriteria example);

    int updateByExample(Stability record, StabilityCriteria example);

    int insert(Stability record);

    int insertSelective(Stability record);


    /**
     * 后台 数据列表
     */

    HttpResult dataPageList(String keyword , Integer pageNum, Integer pageSize , Integer policestationid) ;
}
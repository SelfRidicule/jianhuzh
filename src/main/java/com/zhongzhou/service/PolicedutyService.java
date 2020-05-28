package com.zhongzhou.service;

import com.zhongzhou.entity.PolicedutyCriteria;
import com.zhongzhou.entity.Policeduty;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface PolicedutyService {
    int countByExample(PolicedutyCriteria example);

    Policeduty selectByPrimaryKey(Integer id);

    List<Policeduty> selectByExample(PolicedutyCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Policeduty record);

    int updateByPrimaryKey(Policeduty record);

    int deleteByExample(PolicedutyCriteria example);

    int updateByExampleSelective(Policeduty record, PolicedutyCriteria example);

    int updateByExample(Policeduty record, PolicedutyCriteria example);

    int insert(Policeduty record);

    int insertSelective(Policeduty record);

    /**
     * 后台 数据列表
     */

    HttpResult dataPageList(String keyword ,String status, Integer pageNum, Integer pageSize , Integer policestationid) ;
}
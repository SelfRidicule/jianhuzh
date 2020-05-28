package com.zhongzhou.service;

import com.zhongzhou.entity.PolicestationCriteria;
import com.zhongzhou.entity.Policestation;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface PolicestationService {
    int countByExample(PolicestationCriteria example);

    Policestation selectByPrimaryKey(Integer id);

    List<Policestation> selectByExample(PolicestationCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Policestation record);

    int updateByPrimaryKey(Policestation record);

    int deleteByExample(PolicestationCriteria example);

    int updateByExampleSelective(Policestation record, PolicestationCriteria example);

    int updateByExample(Policestation record, PolicestationCriteria example);

    int insert(Policestation record);

    int insertSelective(Policestation record);

    /**
     * 后台 数据列表
     */

    HttpResult dataPageList(String keyword , Integer pageNum, Integer pageSize , String code) ;
}
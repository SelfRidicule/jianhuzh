package com.zhongzhou.service;

import com.zhongzhou.entity.PublicsentimentCriteria;
import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface PublicsentimentService {
    int countByExample(PublicsentimentCriteria example);

    Publicsentiment selectByPrimaryKey(Integer id);

    List<Publicsentiment> selectByExample(PublicsentimentCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Publicsentiment record);

    int updateByPrimaryKey(Publicsentiment record);

    int deleteByExample(PublicsentimentCriteria example);

    int updateByExampleSelective(Publicsentiment record, PublicsentimentCriteria example);

    int updateByExample(Publicsentiment record, PublicsentimentCriteria example);

    int insert(Publicsentiment record);

    int insertSelective(Publicsentiment record);

    /**
     * 后台 数据列表
     */

    HttpResult dataPageList(String keyword , Integer pageNum, Integer pageSize , Integer policestationid) ;
}
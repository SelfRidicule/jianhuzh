package com.zhongzhou.service;

import com.zhongzhou.entity.MainpersonCriteria;
import com.zhongzhou.entity.Mainperson;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface MainpersonService {
    int countByExample(MainpersonCriteria example);

    Mainperson selectByPrimaryKey(Integer id);

    List<Mainperson> selectByExample(MainpersonCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mainperson record);

    int updateByPrimaryKey(Mainperson record);

    int deleteByExample(MainpersonCriteria example);

    int updateByExampleSelective(Mainperson record, MainpersonCriteria example);

    int updateByExample(Mainperson record, MainpersonCriteria example);

    int insert(Mainperson record);

    int insertSelective(Mainperson record);


    HttpResult dataPageList(Integer pageNum, Integer pageSize, String keyword, String policecode);

}
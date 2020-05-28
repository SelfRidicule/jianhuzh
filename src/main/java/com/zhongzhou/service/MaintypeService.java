package com.zhongzhou.service;

import com.zhongzhou.entity.MaintypeCriteria;
import com.zhongzhou.entity.Maintype;
import java.util.List;

public interface MaintypeService {
    int countByExample(MaintypeCriteria example);

    Maintype selectByPrimaryKey(Integer id);

    List<Maintype> selectByExample(MaintypeCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Maintype record);

    int updateByPrimaryKey(Maintype record);

    int deleteByExample(MaintypeCriteria example);

    int updateByExampleSelective(Maintype record, MaintypeCriteria example);

    int updateByExample(Maintype record, MaintypeCriteria example);

    int insert(Maintype record);

    int insertSelective(Maintype record);
}
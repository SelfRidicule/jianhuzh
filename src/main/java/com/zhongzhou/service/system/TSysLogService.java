package com.zhongzhou.service.system;

import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;
import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;
import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;

import java.util.List;

public interface TSysLogService {
    int countByExample(TSysLogCriteria example);

    TSysLog selectByPrimaryKey(Long id);

    List<TSysLog> selectByExample(TSysLogCriteria example);

    int deleteByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TSysLog record);

    int updateByPrimaryKey(TSysLog record);

    int deleteByExample(TSysLogCriteria example);

    int updateByExampleSelective(TSysLog record, TSysLogCriteria example);

    int updateByExample(TSysLog record, TSysLogCriteria example);

    int insert(TSysLog record);

    int insertSelective(TSysLog record);
}
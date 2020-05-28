package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysLogDAO;
import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;
import com.zhongzhou.service.system.TSysLogService;
import com.zhongzhou.dao.system.TSysLogDAO;
import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;
import com.zhongzhou.service.system.TSysLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysLog;
import com.zhongzhou.entity.system.TSysLogCriteria;
import com.zhongzhou.service.system.TSysLogService;

import java.util.List;

@Service
public class TSysLogServiceImpl implements TSysLogService {
    @Autowired
    private TSysLogDAO tSysLogDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysLogServiceImpl.class);

    public int countByExample(TSysLogCriteria example) {
        int count = this.tSysLogDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysLog selectByPrimaryKey(Long id) {
        return this.tSysLogDAO.selectByPrimaryKey(id);
    }

    public List<TSysLog> selectByExample(TSysLogCriteria example) {
        return this.tSysLogDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Long id) {
        return this.tSysLogDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysLog record) {
        return this.tSysLogDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysLog record) {
        return this.tSysLogDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysLogCriteria example) {
        return this.tSysLogDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysLog record, TSysLogCriteria example) {
        return this.tSysLogDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysLog record, TSysLogCriteria example) {
        return this.tSysLogDAO.updateByExample(record, example);
    }

    public int insert(TSysLog record) {
        return this.tSysLogDAO.insert(record);
    }

    public int insertSelective(TSysLog record) {
        return this.tSysLogDAO.insertSelective(record);
    }
}
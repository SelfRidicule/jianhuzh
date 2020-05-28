package com.zhongzhou.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.system.TSysCodeDAO;
import com.zhongzhou.entity.system.TSysCode;
import com.zhongzhou.entity.system.TSysCodeCriteria;
import com.zhongzhou.service.system.TSysCodeService;
import com.zhongzhou.dao.system.TSysCodeDAO;
import com.zhongzhou.entity.system.TSysCode;
import com.zhongzhou.entity.system.TSysCodeCriteria;
import com.zhongzhou.service.system.TSysCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysCode;
import com.zhongzhou.entity.system.TSysCodeCriteria;
import com.zhongzhou.service.system.TSysCodeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class TSysCodeServiceImpl implements TSysCodeService {
    @Autowired
    private TSysCodeDAO tSysCodeDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysCodeServiceImpl.class);

    public int countByExample(TSysCodeCriteria example) {
        int count = this.tSysCodeDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysCode selectByPrimaryKey(Integer id) {
        return this.tSysCodeDAO.selectByPrimaryKey(id);
    }

    public List<TSysCode> selectByExample(TSysCodeCriteria example) {
        return this.tSysCodeDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysCodeDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysCode record) {
        return this.tSysCodeDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysCode record) {
        return this.tSysCodeDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysCodeCriteria example) {
        return this.tSysCodeDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysCode record, TSysCodeCriteria example) {
        return this.tSysCodeDAO.updateByExampleSelective(record, example);
    }

    
    public int updateByExample(TSysCode record, TSysCodeCriteria example) {
        return this.tSysCodeDAO.updateByExample(record, example);
    }

    public int insert(TSysCode record) {
        return this.tSysCodeDAO.insert(record);
    }

    public TSysCode insertSelective(TSysCode record) {
        this.tSysCodeDAO.insertSelective(record);
        return record;
    }
    
    
  
    
    
    
    
    
    
    @Override
    public PageInfo selectByExample(TSysCodeCriteria example, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<TSysCode> list = tSysCodeDAO.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        return page;
    }

	
}
package com.zhongzhou.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.system.TSysUsergroupDAO;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.service.system.TSysUsergroupService;
import com.zhongzhou.dao.system.TSysUsergroupDAO;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.service.system.TSysUsergroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysUsergroup;
import com.zhongzhou.entity.system.TSysUsergroupCriteria;
import com.zhongzhou.service.system.TSysUsergroupService;

import java.util.List;

@Service
public class TSysUsergroupServiceImpl implements TSysUsergroupService {
    @Autowired
    private TSysUsergroupDAO tSysUsergroupDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysUsergroupServiceImpl.class);

    public int countByExample(TSysUsergroupCriteria example) {
        int count = this.tSysUsergroupDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysUsergroup selectByPrimaryKey(Integer id) {
        return this.tSysUsergroupDAO.selectByPrimaryKey(id);
    }

    public List<TSysUsergroup> selectByExample(TSysUsergroupCriteria example) {
        return this.tSysUsergroupDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysUsergroupDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysUsergroup record) {
        return this.tSysUsergroupDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysUsergroup record) {
        return this.tSysUsergroupDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysUsergroupCriteria example) {
        return this.tSysUsergroupDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysUsergroup record, TSysUsergroupCriteria example) {
        return this.tSysUsergroupDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysUsergroup record, TSysUsergroupCriteria example) {
        return this.tSysUsergroupDAO.updateByExample(record, example);
    }

    public int insert(TSysUsergroup record) {
        return this.tSysUsergroupDAO.insert(record);
    }

    public TSysUsergroup insertSelective(TSysUsergroup record) {
        this.tSysUsergroupDAO.insertSelective(record);
        return record;
    }

    @Override
    public PageInfo selectByExample(TSysUsergroupCriteria example, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<TSysUsergroup> list = tSysUsergroupDAO.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        return page;
    }
}
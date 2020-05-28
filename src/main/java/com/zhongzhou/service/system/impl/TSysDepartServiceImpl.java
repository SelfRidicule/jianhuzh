package com.zhongzhou.service.system.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.system.TSysDepartDAO;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.service.system.TSysDepartService;
import com.zhongzhou.dao.system.TSysDepartDAO;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.service.system.TSysDepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysDepart;
import com.zhongzhou.entity.system.TSysDepartCriteria;
import com.zhongzhou.service.system.TSysDepartService;

import java.util.List;

@Service
public class TSysDepartServiceImpl implements TSysDepartService {
    @Autowired
    private TSysDepartDAO tSysDepartDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysDepartServiceImpl.class);

    public int countByExample(TSysDepartCriteria example) {
        int count = this.tSysDepartDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysDepart selectByPrimaryKey(Integer id) {
        return this.tSysDepartDAO.selectByPrimaryKey(id);
    }

    public List<TSysDepart> selectByExample(TSysDepartCriteria example) {
        return this.tSysDepartDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysDepartDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysDepart record) {
        return this.tSysDepartDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysDepart record) {
        return this.tSysDepartDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysDepartCriteria example) {
        return this.tSysDepartDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysDepart record, TSysDepartCriteria example) {
        return this.tSysDepartDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysDepart record, TSysDepartCriteria example) {
        return this.tSysDepartDAO.updateByExample(record, example);
    }

    public int insert(TSysDepart record) {
        return this.tSysDepartDAO.insert(record);
    }

    public TSysDepart insertSelective(TSysDepart record) {
        this.tSysDepartDAO.insertSelective(record);
        return record;
    }

    @Override
    public PageInfo selectByExample(TSysDepartCriteria example, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<TSysDepart> list = tSysDepartDAO.selectByExample(example);
        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);
        return page;
    }
}
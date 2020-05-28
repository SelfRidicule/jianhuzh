package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysUsergroupRoleDAO;
import com.zhongzhou.entity.system.TSysUsergroupRole;
import com.zhongzhou.entity.system.TSysUsergroupRoleCriteria;
import com.zhongzhou.service.system.TSysUsergroupRoleService;
import com.zhongzhou.dao.system.TSysUsergroupRoleDAO;
import com.zhongzhou.entity.system.TSysUsergroupRole;
import com.zhongzhou.entity.system.TSysUsergroupRoleCriteria;
import com.zhongzhou.service.system.TSysUsergroupRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysUsergroupRole;
import com.zhongzhou.service.system.TSysUsergroupRoleService;

import java.util.List;

@Service
public class TSysUsergroupRoleServiceImpl implements TSysUsergroupRoleService {
    @Autowired
    private TSysUsergroupRoleDAO tSysUsergroupRoleDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysUsergroupRoleServiceImpl.class);

    public int countByExample(TSysUsergroupRoleCriteria example) {
        int count = this.tSysUsergroupRoleDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysUsergroupRole selectByPrimaryKey(Integer id) {
        return this.tSysUsergroupRoleDAO.selectByPrimaryKey(id);
    }

    public List<TSysUsergroupRole> selectByExample(TSysUsergroupRoleCriteria example) {
        return this.tSysUsergroupRoleDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysUsergroupRoleDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysUsergroupRole record) {
        return this.tSysUsergroupRoleDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysUsergroupRole record) {
        return this.tSysUsergroupRoleDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysUsergroupRoleCriteria example) {
        return this.tSysUsergroupRoleDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysUsergroupRole record, TSysUsergroupRoleCriteria example) {
        return this.tSysUsergroupRoleDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysUsergroupRole record, TSysUsergroupRoleCriteria example) {
        return this.tSysUsergroupRoleDAO.updateByExample(record, example);
    }

    public int insert(TSysUsergroupRole record) {
        return this.tSysUsergroupRoleDAO.insert(record);
    }

    public int insertSelective(TSysUsergroupRole record) {
        return this.tSysUsergroupRoleDAO.insertSelective(record);
    }

    @Override
    public int insertBatchSelective(List<TSysUsergroupRole> record) {
        return tSysUsergroupRoleDAO.insertBatchSelective(record);
    }
}
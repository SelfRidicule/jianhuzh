package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysRoleMenuDAO;
import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;
import com.zhongzhou.service.system.TSysRoleMenuService;
import com.zhongzhou.dao.system.TSysRoleMenuDAO;
import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;
import com.zhongzhou.service.system.TSysRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysRoleMenu;
import com.zhongzhou.entity.system.TSysRoleMenuCriteria;
import com.zhongzhou.service.system.TSysRoleMenuService;

import java.util.List;

@Service
public class TSysRoleMenuServiceImpl implements TSysRoleMenuService {
    @Autowired
    private TSysRoleMenuDAO tSysRoleMenuDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysRoleMenuServiceImpl.class);

    public int countByExample(TSysRoleMenuCriteria example) {
        int count = this.tSysRoleMenuDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysRoleMenu selectByPrimaryKey(Integer id) {
        return this.tSysRoleMenuDAO.selectByPrimaryKey(id);
    }

    public List<TSysRoleMenu> selectByExample(TSysRoleMenuCriteria example) {
        return this.tSysRoleMenuDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysRoleMenuDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysRoleMenu record) {
        return this.tSysRoleMenuDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysRoleMenu record) {
        return this.tSysRoleMenuDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysRoleMenuCriteria example) {
        return this.tSysRoleMenuDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysRoleMenu record, TSysRoleMenuCriteria example) {
        return this.tSysRoleMenuDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysRoleMenu record, TSysRoleMenuCriteria example) {
        return this.tSysRoleMenuDAO.updateByExample(record, example);
    }

    public int insert(TSysRoleMenu record) {
        return this.tSysRoleMenuDAO.insert(record);
    }

    public int insertSelective(TSysRoleMenu record) {
        return this.tSysRoleMenuDAO.insertSelective(record);
    }

    @Override
    public int insertBatchSelective(List<TSysRoleMenu> records) {
        return tSysRoleMenuDAO.insertBatchSelective(records);
    }
}
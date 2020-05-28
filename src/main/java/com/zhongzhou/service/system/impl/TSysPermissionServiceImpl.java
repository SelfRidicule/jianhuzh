package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysPermissionDAO;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.entity.system.TSysPermissionCriteria;
import com.zhongzhou.service.system.TSysPermissionService;
import com.zhongzhou.dao.system.TSysPermissionDAO;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.entity.system.TSysPermissionCriteria;
import com.zhongzhou.service.system.TSysPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysPermission;
import com.zhongzhou.entity.system.TSysPermissionCriteria;
import com.zhongzhou.service.system.TSysPermissionService;

import java.util.List;

@Service
public class TSysPermissionServiceImpl implements TSysPermissionService {
    @Autowired
    private TSysPermissionDAO tSysPermissionDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysPermissionServiceImpl.class);

    public int countByExample(TSysPermissionCriteria example) {
        int count = this.tSysPermissionDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysPermission selectByPrimaryKey(Integer id) {
        return this.tSysPermissionDAO.selectByPrimaryKey(id);
    }

    public List<TSysPermission> selectByExample(TSysPermissionCriteria example) {
        return this.tSysPermissionDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysPermissionDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysPermission record) {
        return this.tSysPermissionDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysPermission record) {
        return this.tSysPermissionDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysPermissionCriteria example) {
        return this.tSysPermissionDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysPermission record, TSysPermissionCriteria example) {
        return this.tSysPermissionDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysPermission record, TSysPermissionCriteria example) {
        return this.tSysPermissionDAO.updateByExample(record, example);
    }

    public int insert(TSysPermission record) {
        return this.tSysPermissionDAO.insert(record);
    }

    public int insertSelective(TSysPermission record) {
        return this.tSysPermissionDAO.insertSelective(record);
    }
}
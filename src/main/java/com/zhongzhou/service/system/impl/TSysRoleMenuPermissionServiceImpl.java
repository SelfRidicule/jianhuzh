package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysRoleMenuPermissionDAO;
import com.zhongzhou.entity.system.TSysRoleMenuPermission;
import com.zhongzhou.entity.system.TSysRoleMenuPermissionCriteria;
import com.zhongzhou.service.system.TSysRoleMenuPermissionService;
import com.zhongzhou.dao.system.TSysRoleMenuPermissionDAO;
import com.zhongzhou.entity.system.TSysRoleMenuPermission;
import com.zhongzhou.entity.system.TSysRoleMenuPermissionCriteria;
import com.zhongzhou.service.system.TSysRoleMenuPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.service.system.TSysRoleMenuPermissionService;

import java.util.List;

@Service
public class TSysRoleMenuPermissionServiceImpl implements TSysRoleMenuPermissionService {
    @Autowired
    private TSysRoleMenuPermissionDAO tSysRoleMenuPermissionDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysRoleMenuPermissionServiceImpl.class);

    public int countByExample(TSysRoleMenuPermissionCriteria example) {
        int count = this.tSysRoleMenuPermissionDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysRoleMenuPermission selectByPrimaryKey(Integer id) {
        return this.tSysRoleMenuPermissionDAO.selectByPrimaryKey(id);
    }

    public List<TSysRoleMenuPermission> selectByExample(TSysRoleMenuPermissionCriteria example) {
        return this.tSysRoleMenuPermissionDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysRoleMenuPermissionDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysRoleMenuPermission record) {
        return this.tSysRoleMenuPermissionDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysRoleMenuPermission record) {
        return this.tSysRoleMenuPermissionDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysRoleMenuPermissionCriteria example) {
        return this.tSysRoleMenuPermissionDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysRoleMenuPermission record, TSysRoleMenuPermissionCriteria example) {
        return this.tSysRoleMenuPermissionDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysRoleMenuPermission record, TSysRoleMenuPermissionCriteria example) {
        return this.tSysRoleMenuPermissionDAO.updateByExample(record, example);
    }

    public int insert(TSysRoleMenuPermission record) {
        return this.tSysRoleMenuPermissionDAO.insert(record);
    }

    public int insertSelective(TSysRoleMenuPermission record) {
        return this.tSysRoleMenuPermissionDAO.insertSelective(record);
    }

    @Override
    public int insertBatchSelective(List<TSysRoleMenuPermission> record) {
        return tSysRoleMenuPermissionDAO.insertBatchSelective(record);
    }
}
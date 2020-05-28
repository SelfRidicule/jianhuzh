package com.zhongzhou.service.system.impl;

import com.zhongzhou.dao.system.TSysMenuDAO;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import com.zhongzhou.service.system.TSysMenuService;
import com.zhongzhou.dao.system.TSysMenuDAO;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import com.zhongzhou.service.system.TSysMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zhongzhou.entity.system.TSysMenu;
import com.zhongzhou.entity.system.TSysMenuCriteria;
import com.zhongzhou.service.system.TSysMenuService;

import java.util.List;

@Service
public class TSysMenuServiceImpl implements TSysMenuService {
    @Autowired
    private TSysMenuDAO tSysMenuDAO;

    private static final Logger logger = LoggerFactory.getLogger(TSysMenuServiceImpl.class);

    public int countByExample(TSysMenuCriteria example) {
        int count = this.tSysMenuDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public TSysMenu selectByPrimaryKey(Integer id) {
        return this.tSysMenuDAO.selectByPrimaryKey(id);
    }

    public List<TSysMenu> selectByExample(TSysMenuCriteria example) {
        return this.tSysMenuDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.tSysMenuDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(TSysMenu record) {
        return this.tSysMenuDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(TSysMenu record) {
        return this.tSysMenuDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(TSysMenuCriteria example) {
        return this.tSysMenuDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(TSysMenu record, TSysMenuCriteria example) {
        return this.tSysMenuDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(TSysMenu record, TSysMenuCriteria example) {
        return this.tSysMenuDAO.updateByExample(record, example);
    }

    public int insert(TSysMenu record) {
        return this.tSysMenuDAO.insert(record);
    }

    public TSysMenu insertSelective(TSysMenu record) {
        this.tSysMenuDAO.insertSelective(record);
        return record;
    }

    @Override
    public List<TSysMenu> selectAllWithPermissionByUserGroupId(Integer userGroupId) {
        return tSysMenuDAO.selectAllWithPermissionByUserGroupId(userGroupId);
    }

    @Override
    public List<TSysMenu> selectAllWithPermissionByRoleId(Integer roleId) {
        return tSysMenuDAO.selectAllWithPermissionByRoleId(roleId);
    }

    @Override
    public List<TSysMenu> selectAllGroupByMenuIDRoleId(Integer roleId) {
        return tSysMenuDAO.selectAllGroupByMenuIDRoleId(roleId);
    }

    @Override
    public List<TSysMenu> selectRoleMenusInAllMenusByUpId(Integer roleId, Integer upId) {
        return tSysMenuDAO.selectRoleMenusInAllMenusByUpId(roleId, upId);
    }

	@Override
	public List<TSysMenu> selectAllWithMenuByRoleId(Integer roleid) {
		return tSysMenuDAO.selectAllWithMenuByRoleId(roleid);
	}
}
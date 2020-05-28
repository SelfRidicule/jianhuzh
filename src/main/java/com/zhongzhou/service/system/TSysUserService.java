package com.zhongzhou.service.system;

import com.zhongzhou.entity.DepartVo;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.entity.system.TSysUserCriteria;
import com.zhongzhou.entity.system.TSysUserCriteria;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface TSysUserService {
    int countByExample(TSysUserCriteria example);

    TSysUser selectByPrimaryKey(Integer id);

    List<TSysUser> selectByExample(TSysUserCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TSysUser record);

    int updateByPrimaryKey(TSysUser record);

    int deleteByExample(TSysUserCriteria example);

    int updateByExampleSelective(TSysUser record, TSysUserCriteria example);

    int updateByExample(TSysUser record, TSysUserCriteria example);

    int insert(TSysUser record);

    TSysUser insertSelective(TSysUser record);
    
    PageInfo selectByExample(TSysUserCriteria example, Integer pageSize, Integer pageNum);
    
    public List<DepartVo> queryDepartMans();
    
    public void initUser();


    HttpResult pageList(String keyword , Integer pageSize, Integer pageNum);

}
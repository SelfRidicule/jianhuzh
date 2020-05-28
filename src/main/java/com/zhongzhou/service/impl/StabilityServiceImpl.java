package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.StabilityDAO;
import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.entity.PublicsentimentCriteria;
import com.zhongzhou.entity.StabilityCriteria;
import com.zhongzhou.entity.Stability;
import com.zhongzhou.service.StabilityService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StabilityServiceImpl implements StabilityService {
    @Autowired
    private StabilityDAO stabilityDAO;

    private static final Logger logger = LoggerFactory.getLogger(StabilityServiceImpl.class);

    public int countByExample(StabilityCriteria example) {
        int count = (int)this.stabilityDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Stability selectByPrimaryKey(Integer id) {
        return this.stabilityDAO.selectByPrimaryKey(id);
    }

    public List<Stability> selectByExample(StabilityCriteria example) {
        return this.stabilityDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.stabilityDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Stability record) {
        return this.stabilityDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Stability record) {
        return this.stabilityDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(StabilityCriteria example) {
        return this.stabilityDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Stability record, StabilityCriteria example) {
        return this.stabilityDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Stability record, StabilityCriteria example) {
        return this.stabilityDAO.updateByExample(record, example);
    }

    public int insert(Stability record) {
        return this.stabilityDAO.insert(record);
    }

    public int insertSelective(Stability record) {
        return this.stabilityDAO.insertSelective(record);
    }

    @Override
    public HttpResult dataPageList(String keyword, Integer pageNum, Integer pageSize, Integer policestationid) {
        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");


        StabilityCriteria stabilityCriteria = new StabilityCriteria();
        stabilityCriteria.setOrderByClause(" id desc ");


        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Stability> list = stabilityDAO.auditBackExaminePage(keyword , policestationid);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;
    }
}
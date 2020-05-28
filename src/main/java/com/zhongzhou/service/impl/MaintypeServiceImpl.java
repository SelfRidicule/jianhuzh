package com.zhongzhou.service.impl;

import com.zhongzhou.dao.MaintypeDAO;
import com.zhongzhou.entity.MaintypeCriteria;
import com.zhongzhou.entity.Maintype;
import java.util.List;

import com.zhongzhou.service.MaintypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MaintypeServiceImpl implements MaintypeService {
    @Autowired
    private MaintypeDAO maintypeDAO;

    private static final Logger logger = LoggerFactory.getLogger(MaintypeServiceImpl.class);

    public int countByExample(MaintypeCriteria example) {
        int count = (int)this.maintypeDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Maintype selectByPrimaryKey(Integer id) {
        return this.maintypeDAO.selectByPrimaryKey(id);
    }

    public List<Maintype> selectByExample(MaintypeCriteria example) {
        return this.maintypeDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.maintypeDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Maintype record) {
        return this.maintypeDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Maintype record) {
        return this.maintypeDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(MaintypeCriteria example) {
        return this.maintypeDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Maintype record, MaintypeCriteria example) {
        return this.maintypeDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Maintype record, MaintypeCriteria example) {
        return this.maintypeDAO.updateByExample(record, example);
    }

    public int insert(Maintype record) {
        return this.maintypeDAO.insert(record);
    }

    public int insertSelective(Maintype record) {
        return this.maintypeDAO.insertSelective(record);
    }
}
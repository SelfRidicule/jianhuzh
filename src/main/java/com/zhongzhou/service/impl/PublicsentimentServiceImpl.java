package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.PublicsentimentDAO;
import com.zhongzhou.entity.PublicsentimentCriteria;
import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.entity.Videosurveillance;
import com.zhongzhou.entity.VideosurveillanceCriteria;
import com.zhongzhou.service.PublicsentimentService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublicsentimentServiceImpl implements PublicsentimentService {
    @Autowired
    private PublicsentimentDAO publicsentimentDAO;

    private static final Logger logger = LoggerFactory.getLogger(PublicsentimentServiceImpl.class);

    public int countByExample(PublicsentimentCriteria example) {
        int count = (int) this.publicsentimentDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Publicsentiment selectByPrimaryKey(Integer id) {
        return this.publicsentimentDAO.selectByPrimaryKey(id);
    }

    public List<Publicsentiment> selectByExample(PublicsentimentCriteria example) {
        return this.publicsentimentDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.publicsentimentDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Publicsentiment record) {
        return this.publicsentimentDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Publicsentiment record) {
        return this.publicsentimentDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(PublicsentimentCriteria example) {
        return this.publicsentimentDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Publicsentiment record, PublicsentimentCriteria example) {
        return this.publicsentimentDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Publicsentiment record, PublicsentimentCriteria example) {
        return this.publicsentimentDAO.updateByExample(record, example);
    }

    public int insert(Publicsentiment record) {
        return this.publicsentimentDAO.insert(record);
    }

    public int insertSelective(Publicsentiment record) {
        return this.publicsentimentDAO.insertSelective(record);
    }

    @Override
    public HttpResult dataPageList(String keyword, Integer pageNum, Integer pageSize, Integer policestationid) {
        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");


        PublicsentimentCriteria publicsentimentCriteria = new PublicsentimentCriteria();
        publicsentimentCriteria.setOrderByClause(" id desc ");


        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Publicsentiment> list = publicsentimentDAO.auditBackExaminePage(keyword , policestationid);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;
    }
}
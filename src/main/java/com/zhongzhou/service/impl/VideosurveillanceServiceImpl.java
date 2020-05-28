package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.VideosurveillanceDAO;
//import com.zhongzhou.entity.Policeduty;
//import com.zhongzhou.entity.PolicedutyCriteria;
import com.zhongzhou.entity.VideosurveillanceCriteria;
import com.zhongzhou.entity.Videosurveillance;
import com.zhongzhou.service.VideosurveillanceService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideosurveillanceServiceImpl implements VideosurveillanceService {
    @Autowired
    private VideosurveillanceDAO videosurveillanceDAO;

    private static final Logger logger = LoggerFactory.getLogger(VideosurveillanceServiceImpl.class);

    public int countByExample(VideosurveillanceCriteria example) {
        int count = (int) this.videosurveillanceDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Videosurveillance selectByPrimaryKey(Integer id) {
        return this.videosurveillanceDAO.selectByPrimaryKey(id);
    }

    public List<Videosurveillance> selectByExample(VideosurveillanceCriteria example) {
        return this.videosurveillanceDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.videosurveillanceDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Videosurveillance record) {
        return this.videosurveillanceDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Videosurveillance record) {
        return this.videosurveillanceDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(VideosurveillanceCriteria example) {
        return this.videosurveillanceDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Videosurveillance record, VideosurveillanceCriteria example) {
        return this.videosurveillanceDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Videosurveillance record, VideosurveillanceCriteria example) {
        return this.videosurveillanceDAO.updateByExample(record, example);
    }

    public int insert(Videosurveillance record) {
        return this.videosurveillanceDAO.insert(record);
    }

    public int insertSelective(Videosurveillance record) {
        return this.videosurveillanceDAO.insertSelective(record);
    }

    @Override
    public HttpResult dataPageList(String keyword, Integer pageNum, Integer pageSize, Integer policestationid) {
        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");


        VideosurveillanceCriteria videosurveillanceCriteria = new VideosurveillanceCriteria();
        videosurveillanceCriteria.setOrderByClause(" id desc ");


        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Videosurveillance> list = videosurveillanceDAO.auditBackExaminePage(keyword , policestationid);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;
    }
}
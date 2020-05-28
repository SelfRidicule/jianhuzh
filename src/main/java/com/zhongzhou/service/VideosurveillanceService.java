package com.zhongzhou.service;

import com.zhongzhou.entity.VideosurveillanceCriteria;
import com.zhongzhou.entity.Videosurveillance;
import com.zhongzhou.utils.HttpResult;

import java.util.List;

public interface VideosurveillanceService {
    int countByExample(VideosurveillanceCriteria example);

    Videosurveillance selectByPrimaryKey(Integer id);

    List<Videosurveillance> selectByExample(VideosurveillanceCriteria example);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Videosurveillance record);

    int updateByPrimaryKey(Videosurveillance record);

    int deleteByExample(VideosurveillanceCriteria example);

    int updateByExampleSelective(Videosurveillance record, VideosurveillanceCriteria example);

    int updateByExample(Videosurveillance record, VideosurveillanceCriteria example);

    int insert(Videosurveillance record);

    int insertSelective(Videosurveillance record);


    /**
     * 后台 数据列表
     */

    HttpResult dataPageList(String keyword , Integer pageNum, Integer pageSize , Integer policestationid) ;
}
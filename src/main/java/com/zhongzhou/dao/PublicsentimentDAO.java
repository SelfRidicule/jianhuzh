/* https://github.com/orange1438 */
package com.zhongzhou.dao;

import com.zhongzhou.entity.Publicsentiment;
import com.zhongzhou.entity.PublicsentimentCriteria;
import com.zhongzhou.entity.Videosurveillance;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 本文件由 https://github.com/orange1438/mybatis-generator-core-chinese-annotation1.3.5-chinese-annotation 自动生成
 * @author orange1438
 * date:2020/01/03 10:40
 */
public interface PublicsentimentDAO {
    /** 
     * 查询数量
     * @param example 条件对象
     * @return 返回数据的数量
     */
    long countByExample(PublicsentimentCriteria example);

    /** 
     * 根据条件删除
     * @param example 条件对象
     * @return 返回删除成功的数量
     */
    int deleteByExample(PublicsentimentCriteria example);

    /** 
     * 根据ID删除
     * @param 	
id 主键ID
     * @return 返回删除成功的数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 添加对象所有字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insert(Publicsentiment record);

    /**
     * 添加对象对应字段
     * @param record 插入字段对象(必须含ID）
     * @return 返回添加成功的数量
     */
    int insertSelective(Publicsentiment record);

    /**
     * 根据条件查询（二进制大对象）
     * @param example 条件对象
     * @return 返回查询的结果
     */
    List<Publicsentiment> selectByExample(PublicsentimentCriteria example);

    /**
     * 根据ID查询
     * @param
id 主键ID
     * @return 返回查询的结果
     */
    Publicsentiment selectByPrimaryKey(Integer id);

    /** 
     * 根据条件修改对应字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExampleSelective(@Param("record") Publicsentiment record, @Param("example") PublicsentimentCriteria example);

    /** 
     * 根据条件修改所有字段
     * @param record 修改字段对象 (JOPO)
     * @param example 条件对象
     * @return 返回更新成功的数量
     */
    int updateByExample(@Param("record") Publicsentiment record, @Param("example") PublicsentimentCriteria example);

    /** 
     * 根据ID修改对应字段
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKeySelective(Publicsentiment record);

    /** 
     * 根据ID修改所有字段(必须含ID）
     * @param record 修改字段对象(必须含ID）
     * @return 返回更新成功的数量
     */
    int updateByPrimaryKey(Publicsentiment record);


    /**
     *  后台 关键字
     */
    List<Publicsentiment> auditBackExaminePage(@Param("keyword") String keyword , @Param("policestationid") Integer policestationid);
}
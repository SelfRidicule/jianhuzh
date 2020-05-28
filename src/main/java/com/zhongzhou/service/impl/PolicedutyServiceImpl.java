package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.PolicedutyDAO;
import com.zhongzhou.entity.PolicedutyCriteria;
import com.zhongzhou.entity.Policeduty;
import com.zhongzhou.service.PolicedutyService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicedutyServiceImpl implements PolicedutyService {
    @Autowired
    private PolicedutyDAO policedutyDAO;

    private static final Logger logger = LoggerFactory.getLogger(PolicedutyServiceImpl.class);

    public int countByExample(PolicedutyCriteria example) {
        int count = (int) this.policedutyDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Policeduty selectByPrimaryKey(Integer id) {
        return this.policedutyDAO.selectByPrimaryKey(id);
    }

    public List<Policeduty> selectByExample(PolicedutyCriteria example) {
        return this.policedutyDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.policedutyDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Policeduty record) {
        return this.policedutyDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Policeduty record) {
        return this.policedutyDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(PolicedutyCriteria example) {
        return this.policedutyDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Policeduty record, PolicedutyCriteria example) {
        return this.policedutyDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Policeduty record, PolicedutyCriteria example) {
        return this.policedutyDAO.updateByExample(record, example);
    }

    public int insert(Policeduty record) {
        return this.policedutyDAO.insert(record);
    }

    public int insertSelective(Policeduty record) {
        return this.policedutyDAO.insertSelective(record);
    }




    /**
     * 后台 数据列表
     */
    @Override
    public HttpResult dataPageList(String keyword , String status , Integer pageNum, Integer pageSize , Integer policestationid) {

        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");


        PolicedutyCriteria  policedutyCriteria = new PolicedutyCriteria();
        policedutyCriteria.setOrderByClause(" id desc ");


        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Policeduty> list = policedutyDAO.auditBackExaminePage(keyword , status, policestationid);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;

    }

}
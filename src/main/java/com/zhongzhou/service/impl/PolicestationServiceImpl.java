package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.PolicestationDAO;
import com.zhongzhou.entity.PolicestationCriteria;
import com.zhongzhou.entity.Policestation;
import com.zhongzhou.service.PolicestationService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicestationServiceImpl implements PolicestationService {
    @Autowired
    private PolicestationDAO policestationDAO;

    private static final Logger logger = LoggerFactory.getLogger(PolicestationServiceImpl.class);

    public int countByExample(PolicestationCriteria example) {
        int count = (int) this.policestationDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Policestation selectByPrimaryKey(Integer id) {
        return this.policestationDAO.selectByPrimaryKey(id);
    }

    public List<Policestation> selectByExample(PolicestationCriteria example) {
        return this.policestationDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.policestationDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Policestation record) {
        return this.policestationDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Policestation record) {
        return this.policestationDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(PolicestationCriteria example) {
        return this.policestationDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Policestation record, PolicestationCriteria example) {
        return this.policestationDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Policestation record, PolicestationCriteria example) {
        return this.policestationDAO.updateByExample(record, example);
    }

    public int insert(Policestation record) {
        return this.policestationDAO.insert(record);
    }

    public int insertSelective(Policestation record) {
        return this.policestationDAO.insertSelective(record);
    }



    /**
     * 后台 数据列表
     */
    @Override
    public HttpResult dataPageList(String keyword , Integer pageNum, Integer pageSize , String code) {

        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");


        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Policestation> list = policestationDAO.auditBackExaminePage(keyword , code);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;

    }
}
package com.zhongzhou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhongzhou.dao.MainpersonDAO;
import com.zhongzhou.dao.MaintypeDAO;
import com.zhongzhou.entity.MainpersonCriteria;
import com.zhongzhou.entity.Mainperson;
import java.util.List;

import com.zhongzhou.entity.Maintype;
import com.zhongzhou.entity.MaintypeCriteria;
import com.zhongzhou.service.MainpersonService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MainpersonServiceImpl implements MainpersonService {
    @Autowired
    private MainpersonDAO mainpersonDAO;

    @Autowired
    private MaintypeDAO maintypeDAO;

    private static final Logger logger = LoggerFactory.getLogger(MainpersonServiceImpl.class);

    public int countByExample(MainpersonCriteria example) {
        int count = (int) this.mainpersonDAO.countByExample(example);
        logger.debug("count: {}", count);
        return count;
    }

    public Mainperson selectByPrimaryKey(Integer id) {
        return this.mainpersonDAO.selectByPrimaryKey(id);
    }

    public List<Mainperson> selectByExample(MainpersonCriteria example) {
        return this.mainpersonDAO.selectByExample(example);
    }

    public int deleteByPrimaryKey(Integer id) {
        return this.mainpersonDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(Mainperson record) {
        return this.mainpersonDAO.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(Mainperson record) {
        return this.mainpersonDAO.updateByPrimaryKey(record);
    }

    public int deleteByExample(MainpersonCriteria example) {
        return this.mainpersonDAO.deleteByExample(example);
    }

    public int updateByExampleSelective(Mainperson record, MainpersonCriteria example) {
        return this.mainpersonDAO.updateByExampleSelective(record, example);
    }

    public int updateByExample(Mainperson record, MainpersonCriteria example) {
        return this.mainpersonDAO.updateByExample(record, example);
    }

    public int insert(Mainperson record) {
        return this.mainpersonDAO.insert(record);
    }

    public int insertSelective(Mainperson record) {
        return this.mainpersonDAO.insertSelective(record);
    }


    @Override
    public HttpResult dataPageList(Integer pageNum, Integer pageSize, String keyword, String policecode) {
        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");



        //设置pageNum, pageSize
        PageHelper.startPage(pageNum, pageSize);

        //查询结果
        List<Mainperson> list = mainpersonDAO.auditBackExaminePage(keyword , policecode);

        //用PageInfo对结果进行包装
        PageInfo page = new PageInfo(list);


        //得到结果
        List<Mainperson> datalist = page.getList();

        //循环查询
        for (int i = 0; i < datalist.size(); i++) {

            Integer maintypeId = datalist.get(i).getMaintypeid();

            //如果maintypeid 等于null 直接跳过!
            if(maintypeId == null){
                continue;
            }

            Maintype maintype = maintypeDAO.selectByPrimaryKey(maintypeId);
            if(maintype == null){
                continue;
            }else{
                datalist.get(i).setMaintypeName(maintype.getName());
            }
        }
        
        
        
        result.setData(page.getList());
        result.setCount(page.getTotal());


        return result;
    }


}
package com.zhongzhou.controller;


import com.zhongzhou.entity.Maintype;
import com.zhongzhou.entity.MaintypeCriteria;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.MaintypeService;
import com.zhongzhou.utils.HttpResult;
import org.apache.tools.ant.taskdefs.condition.Http;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value="/maintype")
public class MaintypeController {


    @Autowired
    MaintypeService maintypeService;


    /**
     * 后台 数据列表
     */
    @RequestMapping(value = "/dataList", method = {RequestMethod.POST, RequestMethod.GET})
    @ResponseBody
    public HttpResult dataList(HttpServletRequest request, HttpSession session) {


        TSysUser user = (TSysUser) request.getSession().getAttribute("user");

        MaintypeCriteria maintypeCriteria = new MaintypeCriteria();
        maintypeCriteria.createCriteria();

        List<Maintype> maintypeList = maintypeService.selectByExample(maintypeCriteria);

        HttpResult httpResult = new HttpResult();
        httpResult.setData(maintypeList);

        return httpResult;
    }






}

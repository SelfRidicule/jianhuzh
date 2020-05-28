package com.zhongzhou.controller;


import com.zhongzhou.cache.RedisCache;
import com.zhongzhou.controller.base.BaseController;
import com.zhongzhou.entity.*;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.PolicedutyService;
import com.zhongzhou.service.PolicestationService;
import com.zhongzhou.service.VideosurveillanceService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin
@Controller
@RequestMapping(value="/station")
public class PolicestationController extends BaseController {


    @Autowired
    PolicestationService policestationService;

    @Autowired
    PolicedutyService policedutyService;

    @Autowired
    private VideosurveillanceService videosurveillanceService;


    @Autowired
    RedisCache cache;


    /**
     * 后台 数据列表
     */
    @RequestMapping(value="/dataList",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult dataList(HttpServletRequest request, HttpSession session , Integer pageNum , Integer pageSize ,String keyword){

        TSysUser tSysUser = getUser();
        String policecode = tSysUser.getPolicecode();

        return policestationService.dataPageList(keyword , pageNum,  pageSize , policecode);
    }


    /**
     * 后台 查询所有派出所
     */
    @RequestMapping(value="/dataListAll",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult dataListAll(HttpServletRequest request, HttpSession session){

        PolicestationCriteria policestationCriteria = new PolicestationCriteria();
        policestationCriteria.createCriteria();

        List<Policestation> policestationList = policestationService.selectByExample(policestationCriteria);
        HttpResult httpResult = new HttpResult();
        httpResult.setCode(Consts.SUCCESS);
        httpResult.setData(policestationList);
        return httpResult;
    }


    /**
     * 后台 添加
     */
    @RequestMapping(value="/add",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult add(HttpServletRequest request, HttpSession session , Policestation policestation){


        policestationService.insertSelective(policestation);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policestation);

        return result;
    }

    /**
     * 后台 查询id
     */
    @RequestMapping(value="/queryId",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult queryId(HttpServletRequest request, HttpSession session , Integer id){


        Policestation policestation =  policestationService.selectByPrimaryKey(id);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policestation);

        return result;
    }

    /**
     * 后台 修改
     */
    @RequestMapping(value="/update",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult update(HttpServletRequest request, HttpSession session , Policestation policestation){


        policestationService.updateByPrimaryKeySelective(policestation);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policestation);

        return result;
    }

    /**
     * 查询关联的值班人员 和 视频监控总数
     */
    @RequestMapping(value="/queryDutyAndVideoCount",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult queryDutyAndVideoCount(HttpServletRequest request, HttpSession session , Integer id){

        //删除关联的值班人员
        PolicedutyCriteria policedutyCriteria = new PolicedutyCriteria();
        policedutyCriteria.createCriteria().andPolicestationidEqualTo(id);
        int dutyCount = policedutyService.countByExample(policedutyCriteria);


        //删除关联的视频监控
        VideosurveillanceCriteria videosurveillanceCriteria = new VideosurveillanceCriteria();
        videosurveillanceCriteria.createCriteria().andPolicestationidEqualTo(id);
        int videoCount = videosurveillanceService.countByExample(videosurveillanceCriteria);


        Map map = new HashMap();
        map.put("dutyCount" , dutyCount);
        map.put("videoCount" , videoCount);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(map);

        return result;
    }


    /**
     * 后台 删除
     */
    @RequestMapping(value="/delete",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult delete(HttpServletRequest request, HttpSession session , Integer id){


        policestationService.deleteByPrimaryKey(id);


        //删除关联的值班人员
        PolicedutyCriteria policedutyCriteria = new PolicedutyCriteria();
        policedutyCriteria.createCriteria().andPolicestationidEqualTo(id);
        policedutyService.deleteByExample(policedutyCriteria);


        //删除关联的视频监控
        VideosurveillanceCriteria videosurveillanceCriteria = new VideosurveillanceCriteria();
        videosurveillanceCriteria.createCriteria().andPolicestationidEqualTo(id);
        videosurveillanceService.deleteByExample(videosurveillanceCriteria);


        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");

        return result;
    }


    /**
     * 后台 登录
     */
    @RequestMapping(value="/login",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult login(HttpServletRequest request, HttpSession session , String account , String password){


        PolicestationCriteria policestationCriteria = new PolicestationCriteria();
        policestationCriteria.createCriteria().andAccountEqualTo(account).andPasswordEqualTo(password);

        List<Policestation> list  = policestationService.selectByExample(policestationCriteria);

        if(list != null && list.size() > 0){


            Policestation policestation = list.get(0);

            session.setAttribute("policestation" , policestation);

            //返回数据
            HttpResult result = new HttpResult();
            result.setCode(Consts.SUCCESS);
            result.setMsg("操作成功");
            result.setData(policestation);

            return result;

        }else{
            //返回数据
            HttpResult result = new HttpResult();
            result.setCode(Consts.ERROR);
            result.setMsg("操作失败");

            return result;
        }



    }


    /**
     * 后台 session 指定的派出所
     */
    @RequestMapping(value="/setPolicestation",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult setPolicestation(HttpServletRequest request, HttpSession session , Integer id){


        Policestation policestation = policestationService.selectByPrimaryKey(id);

        session.setAttribute("policestation" , policestation);

        //返回数据
        HttpResult result = new HttpResult();
        result.setCode(Consts.SUCCESS);
        result.setMsg("操作成功");
        result.setData(policestation);

        return result;
    }


}

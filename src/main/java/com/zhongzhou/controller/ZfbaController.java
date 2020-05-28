package com.zhongzhou.controller;


import com.fwjk.caller.ResourceServiceException;
import com.fwjk.demo.QueryDemo;
import com.sun.corba.se.impl.util.RepositoryIdCache;
import com.zhongzhou.cache.RedisCache;
import com.zhongzhou.dto.*;
import com.zhongzhou.entity.*;
import com.zhongzhou.service.MainpersonService;
import com.zhongzhou.service.MaintypeService;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
import com.zhongzhou.utils.SelfDateUtil;
import com.zhongzhou.utils.SelfXmlUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@Controller
@RequestMapping(value="/zfba")
public class ZfbaController {


    @Autowired
    RedisCache cache;

    @Autowired
    MainpersonService mainpersonService;

    @Autowired
    MaintypeService maintypeService;



    /**
     * 物品案件涉案物品信息==>S32-09000138
     */
    @RequestMapping(value="/sawp",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult sawp(HttpServletRequest request, HttpSession session ,String goods ,  String condition){


        //盐城市公安局物品案件涉案物品信息定制数据查询服务v01
        String serviceID = Consts.S32_09000138;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "sawp";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);

        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();

            List<SawpDto> sawpDtoList = new ArrayList<>();

            String nameArr[] = goods.split(",");


            try {

                for (int i = 0; i < nameArr.length; i++) {

                    String count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  condition + " and wpmc like '%" + nameArr[i] + "%' ");
                    sawpDtoList.add(new SawpDto(nameArr[i] , count ));

                }

                String other_condition = condition;

                for (int i = 0; i < nameArr.length; i++) {

                    other_condition = other_condition + "  and wpmc not like '%" + nameArr[i] + "%'  ";

                }

                String other_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  other_condition);
                sawpDtoList.add(new SawpDto("其他" , other_count ));


            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            httpResult.setData(sawpDtoList);



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }


    /**
     * 警情分类
     */
    @RequestMapping(value="/jqfl",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jqfl(HttpServletRequest request, HttpSession session , String condition ){

        //盐城市公安局处警信息定制数据查询服务v01
        String S32_09000126 = Consts.S32_09000126;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "jqfl";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);

        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();


            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date[] rq = new SelfDateUtil().getZTDate("本周");

            String startTime = sdf.format(rq[0]);
            String endTime = sdf.format(rq[1]);

            Map<String , String > map = new HashMap<>();

            try {

                String db = new QueryDemo().selfCallQueryCountInLocal( S32_09000126 ,  condition + " and  CJLB = '060101'  and CJSJ  >= '" + startTime + "'  and CJSJ  <= '"+  endTime + "'");
                String xs = new QueryDemo().selfCallQueryCountInLocal( S32_09000126 ,  condition + " and  CJJG = '01'  and CJSJ  >= '" + startTime + "'  and CJSJ  <= '"+  endTime + "'");
                String za =  new QueryDemo().selfCallQueryCountInLocal( S32_09000126 ,  condition + " and  (CJJG = '02' OR CJJG = '04')   and CJSJ  >= '" + startTime + "'  and CJSJ  <= '"+  endTime + "'");


                map.put("db", db);
                map.put("xs", xs);
                map.put("za", za);

                httpResult.setData(map);

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }


    /**
     * 重点人员
     */
    @RequestMapping(value="/zdryUpdate",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult zdryUpdate(HttpServletRequest request, HttpSession session ){

        //盐城市公安局人员基本信息定制数据查询服务
        String serviceID = Consts.S32_09000142;

        MainpersonCriteria mainpersonCriteria = new MainpersonCriteria();
        mainpersonCriteria.createCriteria().andPolicecodeIsNull();

        List<Mainperson> list = mainpersonService.selectByExample(mainpersonCriteria);

        for (int i = 0; i < list.size(); i++) {
            Mainperson mainperson = list.get(i);
            String idcard = mainperson.getIdcard();

            int startRow = 0 ;
            int numRow = 5 ;

            String condition = " GMSFHM = '" + idcard + "' ";

            try {
                String  json = new QueryDemo().selfCallQueryLocal( serviceID ,  condition ,  startRow ,  numRow );
                List<Map> mapList = SelfXmlUtil.initDataList(json);

               if(mapList.size() > 0){
                   Map<String , ColumnDetail> map =  mapList.get(0);
                   String djdw  = map.get("DJDW").getContent();

                   mainperson.setPolicecode(djdw);
                   mainpersonService.updateByPrimaryKeySelective(mainperson);
               }

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


        }




        //设置数据
        HttpResult httpResult = new HttpResult();
        httpResult.setData(null);


        //返回数据
        return httpResult;
    }

    /**
     * 重点人员
     */
    @RequestMapping(value="/zdry",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult zdry(HttpServletRequest request, HttpSession session , String policecode){


        MaintypeCriteria maintypeCriteria = new MaintypeCriteria();
        maintypeCriteria.createCriteria();

        //查询重点类型列表
        List<Maintype> maintypeList = maintypeService.selectByExample(maintypeCriteria);


        //返回数据
        List<Map> list = new ArrayList<>();

        //循环查询指定派出所 和 犯罪类型的总数!
        for (int i = 0; i < maintypeList.size(); i++) {

            Maintype maintype = maintypeList.get(i);
            Integer maintypeId = maintype.getId();
            String maintypeName = maintype.getName();



            //查询总数
            MainpersonCriteria mainpersonCriteria = new MainpersonCriteria();
            mainpersonCriteria.createCriteria().andMaintypeidEqualTo(maintypeId).andPolicecodeEqualTo(policecode);

            Integer count = mainpersonService.countByExample(mainpersonCriteria);


            HashMap<String , Object> hashMap = new HashMap<>();
            hashMap.put("name" , maintypeName);
            hashMap.put("value" , count);

            list.add(hashMap);
        }


        //设置数据
        HttpResult httpResult = new HttpResult();
        httpResult.setData(list);


        //返回数据
        return httpResult;
    }


    /**
     * 立破案 同比
     */
    @RequestMapping(value="/lpatb",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult lpatb(HttpServletRequest request, HttpSession session ,  String la_condition , String pa_condition){

        //盐城市公安局案件基本信息表定制数据查询服务v01
        String serviceID = Consts.S32_09000128;

        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "lpatb";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            Date endDate = new Date();

            Calendar c = Calendar.getInstance();
            c.setTime(new Date());
            c.add(Calendar.YEAR, -1);
            Date startDate = c.getTime();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            String startTime = sdf.format(startDate);
            String endTime = sdf.format(endDate);


            //同比
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(new Date());
            calendar1.add(Calendar.YEAR, -2);
            Date tb_startDate = calendar1.getTime();

            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(new Date());
            calendar2.add(Calendar.YEAR, -1);
            Date tb_endDate = calendar2.getTime();

            String tb_startTime = sdf.format(tb_startDate);
            String tb_endTime = sdf.format(tb_endDate);



            HttpResult httpResult = new HttpResult();

            Map<String , String> map = new HashMap();


            //立案
            String la_count_condition =  la_condition +  " and  ajlb < '200000' ";
            la_count_condition = la_count_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') ";
            la_count_condition = la_count_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String  la_count = null;
            try {
                la_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_count_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            //破案
            String pa_count_condition =  la_condition + "  and  " + pa_condition  +  " and  ajlb < '200000' ";
            pa_count_condition = pa_count_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25','37')  ";
            pa_count_condition = pa_count_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_count_condition = pa_count_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";

            String  pa_count = null;
            try {
                pa_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_count_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            //同比
            //立案
            String la_count_condition1 =  la_condition +  " and  ajlb < '200000' ";
            la_count_condition1 = la_count_condition1 + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') ";
            la_count_condition1 = la_count_condition1 + " and  LASJ >= '" + tb_startTime + "' and  LASJ <= '" + tb_endTime + "' ";
            String  tb_la_count = null;
            try {
                tb_la_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_count_condition1);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            //破案
            String pa_count_condition1 =  la_condition + "  and  " + pa_condition  +  " and  ajlb < '200000' ";
            pa_count_condition1 = pa_count_condition1 + " and  ajzt in ('03', '04', '05', '17', '22', '25','37')  ";
            pa_count_condition1 = pa_count_condition1 + " and  LASJ >= '" + tb_startTime + "' and  LASJ <= '" + tb_endTime + "' ";
            pa_count_condition1 = pa_count_condition1 + " and  parq >= '" + tb_startTime + "' and  parq <= '" + tb_endTime + "' ";

            String  tb_pa_count = null;
            try {
                tb_pa_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_count_condition1);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            Integer lanow = Integer.valueOf(la_count);
            Integer panow = Integer.valueOf(pa_count);

            Integer lalast = Integer.valueOf(tb_la_count);
            Integer palast = Integer.valueOf(tb_pa_count);

            String latb = "0%";
            if (lalast != 0) {
                int num = lanow - lalast;
                double tb = num * 1000 / lalast;
                latb = (double) tb / 10 + "%";
            }

            map.put("latb", latb);


            String patb = "0%";
            if (palast != 0) {
                int num = panow - palast;
                double tb = num * 1000 / palast;
                patb = (double) tb / 10 + "%";
            }

            map.put("patb", patb);


            String paltb = "0%";
            int palnow = 0;
            int pallast = 0;
            if (lalast != 0) {
                pallast = palast * 1000 /  lalast;
            }
            if (lanow != 0) {
                palnow = panow * 1000 / lanow;
            }
            if(pallast!=0)
            {
                int num = palnow-pallast;
                double tb = num*1000/pallast;
                paltb = (double)tb/10+"%";
            }


            map.put("pal" , palnow + "");
            map.put("paltb" , paltb);

            map.put("la_count" , la_count);
            map.put("pa_count" ,pa_count );

            httpResult.setData(map);



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }

    /**
     * 立破案 时间
     */
    @RequestMapping(value="/lpaTime",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public Map lpaTime(
                                HttpServletRequest request,
                                HttpSession session ){

        Map<String, String> map = new HashMap<String, String>();

        Date[] rq = new SelfDateUtil().getZTDate("今年");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        String dateStr =  sdf.format(rq[0]);
        String value = dateStr.substring(0,4)+ "年" +  dateStr.substring(4,6)+ "月" + dateStr.substring(6,8)+ "日" ;

        map.put("date", value);

        return map;
    }

    /**
     * 立破案统计图
     */
    @RequestMapping(value="/lpaChart",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult lpaChart(
                                HttpServletRequest request,
                                HttpSession session ,
                                String la_condition,
                                String pa_condition
                                ){

        //盐城市公安局案件基本信息表定制数据查询服务v01
        String serviceID = Consts.S32_09000128;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "lpaChart";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date[] rq = new SelfDateUtil().getZTDate("今年");
            String startTime = sdf.format(rq[0]);
            String endTime = sdf.format(rq[1]);



            //八类案件
            String la_blaj_condition =  la_condition +  " and  ajzt in ('03', '04', '05', '17', '22', '25', '37') ";
            la_blaj_condition = la_blaj_condition + " and ( ajlb in ('020101', '020103', '020311', '020312', '020313', '040101', '040103', '040105', '040106', '040110') or ajlb like '0501%') ";
            la_blaj_condition = la_blaj_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String  la_blaj_count = null;
            try {
                la_blaj_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_blaj_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            String pa_blaj_condition =  la_condition + "  and  " + pa_condition  +  " and  ajzt in ('03', '04', '05', '17', '22', '25', '37') ";
            pa_blaj_condition = pa_blaj_condition + " and ( ajlb in ('020101', '020103', '020311', '020312', '020313', '040101', '040103', '040105', '040106', '040110') or ajlb like '0501%') ";
            pa_blaj_condition = pa_blaj_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_blaj_condition = pa_blaj_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";

            String  pa_blaj_count = null;
            try {
                pa_blaj_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_blaj_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //两枪案件
            String la_lqaj_condition = la_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25', '37')  " ;
            la_lqaj_condition = la_lqaj_condition + " and (ajlb like'0501%' or ajlb like '0504%') " ;
            la_lqaj_condition = la_lqaj_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_lqaj_count = null;
            try {
                la_lqaj_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_lqaj_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_lqaj_condition = la_condition + "  and  " + pa_condition + "  and  ajzt in ('03', '04', '05', '17', '22', '25', '37')  " ;
            pa_lqaj_condition = pa_lqaj_condition + " and (ajlb like'0501%' or ajlb like '0504%') " ;
            pa_lqaj_condition = pa_lqaj_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_lqaj_condition = pa_lqaj_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_lqaj_count = null;
            try {
                pa_lqaj_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_lqaj_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //入室盗窃
            String la_rsdq_condition = la_condition + "  and  ajzt in ('03', '04', '05', '17', '22', '25', '37') and  ajlb='050201' ";
            la_rsdq_condition = la_rsdq_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_rsdq_count = null;
            try {
                la_rsdq_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_rsdq_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_rsdq_condition = la_condition + "  and  " + pa_condition + "  and  ajzt in ('03', '04', '05', '17', '22', '25', '37') and  ajlb='050201' ";
            pa_rsdq_condition = pa_rsdq_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_rsdq_condition = pa_rsdq_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_rsdq_count = null;
            try {
                pa_rsdq_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_rsdq_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //盗窃电动车
            String la_dqddc_condition = la_condition + " and  ajlb  <  '200000' and  ajfab='05022702' ";
            la_dqddc_condition = la_dqddc_condition + " and  ajzt in ('03', '04', '05','17', '22', '25','37')  ";
            la_dqddc_condition = la_dqddc_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_dqddc_count = null;
            try {
                la_dqddc_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_dqddc_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_dqddc_condition = la_condition + "  and  " + pa_condition + " and  ajlb  <  '200000' and  ajfab='05022702' ";
            pa_dqddc_condition = pa_dqddc_condition + " and  ajzt in ('03', '04', '05','17', '22', '25','37')  ";
            pa_dqddc_condition = pa_dqddc_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_dqddc_condition = pa_dqddc_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_dqddc_count = null;
            try {
                pa_dqddc_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_dqddc_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //盗窃机动车
            String la_dqjdc_condition = la_condition  + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') " ;
            la_dqjdc_condition = la_dqjdc_condition + " and  ajlb in ('050223','050224') ";
            la_dqjdc_condition  = la_dqjdc_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_dqjdc_count = null;
            try {
                la_dqjdc_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_dqjdc_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_dqjdc_condition = la_condition  + " and " + pa_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') " ;
            pa_dqjdc_condition = pa_dqjdc_condition + " and  ajlb in ('050223','050224') ";
            pa_dqjdc_condition  = pa_dqjdc_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_dqjdc_condition = pa_dqjdc_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_dqjdc_count = null;
            try {
                pa_dqjdc_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_dqjdc_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //扒窃
            String la_pq_condition = la_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') ";
            la_pq_condition = la_pq_condition + " and  ajlb ='050240' " ;
            la_pq_condition = la_pq_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_pq_count = null;
            try {
                la_pq_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_pq_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_pq_condition = la_condition + " and " + pa_condition + " and  ajzt in ('03', '04', '05', '17', '22', '25','37') ";
            pa_pq_condition = pa_pq_condition + " and  ajlb ='050240' " ;
            pa_pq_condition = pa_pq_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_pq_condition = pa_pq_condition +  " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_pq_count = null;
            try {
                pa_pq_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_pq_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //电信诈骗
            String la_dxzp_condition = la_condition + " and  ajlb < '200000' and ajfab in ('05030011','05030012','05030014') ";
            la_dxzp_condition = la_dxzp_condition + " and  ajzt in ('03', '04', '05','17', '22', '25','37') ";
            la_dxzp_condition = la_dxzp_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            String la_dxzp_count = null;
            try {
                la_dxzp_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  la_dxzp_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            String pa_dxzp_condition = la_condition + " and " + pa_condition + " and  ajlb < '200000' and ajfab in ('05030011','05030012','05030014') ";
            pa_dxzp_condition = pa_dxzp_condition + " and  ajzt in ('03', '04', '05','17', '22', '25','37') ";
            pa_dxzp_condition = pa_dxzp_condition + " and  LASJ >= '" + startTime + "' and  LASJ <= '" + endTime + "' ";
            pa_dxzp_condition = pa_dxzp_condition + " and  parq >= '" + startTime + "' and  parq <= '" + endTime + "' ";
            String pa_dxzp_count = null;
            try {
                pa_dxzp_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  pa_dxzp_condition);
            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            Map<String , String > map = new HashMap();

            //八类案件
            map.put("la_blaj_count", la_blaj_count);
            map.put("pa_blaj_count", pa_blaj_count);


            //两枪案件
            map.put("la_lqaj_count", la_lqaj_count);
            map.put("pa_lqaj_count", pa_lqaj_count);


            //入室盗窃
            map.put("la_rsdq_count", la_rsdq_count);
            map.put("pa_rsdq_count", pa_rsdq_count);


            //盗窃电动车
            map.put("la_dqddc_count", la_dqddc_count);
            map.put("pa_dqddc_count", pa_dqddc_count);


            //盗窃机动车
            map.put("la_dqjdc_count", la_dqjdc_count);
            map.put("pa_dqjdc_count", pa_dqjdc_count);


            //扒窃
            map.put("la_pq_count", la_pq_count);
            map.put("pa_pq_count", pa_pq_count);


            //电信诈骗
            map.put("la_dxzp_count", la_dxzp_count);
            map.put("pa_dxzp_count", pa_dxzp_count);


            httpResult.setData(map);


            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }


    /**
     * 作案特点==>S32_09000130
     */
    @RequestMapping(value="/zatd",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult zatd(HttpServletRequest request,
                           HttpSession session ,
                           String qqsd_condition,
                           String qzsd_condition,
                           String fhsd_condition,
                           String jsjsd_condition,
                           String qtsd_condition,
                           String ybsd_condition,
                           String rqsd_condition,
                           String xpsd_condition,
                           String wzsd_condition,
                           String jzzasd_condition

                            ){
        //盐城市公安局案件作案特点定制数据查询服务v01
        String serviceID = Consts.S32_09000130;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "zatd";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);

        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();

            List<ZatdDto> zatdDtoList = new ArrayList<>();

            try {
                //QQSD（窃取手段）
                String qqsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  qqsd_condition);
                zatdDtoList.add(new ZatdDto("窃取手段" , qqsd_count ));

                //QZSD（欺诈手段）
                String qzsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  qzsd_condition);
                zatdDtoList.add(new ZatdDto("欺诈手段" , qzsd_count ));

                //FHSD（妨害手段）
                String fhsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  fhsd_condition);
                zatdDtoList.add(new ZatdDto("妨害手段" , fhsd_count ));

                //JSJSD（计算机手段）
                String jsjsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  jsjsd_condition);
                zatdDtoList.add(new ZatdDto("计算机手段" ,  jsjsd_count));

                //QTSD（其他手段）
                String qtsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  qtsd_condition);
                zatdDtoList.add(new ZatdDto("其他手段" ,  qtsd_count));

                //YBSD (预备手段)
                String ybsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  ybsd_condition);
                zatdDtoList.add(new ZatdDto("预备手段" ,  ybsd_count));

                //QRSD (侵入手段)
                String rqsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  rqsd_condition);
                zatdDtoList.add(new ZatdDto("侵入手段" ,  rqsd_count));

                //XPSD (胁迫手段)
                String xpsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  xpsd_condition);
                zatdDtoList.add(new ZatdDto("胁迫手段" , xpsd_count ));

                //WZSD (伪装灭迹手段)
                String wzsd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  wzsd_condition);
                zatdDtoList.add(new ZatdDto("伪装灭迹手段" ,  wzsd_count));

                //JZZASD (经侦作案手段)
                String jzzasd_count = new QueryDemo().selfCallQueryCountInLocal( serviceID ,  jzzasd_condition);
                zatdDtoList.add(new ZatdDto("经侦作案手段" ,  jzzasd_count));


                // <<=========================================================================================



            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            httpResult.setData(zatdDtoList);



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }


    /**
     * 治安案件
     */
    @RequestMapping(value="/zaaj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult zaaj(HttpServletRequest request, HttpSession session , String bncc_condition , String bncf_condition ,
                           String bycc_condition,String bycf_condition, String jrcc_condition , String jrcf_condition){

        //盐城市公安局案件基本信息表定制数据查询服务v01
        String serviceID = Consts.S32_09000128;

        //盐城市公安局案件处理措施结果信息执行表定制数据查询服务v01
        String S32_09000140 = Consts.S32_09000140;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "zaaj";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();


            try {

                //本年
                String bncc_count =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  bncc_condition);
                String bncf_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 ,  bncf_condition);

                //本月
                String bycc_count =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  bycc_condition);
                String bycf_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 ,  bycf_condition);

                //今日
                String jrcc_count =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  jrcc_condition);
                String jrcf_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 ,  jrcf_condition);

                Map<String , String > map = new HashMap();
                //本年
                map.put("bncc_count", bncc_count);
                map.put("bncf_count", bncf_count);
                //本月
                map.put("bycc_count", bycc_count);
                map.put("bycf_count", bycf_count);

                //今日
                map.put("jrcc_count", jrcc_count);
                map.put("jrcf_count", jrcf_count);


                httpResult.setData(map);

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }


    /**
     *  审查处理
     */
    @RequestMapping(value="/sccl",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult sccl(
                            HttpServletRequest request,
                            HttpSession session ,

                            String jnzhrs_condition ,
                            String jrzhrs_condition ,

                            String xjYear_condition ,
                            String xjMonth_condition ,

                            String dbYear_condition ,
                            String dbMonth_condition ,

                            String qsYear_condition ,
                            String qsMonth_condition
                            ){




        //盐城市公安局案件处理措施结果信息执行表定制数据查询服务v01
        String S32_09000140 = Consts.S32_09000140;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "sccl";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();


            try {
                //今年抓获人数
                String jnzhrs_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , jnzhrs_condition );

                //今日抓获人数
                String jrzhrs_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , jrzhrs_condition );

                //刑拘
                //年
                String xjYear_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , xjYear_condition );
                //月
                String xjMonth_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 ,  xjMonth_condition);

                //逮捕
                //年
                String dbYear_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , dbYear_condition );
                //月
                String dbMonth_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , dbMonth_condition );

                //起诉
                //年
                String qsYear_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , qsYear_condition );
                //月
                String qsMonth_count =  new QueryDemo().selfCallQueryCountInLocal( S32_09000140 , qsMonth_condition );


                Map<String , String > map = new HashMap();


                //今年抓获人数
                map.put("jnzhrs_count",jnzhrs_count );

                //今日抓获人数
                map.put("jrzhrs_count", jrzhrs_count);

                //刑拘
                //年
                map.put("xjYear_count",xjYear_count );
                //月
                map.put("xjMonth_count", xjMonth_count);

                //逮捕
                //年
                map.put("dbYear_count",dbYear_count );
                //月
                map.put("dbMonth_count", dbMonth_count);

                //起诉
                //年
                map.put("qsYear_count",qsYear_count );
                //月
                map.put("qsMonth_count", qsMonth_count);



                httpResult.setData(map);

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }



}

package com.zhongzhou.controller;


import com.fwjk.caller.ResourceServiceException;
import com.fwjk.demo.QueryDemo;
import com.zhongzhou.cache.RedisCache;
import com.zhongzhou.dto.ColumnDetail;
import com.zhongzhou.dto.CybercafeDto;
import com.zhongzhou.dto.PoliceMessageDto;
import com.zhongzhou.dto.RoomDto;
import com.zhongzhou.entity.*;
import com.zhongzhou.entity.system.TSysUser;
import com.zhongzhou.service.*;
import com.zhongzhou.utils.Consts;
import com.zhongzhou.utils.HttpResult;
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
@RequestMapping(value="/home")
public class HomeController {


    @Autowired
    PolicedutyService policedutyService;

    @Autowired
    RedisCache cache;

    @Autowired
    private StabilityService stabilityService;

    /**
     * 舆情
     */
    @Autowired
    private PublicsentimentService publicsentimentService;

    @Autowired
    MainpersonService mainpersonService;

    @Autowired
    MaintypeService maintypeService;


    /**
     * 今日值班
     */
    @RequestMapping(value="/jrzb",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jrzb(HttpServletRequest request, HttpSession session , Integer policestationId){

        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "jrzb";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);

        //如果没有缓存
        if(cacheData == null){

            HttpResult result = new HttpResult();


            PolicedutyCriteria policedutyCriteria = new PolicedutyCriteria();
            policedutyCriteria.createCriteria().andPolicestationidEqualTo(policestationId).andStatusEqualTo(1);


            List<Policeduty> list = policedutyService.selectByExample(policedutyCriteria);



            result.setData(list);
            result.setCode(Consts.SUCCESS);


            //缓存数据
            cache.putCacheWithExpireTime(key, result , RedisCache.CAHCETIME);
            cacheData = result ;
        }


        return cacheData;
    }


    /**
     *  人口数据
     */
    @RequestMapping(value="/rksj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult rksj(HttpServletRequest request, HttpSession session , String cz_condition , String zz_condition ){


        //盐城市公安局人员基本信息定制数据查询服务
        String serviceID = Consts.S32_09000142;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "rksj";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult result = new HttpResult();

            try {

                String cz =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  cz_condition);
                String zz =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  zz_condition);

                Map<String , String> map = new HashMap<>();
                map.put("cz" , cz);
                map.put("zz" , zz);


                result.setData(map);


            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            //缓存数据
            cache.putCacheWithExpireTime(key, result , RedisCache.CAHCETIME);
            cacheData = result ;
        }


        return cacheData;
    }


    /**
     *  网吧数据
     */
    @RequestMapping(value="/wbsj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult wbsj(HttpServletRequest request, HttpSession session ,  String wb_condition , String sw_condition){

        //盐城市公安局网吧信息定制数据查询服务
        String serviceID = Consts.S32_09000468;


        int startRow = 0 ;
        int numRow = 100 ;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "wbsj";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult result = new HttpResult();

            List<CybercafeDto> cybercafeDtoList = new ArrayList<>();

            try {

                QueryDemo queryDemo = new QueryDemo();

                String wangbaJson =  queryDemo.selfCallQueryLocal( serviceID ,  wb_condition ,  startRow ,  numRow );
                List<Map> wbList = SelfXmlUtil.initDataList(wangbaJson);


                for (int i = 0; i < wbList.size(); i++) {
                    Map<String , ColumnDetail> map =  wbList.get(i);

                    //获取结果
                    String name = map.get("YYCSMC").getContent();
                    String address = map.get("DZ").getContent();

                    //网吧代码
                    //盐城市公安局网吧上网人员信息定制数据查询服务
                    String S32_09000148 = Consts.S32_09000148;

                    String YYCSDM =  map.get("YYCSDM").getContent();
                    String personCount = "";

//                try {
//                    personCount =  queryDemo.selfCallQueryCountInLocal( S32_09000148 ,  sw_condition + " and   YYCSDM = '"+YYCSDM+ "'");
//                }catch(Exception e){
//                    e.printStackTrace();
//                }

                    //赋值
                    CybercafeDto dto = new CybercafeDto();
                    dto.setName(name);
                    dto.setAddress(address);
                    dto.setPersonCount(personCount);

                    cybercafeDtoList.add(dto);
                }




            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }


            result.setData(cybercafeDtoList);


            //缓存数据
            cache.putCacheWithExpireTime(key, result , RedisCache.CAHCETIME);
            cacheData = result ;
        }


        return cacheData;
    }


    /**
     *  酒店数据
     */
    @RequestMapping(value="/jdsj",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jdsj(HttpServletRequest request, HttpSession session , String condition , String time){

        ////盐城市公安局旅馆信息数据定制查询服务v01
        String serviceID = Consts.S32_09000300;

        //盐城市公安局国内旅客住宿信息定制数据查询服务v01
        String S32_09000150 = Consts.S32_09000150;

        int startRow = 0 ;
        int numRow = 40 ;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String nowTime = sdf.format(new Date());



        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "jdsj";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){


            HttpResult result = new HttpResult();

            List<RoomDto> dataList = new ArrayList<>();

            try {

                String json =  new QueryDemo().selfCallQueryLocal( serviceID ,  condition ,  startRow ,  numRow );
                List<Map> list = SelfXmlUtil.initDataList(json);

                for (int i = 0; i < list.size(); i++) {
                    Map<String , ColumnDetail> map =  list.get(i);

                    //获取结果
                    String name = map.get("L_NAME").getContent();
                    String address = map.get("L_ADDR").getContent();
                    //总床位
                    String count =  map.get("L_BED").getContent();

                    //旅馆机构代码
                    String L_CODE = map.get("L_CODE").getContent();


                    //查询指定旅馆
                    String nowCount =  new QueryDemo().selfCallQueryCountInLocal( S32_09000150 ,  " L_CODE = '" + L_CODE + "'  and  G_INDATE >= '" + nowTime + "'");


                    //赋值
                    RoomDto roomDto = new RoomDto();
                    roomDto.setName(name);
                    roomDto.setAddress(address);
                    roomDto.setCount(count);
                    roomDto.setNowCount(nowCount);

                    //添加
                    dataList.add(roomDto);
                }

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //赋值返回数据
            result.setData(dataList);



            //缓存数据
            cache.putCacheWithExpireTime(key, result , RedisCache.CAHCETIME);
            cacheData = result ;
        }


        return cacheData;
    }

    /**
     *  数据统计
     */
    @RequestMapping(value="/sjtjChart",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult sjtjChart(HttpServletRequest request, HttpSession session , String condition , String year){

        //盐城市公安局处警信息定制数据查询服务v01
        String serviceID = Consts.S32_09000126;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "sjtjChart";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);


        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();

            Map<String , List> map = new HashMap<>();

            List<String> list = new ArrayList<>();

            for (int i = 1; i <= 12; i++) {

                String time = "" ;
                if(i <= 9){
                    time = "  and  CJSJ  >= '" + year + "0" + i + "01'" + "  and  CJSJ  <= '" + year + "0" + i + "31'";
                }else{
                    time = "  and  CJSJ  >= '" + year + i + "01'" + "  and  CJSJ  <= '" + year + i + "31'";
                }

                try {
                    String count =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  condition + time);
                    list.add(count);
                } catch (ResourceServiceException e) {
                    e.printStackTrace();

                    list.add("");
                }

            }

            map.put("jq", list);

            httpResult.setData(map);



            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;
    }




    /**
     *  今日警情
     */
    @RequestMapping(value="/jrjq",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jrjq(HttpServletRequest request, HttpSession session , String condition){

        //盐城市公安局处警信息定制数据查询服务v01
        String serviceID = Consts.S32_09000126;

        int startRow = 0 ;
        int numRow = 100 ;


        //得到该派出所的key值
        Policestation policestation = (Policestation) session.getAttribute("policestation");
        String code = policestation.getCode();
        String key = code + "-" + "jrjq";

        //拿缓存数据
        HttpResult cacheData = cache.getCache(key, HttpResult.class);

        //如果没有缓存
        if(cacheData == null){

            HttpResult httpResult = new HttpResult();

            List<PoliceMessageDto> dataList = new ArrayList<>();

            try {

                String json =  new QueryDemo().selfCallQueryLocal( serviceID ,  condition ,  startRow ,  numRow );
                List<Map> list = SelfXmlUtil.initDataList(json);

                for (int i = 0; i < list.size(); i++) {
                    Map<String , ColumnDetail> map =  list.get(i);

                    //获取结果
                    String time = map.get("CJSJ").getContent();
                    String content = map.get("FSYY").getContent();
                    String shortContent = map.get("CLJGNR").getContent();
                    String phone = map.get("CJRLXFS").getContent();
                    //处警地址X坐标
                    String GIS_X = map.get("GIS_X").getContent();
                    //处警地址Y坐标
                    String GIS_Y = map.get("GIS_Y").getContent();

                    //处警接警单编号
                    String JJDBH = map.get("JJDBH").getContent();


                    //赋值
                    PoliceMessageDto dto = new PoliceMessageDto();
                    dto.setTime(time);
                    dto.setContent(content);
                    dto.setPhone(phone);
                    dto.setShortContent(shortContent);
                    dto.setGIS_X(GIS_X);
                    dto.setGIS_Y(GIS_Y);
                    dto.setJjdbh(JJDBH);

                    //添加
                    dataList.add(dto);
                }

            } catch (ResourceServiceException e) {
                e.printStackTrace();
            }

            //赋值返回数据
            httpResult.setData(dataList);


            //缓存数据
            cache.putCacheWithExpireTime(key, httpResult , RedisCache.CAHCETIME);
            cacheData = httpResult ;
        }


        return cacheData;

    }


    /**
     *  今日警情 不缓存
     */
    @RequestMapping(value="/jrjqNotCache",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jrjqNotCache(HttpServletRequest request, HttpSession session , String condition){

        //盐城市公安局处警信息定制数据查询服务v01
        String serviceID = Consts.S32_09000126;

        int startRow = 0 ;
        int numRow = 100 ;


        HttpResult httpResult = new HttpResult();

        List<PoliceMessageDto> dataList = new ArrayList<>();

        try {

            String json =  new QueryDemo().selfCallQueryLocal( serviceID ,  condition ,  startRow ,  numRow );
            List<Map> list = SelfXmlUtil.initDataList(json);

            for (int i = 0; i < list.size(); i++) {
                Map<String , ColumnDetail> map =  list.get(i);

                //获取结果
                String time = map.get("CJSJ").getContent();
                String content = map.get("FSYY").getContent();
                String shortContent = map.get("CLJGNR").getContent();
                String phone = map.get("CJRLXFS").getContent();
                //处警地址X坐标
                String GIS_X = map.get("GIS_X").getContent();
                //处警地址Y坐标
                String GIS_Y = map.get("GIS_Y").getContent();

                //处警接警单编号
                String JJDBH = map.get("JJDBH").getContent();


                //赋值
                PoliceMessageDto dto = new PoliceMessageDto();
                dto.setTime(time);
                dto.setContent(content);
                dto.setPhone(phone);
                dto.setShortContent(shortContent);
                dto.setGIS_X(GIS_X);
                dto.setGIS_Y(GIS_Y);
                dto.setJjdbh(JJDBH);

                //添加
                dataList.add(dto);
            }

        } catch (ResourceServiceException e) {
            e.printStackTrace();
        }

        //赋值返回数据
        httpResult.setData(dataList);
        return httpResult;
    }


    /**
     *  今日稳情
     */
    @RequestMapping(value="/jrwq",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jrwq(HttpServletRequest request, HttpSession session ,Integer policestationId){

        StabilityCriteria stabilityCriteria = new StabilityCriteria();
        stabilityCriteria.createCriteria().andPolicestationidEqualTo(policestationId);

        List<Stability> list = stabilityService.selectByExample(stabilityCriteria);

        HttpResult httpResult = new HttpResult();
        httpResult.setData(list);

        return httpResult;
    }

    /**
     *  今日舆情
     */
    @RequestMapping(value="/jryq",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult jryq(HttpServletRequest request, HttpSession session ,Integer policestationId){


        PublicsentimentCriteria publicsentimentCriteria = new PublicsentimentCriteria();
        publicsentimentCriteria.createCriteria().andPolicestationidEqualTo(policestationId);

        List<Publicsentiment> list = publicsentimentService.selectByExample(publicsentimentCriteria);

        HttpResult httpResult = new HttpResult();
        httpResult.setData(list);

        return httpResult;
    }




    /**
     *  testDemo
     */
    @RequestMapping(value="/testDemo",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult testDemo(HttpServletRequest request, HttpSession session ,  String condition , String serviceID){



        int startRow = 0 ;
        int numRow = 10 ;


        HttpResult result = new HttpResult();


        try {



            String wangbaJson =  new QueryDemo().selfCallQueryLocal( serviceID ,  condition ,  startRow ,  numRow );
            List<Map> datalist = SelfXmlUtil.initDataList(wangbaJson);



            result.setData(datalist);




        } catch (ResourceServiceException e) {
            e.printStackTrace();
        }



        return result;
    }

    /**
     *  testCount
     */
    @RequestMapping(value="/testCount",method = {RequestMethod.POST,RequestMethod.GET})
    @ResponseBody
    public HttpResult testCount(HttpServletRequest request, HttpSession session , String condition , String serviceID){
        HttpResult result = new HttpResult();


        try {

            String count =  new QueryDemo().selfCallQueryCountInLocal( serviceID ,  condition);

            result.setData(count);

        } catch (ResourceServiceException e) {
            e.printStackTrace();
        }
        return result;
    }

}

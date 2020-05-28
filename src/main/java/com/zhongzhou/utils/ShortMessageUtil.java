package com.zhongzhou.utils;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

public class ShortMessageUtil {



    public static String buildRequestXMLString(String id, String pwd, String serviceid, String phone, String content)
    {
        StringBuffer sb = new StringBuffer();

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>")
                .append("<svc_init ver=\"2.0.0\">")
                .append("<sms ver=\"2.0.0\">")
                .append("<client>")
                .append("<id>").append(id).append("</id>")
                .append("<pwd>").append(pwd).append("</pwd>")
                .append("<serviceid>").append(serviceid).append("</serviceid>")
                .append("</client>")
                .append("<sms_info>")
                .append("<phone>").append(phone).append("</phone>")
                .append("<content>").append(content).append("</content>")
                .append("</sms_info>")
                .append("</sms>")
                .append(" </svc_init>");

        System.out.println(sb.toString());
        return sb.toString();
    }

    public static String postXMLSendSMSRequest(String servletUrl , String content)
    {
        String result = null;

        BufferedReader br = null;
        OutputStreamWriter out = null;
        HttpURLConnection con = null;

        try
        {
            URL url= new URL(servletUrl);

            con=(HttpURLConnection)url.openConnection();
            con.setDoOutput(true);
            con.setRequestMethod("POST");

            out=new OutputStreamWriter(con.getOutputStream(),"UTF-8");

            out.write(content);

            out.flush();

            br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));

            String line = null;

            StringBuilder sb = new StringBuilder();

            while((line = br.readLine())!=null)
            {
                sb.append(line);
            }

            result = sb.toString();

            System.out.println(result);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if(br != null)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            if(out != null)
            {
                try
                {
                    out.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }

            if(con != null)
            {
                con.disconnect();
                con = null;
            }
        }

        return result;
    }

    public static void demo(){
        //下面的MAS_ID、PASSWORD仅供测试使用，正式使用由移动公司分配
        String MAS_ID = "182";
        String PASSWORD = "bYcLgYwXOZspDzEnaGsNHAGUykKEiexknHY9H98xVTQ8Zbeya8bexQ==";

        String reqXML = buildRequestXMLString(MAS_ID,PASSWORD,"","18360702148","测试短信");

        postXMLSendSMSRequest("http://218.204.110.232:8080/emc/HttpSendSMSService",reqXML);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {




    }


    /**
     * 解析xml字符串
     */
    public static HttpResult parseXml(String xml){

        //返回数据
        HttpResult result = new HttpResult();



        try {

            //加载xml
            Document doc = DocumentHelper.parseText(xml);

            //获取根节点
            Element rootElement = doc.getRootElement();

            //获取response_info节点
            Element response_info_el = rootElement.element("response_info");


            //返回id
            String gwid = response_info_el.element("gwid").getText();

            //返回编码
            String retcode = response_info_el.element("retcode").getText();

            //返回结果
            String retmesg = response_info_el.element("retmesg").getText();



            //如果结果是空 或 空字符串 （说明 : 没连接上 或 出现异常）
            if(retcode == null || "".equals(retcode)){
                result.setCode(Consts.ERROR);
                result.setData("发送短信错误,请联系管理员!");


            //发送成功
            }else if("00".equals(retcode)){
                result.setCode(Consts.SUCCESS);
                result.setData(retmesg);

            //发送错误
            }else{
                result.setCode(Consts.ERROR);
                result.setData(retmesg);
            }


        } catch (DocumentException e) {
            e.printStackTrace();
        }




        return result;
    }



    /**
     * 发送消息
     */
    public static HttpResult sendMessage(String phone , String content){

        System.out.println("<<====================");
        System.out.println("号码 : " + phone);
        System.out.println("<<====================");
        System.out.println("短信内容 : " + content);

        //下面的MAS_ID、PASSWORD仅供测试使用，正式使用由移动公司分配
        String MAS_ID = "296";
        String PASSWORD = "y0xrcB3XZN8Xfklz8BaK3IsVUlCW2MY5YN62w1avbKY8Zbeya8bexQ==";
        String serviceId = "106573020303";

        String servletUrl = "http://218.204.70.28:8080/sjb/HttpSendSMSService";

        String reqXML = buildRequestXMLString(MAS_ID,PASSWORD,serviceId, phone , content);

        //返回结果xml
        String xmlResult = postXMLSendSMSRequest(servletUrl , reqXML);


        //解析xml字符串
        return parseXml(xmlResult);
    }


}

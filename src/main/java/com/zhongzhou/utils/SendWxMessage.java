package com.zhongzhou.utils;


import com.fasterxml.jackson.databind.JsonNode;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 推送微信消息
 */
public class SendWxMessage {

    /**
     * 推送文本消息
     */
    public static boolean send_msg_text(String touser, String content){
        // 拼接请求地址
        String requestUrl = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + AccessToken.getAccessToken();
        String postJson = "{\"touser\": \"%s\",\"agentid\":%s,\"msgtype\": \"%s\",\"text\":{\"content\": \"%s\"},\"safe\":0}";
        String outputStr = String.format(postJson, touser, Consts.ZZKJ_JINHUO_AGENTID, "text",content);
        JsonNode node = HttpRequestUtils.sendPost(requestUrl, outputStr);
        if(Integer.parseInt(node.get("errcode").toString())==0){
            return true;
        }
        return false;
    }

    /**
     * 推送文本消息
     */
    public static boolean send_msg_text_multiple(List<String> touserList, String content){

        String touser = "";
        for (int i = 0; i < touserList.size(); i++) {

            //最后一个
            if(touserList.size() - 1 == i){

                touser = touser + touserList.get(i);

            }else{
                touser = touser + touserList.get(i) + "|";
            }
        }

        System.out.println(touser);

        return send_msg_text( touser,  content);
    }


    public static void main(String args[]){

        List<String> touserList = new ArrayList<>();

        touserList.add("18360702148");
        touserList.add("18925437673");


        send_msg_text_multiple(touserList , "1111" );

    }

}

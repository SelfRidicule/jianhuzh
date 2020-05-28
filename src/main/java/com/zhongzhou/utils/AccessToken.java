package com.zhongzhou.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AccessToken {
	
	private static Date lnTime;
	
	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static String access_token_ln;
	
	private static ObjectMapper jsonMapper=new ObjectMapper();
	
	//���access_token
	public static String getAccessToken(){
		Date nowDate=new Date();
		if (lnTime == null || (nowDate.getTime() - lnTime.getTime()) > 1000 * 60 * 60) {
			lnTime = new Date();
			access_token_ln=getAT(Consts.ZZKJ_CROPID,Consts.ZZKJ_JINHUO_SECRET);
		}
		return access_token_ln;	
	}	
	
	// ��ȡ��Ա��Ϣ
	public static String getAT(String appID, String appScret) {
				
		// ����΢�ŷ�����
		String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + appID + "&corpsecret=" + appScret;
		try {
			URL getUrl = new URL(url);
			HttpURLConnection http = (HttpURLConnection) getUrl.openConnection();
			http.setRequestMethod("GET");
			http.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			http.connect();
			InputStream is = http.getInputStream();
			int size = is.available();
			byte[] b = new byte[size];
			is.read(b);

			String message = new String(b,"UTF-8");
			JsonNode jn=jsonMapper.readTree(message);
			String access_token=jn.get("access_token").asText();
			return access_token;      //����access_token
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
}

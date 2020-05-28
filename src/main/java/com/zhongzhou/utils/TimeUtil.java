package com.zhongzhou.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	private static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	public static String getNowTime(){
		String nowtime=sdf.format(new Date());		
		return nowtime;
	}
	
	
}

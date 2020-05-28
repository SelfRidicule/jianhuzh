package com.zhongzhou.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SelfDateUtil {
	/**
	 * 今日
	 */
	public static String TODATY = "今日";
	/**
	 * 本周
	 */
	public static String WEEK = "本周";
	/**
	 * 本月
	 */
	public static String MONTH = "本月";
	/**
	 * 今年
	 */
	public static String YEAR = "今年";

//	public String[] getStrDate(String str) {
//		String[] result = new String[2];
//		String startdate = "";
//		String enddate = "";
//		Date d = new Date();
//		if (str.equals(SelfDateUtil.TODATY)) {
//			startdate = date2String(d) + "000000";
//			enddate = time2String(d);
//		} else if (str.equals(SelfDateUtil.WEEK)) {
//			startdate = date2String(new Date(d.getTime() - (long) 7 * 24 * 60 * 60 * 1000)) + "000000";
//			enddate = time2String(d);
//		} else if (str.equals(SelfDateUtil.MONTH)) {
//			startdate = date2String(new Date(d.getTime() - (long) 30 * 24 * 60 * 60 * 1000)) + "000000";
//			enddate = time2String(d);
//		} else if (str.equals(SelfDateUtil.YEAR)) {
//			Calendar cal = Calendar.getInstance();
//			startdate = cal.get(Calendar.YEAR) + "0101000000";
//			enddate = time2String(d);
//		} else if (str.contains("#")) {
//			result = getZDY(str);
//		}
//		result[0] = startdate;
//		result[1] = enddate;
//		return result;
//	}

	public Date[] getDate(String str) {
		Date[] result = new Date[2];
		Date startdate = new Date();
		Date enddate = new Date();
		Date d = new Date();
		if (str.equals(SelfDateUtil.TODATY)) {
			startdate = string2Time(date2String(d) + "000000");
			// enddate = d;
		} else if (str.equals(SelfDateUtil.WEEK)) {
			startdate = string2Time(date2String(new Date(d.getTime() - (long) 7 * 24 * 60 * 60 * 1000)) + "000000");
			// enddate = d;
		} else if (str.equals(SelfDateUtil.MONTH)) {
			startdate = string2Time(date2String(new Date(d.getTime() - (long) 30 * 24 * 60 * 60 * 1000)) + "000000");
			// enddate = d;
		} else if (str.equals(SelfDateUtil.YEAR)) {
			Calendar cal = Calendar.getInstance();
			startdate = string2Time(cal.get(Calendar.YEAR) + "0101000000");
			// enddate = d;
		} else if (str.contains("!")) {
			result = getZDY(str);
			startdate = result[0];
			enddate = result[1];
		}
		result[0] = startdate;
		result[1] = enddate;
		return result;
	}
	/**
	 * 计算质态时间（从上个月21日到当月20日，从上个年度12月21日到当月20日）
	 * @param str
	 * @return
	 */
	public Date[] getZTDate(String str) {
		Date[] result = new Date[2];
		Date startdate = new Date();
		Date enddate = new Date();
		Date d = new Date();
		Calendar cal = Calendar.getInstance();
		if (str.equals(SelfDateUtil.TODATY)) {
			enddate = d;
			startdate = string2Time(date2String(enddate) + "000000");
		} else if (str.equals(SelfDateUtil.WEEK)) {
			enddate = d;
			startdate = string2Time(
					date2String(new Date(enddate.getTime() - (long) 7 * 24 * 60 * 60 * 1000)) + "000000");

		} else if (str.equals(SelfDateUtil.MONTH)) {
			// 取得本天是该月第几天
			int day = cal.get(Calendar.DAY_OF_MONTH);
			// 从21->现在
			if (day > 20) {
				enddate = d;
				if (cal.get(Calendar.MONTH) > 9) {
					startdate = string2Time(
							cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH) + 1) + "" + "21000000");
				} else {
					startdate = string2Time(
							cal.get(Calendar.YEAR) + "0" + (cal.get(Calendar.MONTH) + 1) + "" + "21000000");
				}
			}
			// 从上个月21->现在
			else {
				enddate = d;
				if (cal.get(Calendar.MONTH) > 10) {
					startdate = string2Time(cal.get(Calendar.YEAR) + "" + (cal.get(Calendar.MONTH)) + "" + "21000000");
				} else {
					startdate = string2Time(cal.get(Calendar.YEAR) + "0" + (cal.get(Calendar.MONTH)) + "" + "21000000");
				}
			}
		} else if (str.equals(SelfDateUtil.YEAR)) {

			startdate = string2Time(cal.get(Calendar.YEAR) - 1 + "1221000000");
			enddate = d;
		} else if (str.contains("!")) {
			result = getZDY(str);
			startdate = result[0];
			enddate = result[1];
		}
		result[0] = startdate;
		result[1] = enddate;
		return result;
	}

	/**
	 * 获取同比的时间
	 *
	 * @param str
	 * @return
	 */
	public Date[] getTBDate(String str) {

		Date[] temp = getZTDate(str);
		Date startdate = temp[0];
		Date enddate = temp[1];
		Date[] result = new Date[2];
		Calendar cal = Calendar.getInstance();
		cal.setTime(startdate);
		cal.add(Calendar.YEAR, -1);
		startdate = cal.getTime();

		cal.setTime(enddate);
		cal.add(Calendar.YEAR, -1);
		enddate = cal.getTime();
		result[0] = startdate;
		result[1] = enddate;
		return result;
	}


	public Date[] getZDY(String str)
	{
		Date[] resDate= new Date[2];
		String[] strs = str.split("!");
		if(strs[0]!=null)
		{
			resDate[0] = str2Date_(strs[0]);
		}
		if(strs[1]!=null)
		{
			resDate[1] = str2Date_(strs[1]);
		}
		return resDate;
	}

	SimpleDateFormat sdfTime = new SimpleDateFormat("yyyyMMddHHmmss");

	public String time2String(Date date) {
		if (date == null) {
			return null;
		}
		return sdfTime.format(date);
	}

	public Date string2Time(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		try {
			return sdfTime.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	SimpleDateFormat sdfDate = new SimpleDateFormat("yyyyMMdd");

	public String date2String(Date date) {
		if (date == null) {
			return null;
		}
		return sdfDate.format(date);
	}

	public Date string2Date(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		try {
			return sdfDate.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	static SimpleDateFormat datesdf = new SimpleDateFormat("yyyy-MM-dd");

	public String date2Str_(Date date) {
		if (date == null) {
			return null;
		}
		return datesdf.format(date);
	}

	public Date str2Date_(String str) {
		if (str == null || "".equals(str)) {
			return null;
		}
		try {
			return datesdf.parse(str);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");

	public String year2String(Date date) {
		if (date == null) {
			return null;
		}
		return sdfDate.format(date);
	}
}

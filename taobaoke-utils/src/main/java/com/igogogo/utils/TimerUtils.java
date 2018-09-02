package com.igogogo.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimerUtils {

	/**
	 * 把日期往后增加一天.整数往后推,负数往前移动
	 * 
	 * @param amount
	 */
	public static String getTimer(int amount) {
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, amount);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String tomorrow = sdf.format(date);
		return tomorrow;
	}

}

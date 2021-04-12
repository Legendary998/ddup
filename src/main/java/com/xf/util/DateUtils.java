package com.xf.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
	//Date toDateTime(value, format)
	//Date toDate8(value)//yyyy-MM-dd
	//Date toTime6(value)//HH:mm:ss
	//Date toDateTime12(value)//yyyy-MM-dd HH:mm:ss
	/**
	 * 字符串转换成日期
	 * @param value 日期字符串 
	 * @param format 日期格式
	 * @return
	 * @throws ParseException 
	 */
	public static Date toDateTime(String value, String format) throws ParseException{
		SimpleDateFormat sf = new SimpleDateFormat(format);
		return sf.parse(value);		
	}
	/**
	 * 字符串转换成日期
	 * @param value 日期字符串
	 * @return
	 * @throws ParseException 
	 */
	public static Date toDate8(String value) throws ParseException{
		//str="yyyy-MM-dd";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.parse(value);
			
	} 
	/**
	 * 字符串转换成日期
	 * @param value 日期字符串
	 * @return 
	 * @throws ParseException 
	 */
	public static Date toTime6(String value) throws ParseException{
		//str="HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			return format.parse(value);
		
	}
	/**
	 * 字符串转换成日期
	 * @param value 日期字符串
	 * return 
	 * @throws ParseException 
	 */
	public static Date toDateTime12(String value) throws ParseException{
		//str="yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return format.parse(value);
	}
	
}

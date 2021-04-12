package com.xf.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTools {
	
	/**
	 * 判断字符串是否为null或""
	 * @param o 字符串
	 * @return true or false
	 */
	public static boolean isNullOrEmpty(String o) {
		if(o == null || "".equals(o.trim())){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断是否为手机号码
	 * @param mobile
	 * @return
	 */
	public static boolean isMobile(String mobile) {
		Pattern p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$");
		Matcher m = p.matcher(mobile);
		return m.matches();
	}
	
	/**
	 * 判断是否为email
	 * @param email
	 * @return
	 */
	public static boolean isEmail(String email) {
		Pattern p = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
		Matcher m = p.matcher(email);
		return m.matches();
	}

	/**
	 * 拼接数组
	 * @author wuzhangshan
	 * @date 2017-2-13
	 * @param array
	 * @param split 分隔符
	 * @return
	 */
	public static String join(String[] array, String split) {
		StringBuffer sb = new StringBuffer();
		for (String str : array) {
			if(!StringTools.isNullOrEmpty(str)){
				sb.append(str + split);
			}
		}
		String string = sb.toString();
		if(string.length() > 0){
			return string.substring(0, string.length()-1);
		}
		return string;
	}
}

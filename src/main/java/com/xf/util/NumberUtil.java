package com.xf.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @Title:
 * @Description: 数字操作常用库
 * @Company: teleware
 * @author wangtengfei
 * @date 2015-9-7
 * @vesion 1.0
 */
public class NumberUtil {
	/**
	 * @Description: 将阿拉伯数字转换为中文汉字（小写）
	 * @author changzhendong
	 * @param num
	 *            待转换的值
	 * @return 转换后的值
	 */
	public static String int2ChineseNumber(int num) {

		String[] BITS = { "一", "二", "三", "四", "五", "六", "七", "八", "九", "十" };

		String[] TEENS = { "十一", "十二", "十三",

		"十四", "十五", "十六", "十七", "十八", "十九" };

		String[] TIES = { "二十", "三十", "四十", "五十", "六十", "七十", "八十", "九十" };

		if (num < 0 || num > 9999) {
			return null;
		} else {
			if (num == 0) {
				return "零";
			}
			StringBuffer buffer = new StringBuffer();
			if (num >= 1000) {
				int hunder = num / 1000;
				String thousand = BITS[hunder - 1] + "千";
				buffer.append(thousand);
				num -= (num / 1000) * 1000;
			}
			if (num >= 100) {
				int hunder = num / 100;
				String hundred = BITS[hunder - 1] + "百";
				buffer.append(hundred);
				num -= (num / 100) * 100;
			}
			boolean largerThan20 = false;
			if (num >= 20) {
				largerThan20 = true;
				int ties = num / 10;
				String Than = TIES[ties - 2];
				buffer.append(Than);
				num -= (num / 10) * 10;
			}
			if (!largerThan20 && num > 10) {
				String Teen = TEENS[num - 11];
				buffer.append(Teen);
				num = 0;
			}
			if (num > 0) {
				String bit = BITS[num - 1];
				buffer.append(bit);
			}
			String english = buffer.toString();
			return english;
		}
	}

	/**
	 * 提供精确加法计算的add方法
	 * 
	 * @param value1
	 *            被加数
	 * @param value2
	 *            加数
	 * @return 两个参数的和
	 */
	public static double accurateAdd(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.add(b2).doubleValue();
	}

	/**
	 * 提供精确减法运算的sub方法
	 * 
	 * @param value1
	 *            被减数
	 * @param value2
	 *            减数
	 * @return 两个参数的差
	 */
	public static double accurateSub(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.subtract(b2).doubleValue();
	}

	/**
	 * 提供精确乘法运算的mul方法
	 * 
	 * @param value1
	 *            被乘数
	 * @param value2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static double accurateMul(double value1, double value2) {
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.multiply(b2).doubleValue();
	}

	/**
	 * 提供精确的除法运算方法div
	 * 
	 * @param value1
	 *            被除数
	 * @param value2
	 *            除数
	 * @param scale
	 *            精确范围
	 * @return 两个参数的商
	 * @throws IllegalAccessException
	 */
	public static double accurateDiv(double value1, double value2, int scale)
			throws IllegalAccessException {
		// 如果精确范围小于0，抛出异常信息
		if (scale < 0) {
			throw new IllegalAccessException("精确度不能小于0");
		}
		BigDecimal b1 = new BigDecimal(Double.valueOf(value1));
		BigDecimal b2 = new BigDecimal(Double.valueOf(value2));
		return b1.divide(b2, scale).doubleValue();
	}


	/**
	 * @Description: 根据坐标的X轴Y轴的最大点和坐标轴的宽度和高度，获得XY轴可以放大的最大比例
	 * @author wangtengfei
	 * @param xmax
	 * @param ymax
	 * @param width
	 * @param height
	 * @return 最大比例
	 */
	public static double magniscale(double xmax, double ymax, double width,
			double height) {
		// 加大面积用于显示拐点号
		width = width - 30;
		height = height - 30;
		double scaleX = (double) (width / xmax);
		double scaleY = (double) (height / ymax);
		return scaleX >= scaleY ? scaleY : scaleX;
	}

	/**
	 * @Description: 格式化double类型数字
	 * @author wangtengfei
	 * @param value
	 *            待格式化值
	 * @param digit
	 *            保留小数位数
	 * @return 格式化后值,参数错误返回0.
	 */
	public static double formatDoubleValue(double value, int digit) {

		if (digit < 0)
			return 0;

		double result = 0;
		String tempResult = "";

		StringBuffer formatParam = new StringBuffer("0.");
		for (int i = 0; i < digit; i++)
			formatParam.append("0");

		DecimalFormat df = new DecimalFormat(formatParam.toString());
		tempResult = df.format(value);

		if (!StringTools.isNullOrEmpty(tempResult))
			result = Double.valueOf(tempResult);

		return result;
	}
	
	/**
	 * @Description: 根据两个坐标点算变长（第一个点与最后一个点算变长，第二个点与第一个点算变长）
	 * @author wangtengfei
	 * @param x1
	 *            后点X坐标
	 * @param y1
	 *            后点Y坐标
	 * @param x2
	 *            前点X坐标
	 * @param y2
	 *            前点Y坐标
	 * @return 两个点的变长
	 */
	public static Double calLengtOfSide(Double x1, Double y1, Double x2,
			Double y2) {

		if (null == x1 || null == y1 || null == x2 || null == y2)
			return null;

		Double result = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

		return formatDoubleValue(Math.sqrt(result), 4);
	}

	/**
	 * @Description: 将Double类型转换成BigDecimal
	 * @author wangtengfei
	 * @param doubleValue
	 *            待转换的值
	 * @param scale
	 *            小数点位数（四舍五入）
	 * @return Double值对应的BigDecimal
	 */
	public static BigDecimal doubleToBigDecimal(Double doubleValue, int scale) {
		if (null == doubleValue)
			return null;
		BigDecimal result = new BigDecimal(doubleValue).setScale(scale,
				BigDecimal.ROUND_HALF_UP);

		return result;
	}
	/**
	 * @Description: 将Double类型转换成BigDecimal
	 * @author wwx
	 * @param doubleValue
	 *            待转换的值
	 * @return Double值对应的BigDecimal
	 */
	public static BigDecimal doubleToBigDecimal(Double doubleValue) {
		if (null == doubleValue)
			doubleValue=0d;
		BigDecimal result = new BigDecimal(doubleValue);
		return result;
	}
	/**
	 * @Description: 将BigDecimal类型转换成Double
	 * @author wangtengfei
	 * @param bigDecimalValue
	 *            待转换的值
	 * @param scale
	 *            小数点位数（四舍五入）
	 * @return Double值对应的Double
	 */
	public static Double bigDecimalToDouble(BigDecimal bigDecimalValue, int scale) {
		if (null == bigDecimalValue)
			return null;
		return bigDecimalValue.setScale(scale,BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	
	/**
	 * @Description: 将Double类型转换成BigDecimal
	 * @author czd
	 * @param longValue
	 *            待转换的值
	 * @return Long值对应的BigDecimal
	 */
	public static BigDecimal longToBigDecimal(Long longValue, int scale) {
		if (null == longValue)
			return null;
		BigDecimal result = new BigDecimal(longValue).setScale(scale,
				BigDecimal.ROUND_HALF_UP);

		return result;
	}
	
	/**
	 * @Description: 将BigDecimal类型转换成Long
	 * @author czd
	 * @param bigDecimalValue
	 *            待转换的值
	 * @param scale
	 *            小数点位数（四舍五入）
	 * @return Long值对应的Long
	 */
	public static Long bigDecimalToLong(BigDecimal bigDecimalValue, int scale) {
		if (null == bigDecimalValue)
			return null;
		return bigDecimalValue.setScale(scale,BigDecimal.ROUND_HALF_UP).longValue();
	}
	
	/**
	* @Description: 王伟欣遗漏未提交方法
	* @author wangtengfei
	* @param doubleValue
	* @param scale
	* @return
	 */
	public static BigDecimal doubleToBigDecimalZero(Double doubleValue, int scale)
	  {
	    if (doubleValue == null)
	      doubleValue = Double.valueOf(0.0D);
	    BigDecimal result = new BigDecimal(doubleValue.doubleValue()).setScale(scale, 
	      4);

	    return result;
	  }
	
	/**
	 * double为空则返回0
	* @Title: doubleNullToZero
	* @Description: TODO(这里用一句话描述这个方法的作用)
	* @author wangfh
	* @param doubleValue
	* @return
	* @throws
	 */
	public static Double doubleNullToZero(Double doubleValue) {
		if (null == doubleValue)
			doubleValue=0d;

		return doubleValue;
	}
	
	/**
	 * 保留一位小数
	 * @param dou
	 * @return
	 */
	public static Double saveOnePoint(Double dou){
		if (dou==null) {
			return 0.0;
		}
		DecimalFormat decimalFormat = new DecimalFormat(".#");

		double d =Double.parseDouble(decimalFormat.format(dou)) ;
		return d;
	} 
	/**
	 * Long转Integer
	 * @param lon
	 * @return
	 */
	public static Integer longToInteger(Long lon){
		if (lon==null) return null;
		return lon.intValue();
	}
	/**
	 * 
	 * @Description:
	 * @Company: tlw
	 * @author: changzhendong 
	 * @param lon
	 * @return
	 */
	public static Long integerToLong(Integer lon){
		if (lon==null) return null;
		return lon.longValue();
	}
	
	/**
	 * 
	 * @Description:
	 * @Company: tlw
	 * @author: changzhendong 
	 * @param lon
	 * @return
	 */
	public static Long integerTolong(Integer lon){
		if (lon==null) return 0l;
		return lon.longValue();
	}
}

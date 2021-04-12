package com.xf.util;

import java.io.InputStream;
import java.util.Properties;

public class ConfigTools {

	private static final String configString = "/config.properties";

	private static Properties prop = new Properties();

	static {
		InputStream in = ConfigTools.class.getResourceAsStream(configString);
		try {
			prop.load(in);
			System.out.println("common.ConfigTools@成功加载config文件...");
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("无法加载" + configString);
		}
	}

	public static String getValue(String key) {
		String value = "";
		try {
			value = prop.getProperty(key);
		} catch (Exception e) {
			
		}
		return StringTools.isNullOrEmpty(value)? "" : value;
	}

	public static void main(String[] args) {
		String s = ConfigTools.getValue("framework.operlog1");
		System.out.println(s.toLowerCase());
		System.out.println("true".equals(s));
	}
}

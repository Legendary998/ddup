package com.xf.util;

import java.util.UUID;

/**
 * UUID 工具
 * @author Administrator
 *
 */
public class UUIDTools {

	/**
	 * 生成UUID
	 * @return 返回32位字符串
	 */
	public static String randomUUID() {
		return UUID.randomUUID().toString().replace("-", "").toUpperCase();
	}
	
	
	public static void main(String[] args) {
		System.out.println(randomUUID());
	}
}

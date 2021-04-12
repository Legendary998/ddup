package com.xf.web.common;

/**
 * 操作日志TypeCode,TypeName枚举类型
 * @author Administrator
 *
 */
public enum LogMessageTypeEnum {
	MESSAGE("message", 0), EXCEPTION("exception", 1);

	/**
	 * 成员变量
	 */
	private String name;
	private int value;

	/**
	 * 构造函数
	 * @param name
	 * @param value
	 */
	LogMessageTypeEnum(String name, Integer value) {
		this.name = name;
		this.value = value;
	}
    
	/**
	 * get set 方法
	 * @return
	 */
    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    
    public static void main(String[] args) {
        System.out.println(LogMessageTypeEnum.MESSAGE.getName());
        System.out.println(LogMessageTypeEnum.MESSAGE.getValue());
    }
}

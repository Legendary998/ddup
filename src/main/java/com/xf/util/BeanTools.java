package com.xf.util;

import java.lang.reflect.Field;
import java.util.Date;


/**
 * bean相关工具
 * @author xuqifa
 *
 */
public class BeanTools {

	/**
	 * 复制对象的属性值到另一个对象（不复制空值）
	 * @param dest目标对象
	 * @param src源对象
	 * @param noCopyField不复制的字段集合
	 * @throws Exception
	 */
	public static void copyFieldValue(Object dest, Object src,
			String... noCopyField) throws Exception {
		if (dest.getClass() != src.getClass()) {
			throw new Exception("framework.utils.BeanTools对象类型不同");
		}
		try
		{
			// 读取类的属性集合
			Field[] destField = dest.getClass().getDeclaredFields();
			Field[] srcField = src.getClass().getDeclaredFields();
			for (int i = 0; i < destField.length; i++) {
				// 字段名、字段类型
				String destFieldName = destField[i].getName();
				String destFieldType = destField[i].getGenericType().toString();
				// 过滤不复制的字段
				boolean bolCopy = true;
				for (String field : noCopyField) {
					if (field.equals(destFieldName)) {
						bolCopy = false;
					}
				}
				if(destFieldName.equals("serialVersionUID"))
				{
					//序列化字段不复制
					bolCopy = false;
				}
				if (bolCopy) {
					for (int n = 0; n < srcField.length; n++) {
						String srcFieldName = srcField[n].getName();
						String srcFieldType = srcField[n].getGenericType()
								.toString();
						if (destFieldName.equals(srcFieldName)
								&& destFieldType.equals(srcFieldType)) {
							{
								destField[i].setAccessible(true);
								srcField[n].setAccessible(true);
								Object srcobj =  srcField[n].get(src);
								if (srcobj != null) {
									// 空值不复制
									srcField[n].set(dest, srcobj);
								}
							}
						}
					}
				}
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new Exception("framework.utils.BeanTools复制对象属性值异常");
		}
	}

	public static void main(String[] args) throws Exception,
			IllegalAccessException {
		Entity a = new Entity();
		Entity b = new Entity();
		b.setId("id......");
		b.setA1("aaaa");
		b.setA2(1111);
		b.setA3(new Date());
		
		a.setA4(2);
		//将b对象的属性值拷贝到a对象对应的属性中
		//id和a1字段的值不拷贝，空值不拷贝
		copyFieldValue(a, b, "a1","id");
		System.out.println("id="+a.getId());
		System.out.println("a1="+a.getA1());
		System.out.println("a2="+a.getA2());
		System.out.println("a3="+a.getA3());
		System.out.println("a4="+a.getA4());
	}
}

class Entity
{
	private String id;
	private String a1;
	private Integer a2;
	private Date a3;
	private Integer a4;
	
	public Integer getA4() {
		return a4;
	}
	public void setA4(Integer a4) {
		this.a4 = a4;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getA1() {
		return a1;
	}
	public void setA1(String a1) {
		this.a1 = a1;
	}
	public Integer getA2() {
		return a2;
	}
	public void setA2(Integer a2) {
		this.a2 = a2;
	}
	public Date getA3() {
		return a3;
	}
	public void setA3(Date a3) {
		this.a3 = a3;
	}
	
}

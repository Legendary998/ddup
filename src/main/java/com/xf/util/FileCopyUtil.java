package com.xf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileCopyUtil {

	@SuppressWarnings("unused")
	public static String copyFile(String oldFilepath,String newFilepath){
		try { 
	           int bytesum = 0; 
	           int byteread = 0; 
	           File oldfile = new File(oldFilepath); 
	           if (oldfile.exists()) {                  //文件存在时 
	               InputStream inStream = new FileInputStream(oldFilepath);      //读入原文件 
	               FileOutputStream fs = new FileOutputStream(newFilepath); 
	               byte[] buffer = new byte[1444]; 
	               int length; 
	               while ( (byteread = inStream.read(buffer)) != -1) { 
	                   bytesum += byteread;            //字节数 文件大小 
	                  // System.out.println(bytesum); 
	                   fs.write(buffer, 0, byteread); 
	               } 
	               fs.flush();
	               fs.close();
	               inStream.close(); 
	           } 
	       }  catch (Exception e) { 
	           System.out.println("复制单个文件操作出错"); 
	           e.printStackTrace(); 
	       } 
		return newFilepath;
	}
}

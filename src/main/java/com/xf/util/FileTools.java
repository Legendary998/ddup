package com.xf.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileTools {

	/**
	 * 上传文件
	 * 
	 * @param source
	 *            源文件
	 * @param destination
	 *            目标文件
	 * @throws IOException
	 */
	public static void uploadFile(File source, File destination)
			throws Exception {
		InputStream in = null;
		OutputStream out = null;
		try {
			in = new BufferedInputStream(new FileInputStream(source), 1024);
			out = new BufferedOutputStream(new FileOutputStream(destination),
					1024);
			byte[] buffer = new byte[1024];
			while (in.read(buffer) > 0) {
				out.write(buffer);
			}
		} catch (Exception ex) {
			throw ex;
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
			if (in != null) {
				in.close();
			}
		}
	}

	/**
	 * 获取文件编码格式
	 * @author wuzhangshan
	 * @date 2017-6-20
	 * @param inputStream
	 * @return
	 * @throws IOException
	 */
	public static String getCharset(InputStream inputStream) throws IOException {

		BufferedInputStream bin = new BufferedInputStream(inputStream);
		int p = (bin.read() << 8) + bin.read();

		String code = null;

		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}
		return code;
	}

	public static String getCharset(FileInputStream inputStream) throws IOException {
		BufferedInputStream bin = new BufferedInputStream(inputStream);
		int p = (bin.read() << 8) + bin.read();

		String code = null;

		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}
		return code;
	}
}

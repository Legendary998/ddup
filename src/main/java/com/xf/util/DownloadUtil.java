package com.xf.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

public class DownloadUtil {

	/**
	 * 下载文件 *
	 * 
	 * @param response
	 */
	public static void downLoad(HttpServletResponse response, String filePath,
			String fileName) throws Exception{
		response.setContentType("application/csv;charset=GBK");
        response.setHeader("Content-Disposition",
            "attachment;  filename=" + new String(fileName.getBytes("GBK"), "ISO8859-1"));
        //URLEncoder.encode(fileName, "GBK")
 
        InputStream in = null;
        try {
            in = new FileInputStream(filePath);
            int len = 0;
            byte[] buffer = new byte[1024];
            response.setCharacterEncoding("GBK");
            OutputStream out = response.getOutputStream();
            while ((len = in.read(buffer)) > 0) {
                //out.write(new byte[] { (byte) 0xEF, (byte) 0xBB, (byte) 0xBF });
                out.write(buffer, 0, len);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

		
	}
}

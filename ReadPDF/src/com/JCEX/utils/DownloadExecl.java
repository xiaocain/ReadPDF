package com.JCEX.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class DownloadExecl {
	/**
	 * 下载文件
	 * @param id appid
	 * @param response
	 */
	@RequestMapping(value="/downDJ")
	public void download(@RequestParam(value="DJpath")String path,HttpServletResponse response){
		String filepath = path;
		System.out.println(filepath);
		File file = new File(filepath+"total//华东区 应收核价超过48H情况说明表.xlsx");
		InputStream inputStream = null;
		OutputStream outputStream = null;
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String format = simpleDateFormat.format(date);
		byte[] b= new byte[1024];
		int len = 0;
		try {
			inputStream = new FileInputStream(file);
			outputStream = response.getOutputStream();
			
			response.setContentType("application/force-download");
			String filename = format+"华东区应收核价超过48H情况说明表";
			//new String(filename.getBytes("gbk"), "iso8859-1")+".xls"
			//URLEncoder.encode(filename, "UTF-8")
			response.setCharacterEncoding("utf-8");  
			response.addHeader("Content-Disposition","attachment; filename=" + new String(filename.getBytes("gbk"), "iso8859-1")+".xlsx");
			response.setContentLength( (int) file.length( ) );
			
			while((len = inputStream.read(b)) != -1){
				outputStream.write(b, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			if(inputStream != null){
				try {
					inputStream.close();
					inputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(outputStream != null){
				try {
					outputStream.close();
					outputStream = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}

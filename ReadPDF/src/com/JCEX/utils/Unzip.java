package com.JCEX.utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;

//ant 1.7

public class Unzip {
	 public static void main(String[] args) throws IOException {
	 }
	 
	 public static void  downLoadFromUrl(String urlStr,String fileName) throws IOException{
	        URL url = new URL(urlStr);  
	        HttpURLConnection conn = (HttpURLConnection)url.openConnection();  
	        //设置超时间为3秒
	        conn.setConnectTimeout(5*1000);
	        //防止屏蔽程序抓取而返回403错误
	        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            
	        //得到输入流
	        InputStream inputStream = conn.getInputStream();  
	        //获取自己数组
	        byte[] getData = readInputStream(inputStream);    

	        //文件保存位置
	        File saveDir = new File("D://mabangtest//EMS");
	        if(!saveDir.exists()){
	            saveDir.mkdir();
	        }
	        File file = new File(saveDir+"/"+fileName);    
	        FileOutputStream fos = new FileOutputStream(file);     
	        fos.write(getData); 
	        if(fos!=null){
	            fos.close();  
	        }
	        if(inputStream!=null){
	            inputStream.close();
	        }
	    }
	 
	 
	 public static  byte[] readInputStream(InputStream inputStream) throws IOException {  
	        byte[] buffer = new byte[1024];  
	        int len = 0;  
	        ByteArrayOutputStream bos = new ByteArrayOutputStream();  
	        while((len = inputStream.read(buffer)) != -1) {  
	            bos.write(buffer, 0, len);  
	        }  
	        bos.close();  
	        return bos.toByteArray();  
	    }  
	 
	 public static void downloadByApacheCommonIO(String url, String fileName) throws MalformedURLException, IOException, InterruptedException {
	        try {
	        	FileUtils.copyURLToFile(new URL(url), new File("D://mabangtest//EMS", fileName));
	        } catch (FileNotFoundException e) {
	        	Thread.sleep(1000);
	            try {
					FileUtils.copyURLToFile(new URL(url), new File("D://mabangtest//EMS", fileName));
	            }catch(FileNotFoundException e3){
	            	Thread.sleep(1000);
	            	FileUtils.copyURLToFile(new URL(url), new File("D://mabangtest//EMS", fileName));
	            }catch (MalformedURLException e1) {
					e1.printStackTrace();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	        }
	    }
	 
	 public void unzip(String fileAddress,String pdfname) throws IOException{
	        //解压zip的包
	        //zip文件路径（路径格式如：C:\\Users\\45335\\Desktop\\testZip.zip）
//	        String fileAddress = "C://89563262080c4e0db49e53824d9d9e14.zip";
	        //zip文件解压路径
	        String unZipAddress = "D:\\mabangtest\\EMS\\";
	        //去目录下寻找文件
	        pdfname=pdfname+".pdf";
	        File file = new File(fileAddress);
	        ZipFile zipFile = null;
	        try {
	            zipFile = new ZipFile(file,"UTF-8");//设置编码格式
	        } catch (IOException exception) {
	            exception.printStackTrace();
	        }

	        Enumeration e = zipFile.getEntries();
	        while(e.hasMoreElements()) {
	            ZipEntry zipEntry = (ZipEntry)e.nextElement();
	            if(zipEntry.isDirectory()) {
	                String name = zipEntry.getName();
	                name = name.substring(0,name.length()-1);
	                File f = new File(unZipAddress + name);
	                f.mkdirs();
	            } else {
	                File f = new File(unZipAddress + pdfname);
	                f.getParentFile().mkdirs();
	                f.createNewFile();
	                InputStream is = zipFile.getInputStream(zipEntry);
	                FileOutputStream fos = new FileOutputStream(f);
	                int length = 0;
	                byte[] b = new byte[1024];
	                
	                while((length=is.read(b, 0, 1024))!=-1) {
	                    fos.write(b, 0, length);
	                }
	                is.close();
	                fos.close();
	            }
	        }
	        if (zipFile != null) {
	            zipFile.close();
	        }
	        if(file.exists()){
	        	file.delete();//解压完以后将压缩包删除
	        }
	        
	    }
}

package com.JCEX.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import org.apache.commons.codec.binary.Base64;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class PDFtoBase64 {
	
	static BASE64Encoder encoder = new sun.misc.BASE64Encoder();      
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();      
     
    
    public String encryptedPDF(String billno)
			throws UnsupportedEncodingException {
		String imgFile = billno + ".pdf";// 待处理的图片
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(imgFile);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 对字节数组Base64编码
		Base64 base64 = new Base64();
		byte[] base64Bs = base64.encode(data);
		String encodeParam = new String(base64Bs, "UTF-8");
		return encodeParam;
	}
    
    
	static void base64StringToPDF(String base64sString){  
        BufferedInputStream bin = null;  
        FileOutputStream fout = null;  
        BufferedOutputStream bout = null;  
        try {  
             //将base64编码的字符串解码成字节数组  
            byte[] bytes = decoder.decodeBuffer(base64sString);  
            //apache公司的API  
            //byte[] bytes = Base64.decodeBase64(base64sString);  
            //创建一个将bytes作为其缓冲区的ByteArrayInputStream对象  
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
            //创建从底层输入流中读取数据的缓冲输入流对象  
            bin = new BufferedInputStream(bais);  
            //指定输出的文件  
            File file = new File("c:\\pdf\\2.pdf");  
            //创建到指定文件的输出流  
            fout  = new FileOutputStream(file);  
            //为文件输出流对接缓冲输出流对象  
            bout = new BufferedOutputStream(fout);  
              
            byte[] buffers = new byte[1024];  
            int len = bin.read(buffers);  
            while(len != -1){  
                bout.write(buffers, 0, len);  
                len = bin.read(buffers);  
            }  
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题  
            bout.flush();  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                bin.close();  
                fout.close();  
                bout.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
	public static String base64StringToPDF(String base64sString ,String billno){  
        BufferedInputStream bin = null;  
        FileOutputStream fout = null;  
        BufferedOutputStream bout = null;  
        try {  
             //将base64编码的字符串解码成字节数组  
            byte[] bytes = decoder.decodeBuffer(base64sString);  
            //apache公司的API  
            //byte[] bytes = Base64.decodeBase64(base64sString);  
            //创建一个将bytes作为其缓冲区的ByteArrayInputStream对象  
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);  
            //创建从底层输入流中读取数据的缓冲输入流对象  
            bin = new BufferedInputStream(bais);  
            //指定输出的文件  
            File file = new File("C:\\mabangtest\\mabangreturn\\"+billno+".pdf");  
            //创建到指定文件的输出流  
            fout  = new FileOutputStream(file);  
            //为文件输出流对接缓冲输出流对象  
            bout = new BufferedOutputStream(fout);  
              
            byte[] buffers = new byte[1024];  
            int len = bin.read(buffers);  
            while(len != -1){  
                bout.write(buffers, 0, len);  
                len = bin.read(buffers);  
            }  
            //刷新此输出流并强制写出所有缓冲的输出字节，必须这行代码，否则有可能有问题  
            bout.flush();  
              
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{  
            try {  
                bin.close();  
                fout.close();  
                bout.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }
		return "http://api.jcex.com:8081/mabangreturn/"+billno+".pdf";
    }  
}

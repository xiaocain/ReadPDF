package com.JCEX.utils;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MuEMS implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	private final ThreadLocal<String> threadLocal = new ThreadLocal<String>();
	
	private int x;
	private XSSFWorkbook wb;
	private HttpUtils httpUtils;
	private String OriginalFilename;
	private String waybillnumber;
	private static String writeone="fasd";
	
//	int x,XSSFWorkbook wb,
	public MuEMS(HttpUtils httpUtils,String OriginalFilename,String waybillnumber){
//		this.x=x;
//		this.wb=wb;
		this.httpUtils=httpUtils;
		this.OriginalFilename=OriginalFilename;
		this.waybillnumber=waybillnumber;
	}
	
//	@Override
//	public void run() {
//		System.out.println("线程名字"+Thread.currentThread().getName());
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e2) {
//			e2.printStackTrace();
//		}
//		
//	}
	
	@Override
	public void run() {
		
		System.out.println("线程名字"+Thread.currentThread().getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}
//                System.out.println(singleRow[2]+"...."+singleRow[2].length());
//                if(StringUtils.isEmpty(singleRow[0])&&StringUtils.isEmpty(singleRow[1])&&StringUtils.isEmpty(singleRow[2])){
//              	  continue;
//                }else if(StringUtils.isEmpty(singleRow[2])){
//              	  new WriteExcel().writeExcel3(OriginalFilename, singleRow[0], "缺少上传状态数据");
//              	  continue;
//                }
                
                
//                System.out.println(CanadaList);
                
//                errtrackingNumber.add("ss......err");
//                errtrackingNumber.add("aa......err2");
                String httpGet = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+waybillnumber);
                logger.info("上傳數據："+"http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+waybillnumber);
// 				String CanadaListRsponse = httpUtils.httpPost(url, CanadaList);
 				logger.info("服務商返回數據："+httpGet);
 				if(StringUtils.isBlank(httpGet)||httpGet.toString().contains("null")){
 					try {
						Thread.sleep(1000);
					} catch (InterruptedException e1) {
						logger.info(e1.toString());
						e1.printStackTrace();
					}
 					String fs = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+waybillnumber);
 					logger.info("再次确认EMS服務商返回數據："+fs);
 					if(StringUtils.isBlank(fs)||fs.toString().contains("null")){
 						try {
 							Thread.sleep(1000);
 						} catch (InterruptedException e1) {
 							logger.info(e1.toString());
 							e1.printStackTrace();
 						}
 						String as = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+waybillnumber);
 						logger.info("第三次确认EMS服務商返回數據："+as);
 						if(StringUtils.isBlank(as)||as.toString().contains("null")){
	 						try {
	 							synchronized (writeone) {
	 								new WriteExcel().writeEMSExcel(OriginalFilename, waybillnumber);
								}
							} catch (IOException e) {
	                            logger.info(e.toString());
								e.printStackTrace();
							}
 						}
 					}
 				}
	}
 
}

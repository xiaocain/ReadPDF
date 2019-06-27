package com.JCEX.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;


import com.JCEX.pojo.WishWaybillnumer;
import com.JCEX.service.WishTrackService;
import com.JCEX.serviceImpl.WishTrackImpl;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


public class ReadExcl{
	
	
	
     public static void main(String[] args) {
    	 File file = new File("D://Execl/");
    		// 把获取到的文件名保存在数组中
    		   File[] files = file.listFiles();
    		   for(File f:files){
    			
    		    //--------------------------1.获取文件路径
    		    String absolutePath = f.getAbsolutePath();
    		    System.out.println("文件路径:"+f.getAbsolutePath());
    		    //获取文件类型，即文件后缀名
    		    int start = f.getAbsolutePath().length()-3;
    		    int end  = f.getAbsolutePath().length();
    		    //得到文件的后缀名
    		    String pdf = f.getAbsolutePath().substring(start, end);
    		    readExecl(absolutePath);
    		   }
     }
      
 	public List<String> ReadFromExcel(String fileName) {
 		
 		
 		File file =  new File(fileName);
 		System.out.println(fileName);
 		int lastIndexOf = fileName.lastIndexOf("\\");
 		String substring = fileName.substring(0, lastIndexOf);
 		
 		WriteExcel writeExcel = new WriteExcel();
 		List<String> errtrackingNumber=new ArrayList<String>();
 		try {
 			InputStream in = new FileInputStream(file); 
 			InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
 			inputStreamReader.read();
 
 			Workbook wb = Workbook.getWorkbook(in);   //获得excel文件对象
 			Sheet s = wb.getSheet(0);			//获取文件的指定工作表
 			//	System.out.println(s.getColumns());
 		    //	System.out.println(s.getRows());
 			
 			String url="https://api. tripleeaglelogistics.com/api/awb/submit";
 			
 			HttpUtils httpUtils = new HttpUtils();
 			for(int i=1;i<s.getRows();i++)   //第一行不要
 			{
 				Cell[] row = s.getRow(i);
 				String CanadaList="{" +
 		                "  \"accountId\" : \""+row[0].getContents()+"\"," +
 		                "  \"masterAirwayBill\" : \""+row[1].getContents()+"\"," +
 		                "  \"flightDate\" : \""+row[2].getContents()+"\"," +
 		                "  \"airportCode\" : \""+row[3].getContents()+"\"," +
 		                "  \"trackingNumber\" : \""+row[4].getContents()+"\"," +
 		                "  \"invoiceDate\" : \""+row[5].getContents()+"\"," +
 		                "  \"invoiceNumber\" : \""+row[6].getContents()+"\"," +
 		                "  \"shipperName1\" : \""+row[7].getContents()+"\"," +
 		                "  \"shipperName2\" : \""+row[8].getContents()+"\"," +
 		                "  \"shipperAddress1\" : \""+row[9].getContents()+"\"," +
 		                "  \"shipperAddress2\" : \""+row[10].getContents()+"\"," +
 		                "  \"shipperCity\" : \""+row[11].getContents()+"\"," +
 		                "  \"shipperProvince\" : \""+row[12].getContents()+"\"," +
 		                "  \"shipperPostalCode\" : \""+row[13].getContents()+"\"," +
 		                "  \"shipperCountryCode\" : \""+row[14].getContents()+"\"," +
 		                "  \"consigneeName1\" : \""+row[15].getContents()+"\"," +
 		                "  \"consigneeName2\" : \""+row[16].getContents()+"\"," +
 		                "  \"consigneeAddress1\" : \""+row[17].getContents()+"\"," +
 		                "  \"consigneeAddress2\" : \""+row[18].getContents()+"\"," +
 		                "  \"consigneeCity\" : \""+row[19].getContents()+"\"," +
 		                "  \"consigneeProvinceCode\" : \""+row[20].getContents()+"\"," +
 		                "  \"consigneePostalCode\" : \""+row[21].getContents()+"\"," +
 		                "  \"consigneeCountryCode\" : \""+row[22].getContents()+"\"," +
 		                "  \"currency\" : \""+row[23].getContents()+"\"," +
 		                "  \"incoterms\" : \""+row[24].getContents()+"\"," +
 		                "  \"packages\": [ {     " +
 		                "    \"packageType\" : \""+row[25].getContents()+"\"," +
 		                "    \"weightPerPackage\" : "+row[26].getContents()+"," +
 		                "    \"weightUOM\" : \""+row[27].getContents()+"\"," +
 		                "    \"valuePerPackage\": "+row[28].getContents()+",   " +
 		                "    \"numberOfPackages\":  "+row[29].getContents()+"," +
 		                "\"items\": [ {" +
 		                "\"hsCode\": \""+row[30].getContents()+"\"," +
 		                "\"description\": \""+row[31].getContents()+"\"," +
 		                "\"chineseDescription\": \""+row[32].getContents()+"\"," +
 		                "\"valuePerPiece\": "+row[33].getContents()+"," +
 		                "\"weightPerPiece\": "+row[34].getContents()+"," +
 		                "\"weightUOM\": \""+row[35].getContents()+"\"," +
 		                "\"numberOfPieces\": "+row[36].getContents()+"," +
 		                "\"originCountryCode\": \""+row[37].getContents()+"\"" +
 		                "} ]" +
 		                "    }]" +
 		                "}";
 				String CanadaListRsponse = httpUtils.httpPost(url, CanadaList);
 				String status = JSONObject.fromObject(CanadaListRsponse).getString("status");
 				errtrackingNumber.add(row[4].getContents());
// 				System.out.println(row[27].getContents().substring(9, 13));
// 				System.out.println(StringUtils.isBlank(row[28].getContents()));
 				//&&!row[25].getContents().substring(9, 12).equals("6900")
// 				if(row[27].getContents().contains("6900")&&StringUtils.isNotEmpty(row[27].getContents())&&StringUtils.isNotEmpty(row[28].getContents())){
// 					String Province=URLEncoder.encode(row[14].getContents(), "UTF-8");
//// 					String Province=URLEncoder.encode(sd, "UTF-8");
// 					writeExcel.writeB2CExcel(substring,row[0].getContents(), row[1].getContents(), row[2].getContents(), row[3].getContents(), row[4].getContents(),row[5].getContents(),row[6].getContents(),row[7].getContents(),row[8].getContents(),row[9].getContents(),row[10].getContents(),row[11].getContents(),row[12].getContents(),row[13].getContents(),Province,row[15].getContents(),row[16].getContents(),row[17].getContents(),row[18].getContents(),row[19].getContents(),row[20].getContents(),row[21].getContents(),row[22].getContents(),row[23].getContents(),row[24].getContents(),row[25].getContents(),row[26].getContents(),row[27].getContents(),row[28].getContents(),row[29].getContents(),row[30].getContents(),row[31].getContents(),row[32].getContents());
// 				}else{
// 					continue;
// 				}					
 			}
 		} catch (FileNotFoundException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (BiffException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}
 		return errtrackingNumber;
 	}
     
     
     
       public static void readExecl(String pdf){
			int i;
			Sheet sheet;
			Workbook book;
			Cell cell1, cell2, cell3, cell4, cell5, cell6, cell7;
			try {
				File file = new File(pdf);
				System.out.println(file);
				InputStream iss = new FileInputStream(file);
				book = Workbook.getWorkbook(iss);
	
				sheet = book.getSheet(0);
				cell1 = sheet.getCell(0, 0);
				System.out.println("标题：" + cell1.getContents());
				i = 0;
				while (true) {
					cell1 = sheet.getCell(0, i);// （列，行）
					cell2 = sheet.getCell(1, i);
					// cell3=sheet.getCell(12,i);
					cell2.getContents();
					if ("".equals(cell1.getContents()) == true)
						break;
					try {
						String address = cell1.getContents();
						String postcode = cell2.getContents();
						// String contents = cell3.getContents();
						// new HouseTest().sda(address,postcode);
						 System.out.println(cell1.getContents()+"\t"+cell2.getContents()+"\t");
						i++;
					} catch (ArrayIndexOutOfBoundsException ex) {
						throw new RuntimeException();
					}
				}
				book.close();
			} catch (BiffException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

    
       
//	public void readWishExecl(String absolutePath, String id) throws IOException, BiffException {
//		File excelFile = new File(absolutePath);
//        int lastIndexOf = absolutePath.lastIndexOf("\\");
//        String OriginalFilename=absolutePath.substring(0, lastIndexOf+1);
////        InputStream in = new FileInputStream(excelFile); 
////		InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
////		inputStreamReader.read();
//
//		Workbook wb = Workbook.getWorkbook(new FileInputStream(excelFile));   //获得excel文件对象
//		Sheet s = wb.getSheet(0);
//		WriteExcel writeExcel = new WriteExcel();
//		WishTrackImpl wishTrackImpl = new WishTrackImpl();
//		for(int i=1;i<s.getRows();i++){
//			Cell[] row = s.getRow(i);
//			String waybillnumber = row[0].getContents();
//			WishWaybillnumer wishtrack = wishTrackService.Wishtrack(waybillnumber);
//			String country = wishtrack.getCountry();
//			if(wishtrack.getMessage().equals("系统签收推送无问题")){
//				continue;
//			}
//			if(country.equals("DE")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, waybillnumber, "", "", "", "", "", "", "", "", "", "", "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", waybillnumber, "", "", "", "", "", "", "", "", "", "", "", "");
//				}
//			}else if(country.equals("ES")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", waybillnumber, "", "", "", "", "", "", "", "", "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", waybillnumber, "", "", "", "", "", "", "", "", "", "");
//				}
//			}else if(country.equals("NL")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", waybillnumber, "", "", "", "", "", "", "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", waybillnumber, "", "", "", "", "", "", "", "");
//				}
//			}else if(country.equals("IT")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", waybillnumber, "", "", "", "", "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", waybillnumber, "", "", "", "", "", "");
//				}
//			}else if(country.equals("GB")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", waybillnumber, "", "", "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "","", waybillnumber, "", "", "", "");
//				}
//			}else if(country.equals("BE")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", waybillnumber, "", "", "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", waybillnumber, "", "");
//				}
//			}else if(country.equals("FR")){
//				if(wishtrack.getMessage().equals("系统无签收")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", "", waybillnumber, "");
//				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
//					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", "", "", waybillnumber);
//				}
//			}
//		}
//	}
}

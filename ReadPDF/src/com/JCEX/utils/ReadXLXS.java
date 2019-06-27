package com.JCEX.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


import net.sf.json.JSONObject;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReadXLXS {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
//	public static void main(String[] args) throws Exception {
//		new ReadXLXS().readXlxs("ds","2");
//	}
	public void readXlxs(String filepath,String id) throws Exception {
//        File excelFile = new File("D://Execl/华东管理部--应收核价超过48H情况说明表9.4.xlsx");//文档地址
//        File excelFile = new File("D://Execl/绍兴  应收核价超过48H情况说明表 9.4 .xlsx");
        File excelFile = new File(filepath);
        int lastIndexOf = filepath.lastIndexOf("\\");
        String OriginalFilename=filepath.substring(0, lastIndexOf+1);
        XSSFWorkbook wb = null;
//        String url="https://api. tripleeaglelogistics.com/api/awb/submit";
        String url="https://api.tripleeaglelogistics.com/api/awb/submit";
		HttpUtils httpUtils = new HttpUtils();
		List<String> errtrackingNumber=new ArrayList<String>();
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = wb.getNumberOfSheets();
        String str = "";
        
        for (int x = 0; x < numberOfSheets; x++) {
            XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
            }
            if (columnNum > 0) {
            	int s=0;
                for (Row row : sheet) {
                	s++;
                	System.out.println(s);
                	if(s==1){
                		continue;
                	}
                    String[] singleRow = new String[columnNum];
                    int n = 0;
                    for (int i = 0; i < columnNum; i++) {
                        Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                singleRow[n] = "";
                                if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                                    System.out.print("<Null>|");
                                } else {
                                    System.out.print(singleRow[n] + "|");
                                }
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                singleRow[n] = Boolean.toString(cell
                                        .getBooleanCellValue());
//                                System.out.print(singleRow[n] + "|");
                                break;
                            // 数值
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = null;
                                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                            .getBuiltinFormat("h:mm")) {
                                        sdf = new SimpleDateFormat("HH:mm");
                                    } else {// 日期
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    }
                                    Date date = cell.getDateCellValue();
//                                    System.out.print(sdf.format(date) + "|");
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        singleRow[n] = String.valueOf(new Double(temp))
                                                .trim();
//                                        System.out.print(singleRow[n] + "|");
                                    } else {
                                        singleRow[n] = temp.trim();
//                                        System.out.print(singleRow[n] + "|");
                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                singleRow[n] = cell.getStringCellValue().trim();
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                singleRow[n] = "";
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                if (temp.indexOf(".") > -1) {
                                    temp = String.valueOf(new Double(temp))
                                            .trim();
                                    Double cny = Double.parseDouble(temp);//6.2041
                                    DecimalFormat df = new DecimalFormat("0.00");
                                    String CNY = df.format(cny);
//                                    System.out.print(CNY + "|");
                                } else {
                                    singleRow[n] = temp.trim();
//                                    System.out.print(singleRow[n] + "|");

                                }
                            default:
                                singleRow[n] = "";
                                break;
                        }
                        n++;
                    }
                    StringBuffer itemlist=new StringBuffer();
                    String referenceNumber = singleRow[25];
                    String hscode = singleRow[31];
                    String description=singleRow[32];
                    String chineseDescription=singleRow[33];
                    String valuePerPiece=singleRow[34];
                    String weightPerPiece=singleRow[35];
                    String weightUOM=singleRow[36];
                    String numberOfPieces=singleRow[37];
                    String originCountryCode=singleRow[38];
                    String[] hscodesplit = hscode.split(",");
                    String[] descriptionsplit = description.split(",");
                    String[] chineseDescriptionsplit = chineseDescription.split(",");
//                    String[] valuePerPiecesplit = valuePerPiece.split(",");
//                    String[] weightPerPiecesplit = weightPerPiece.split(",");
//                    String[] weightUOMsplit = weightUOM.split(",");
//                    String[] numberOfPiecessplit = numberOfPieces.split(",");
//                    String[] originCountryCodesplit = originCountryCode.split(",");
                    for(int j=0;j<hscodesplit.length;j++){
                    	String hscodes = hscodesplit[j].trim();
                    	itemlist.append("{" +
     		                "\"hsCode\": \""+hscodes+"\"," +
     		                "\"description\": \""+descriptionsplit[j]+"\"," +
     		                "\"chineseDescription\": \""+chineseDescriptionsplit[j]+"\"," +
     		                "\"valuePerPiece\": \""+valuePerPiece+"\"," +
     		                "\"weightPerPiece\": "+weightPerPiece+"," +
     		                "\"weightUOM\": \""+weightUOM+"\"," +
     		                "\"numberOfPieces\": "+numberOfPieces+"," +
     		                "\"originCountryCode\": \""+originCountryCode+"\"" +
     		                "}");
                    	if(j!=hscodesplit.length-1){
                    		itemlist.append(",");
                    	}
                    }
                    
                    
                    
                    String CanadaList="{" +
     		                "  \"accountId\" : \""+singleRow[0]+"\"," +
     		                "  \"masterAirwayBill\" : \""+singleRow[1]+"\"," +
     		                "  \"flightDate\" : \""+singleRow[2]+"\"," +
     		                "  \"airportCode\" : \""+singleRow[3]+"\"," +
     		                "  \"trackingNumber\" : \""+singleRow[4]+"\"," +
     		                "  \"invoiceDate\" : \""+singleRow[6]+"\"," +
     		                "  \"invoiceNumber\" : \""+singleRow[5]+"\"," +
     		                "  \"shipperName1\" : \""+singleRow[7]+"\"," +
     		                "  \"shipperName2\" : \""+singleRow[8]+"\"," +
     		                "  \"shipperAddress1\" : \""+singleRow[9]+"\"," +
     		                "  \"shipperAddress2\" : \""+singleRow[10]+"\"," +
     		                "  \"shipperCity\" : \""+singleRow[11]+"\"," +
     		                "  \"shipperProvince\" : \""+singleRow[12]+"\"," +
     		                "  \"shipperPostalCode\" : \""+singleRow[13]+"\"," +
     		                "  \"shipperCountryCode\" : \""+singleRow[14]+"\"," +
     		                "  \"consigneeName1\" : \""+singleRow[15]+"\"," +
     		                "  \"consigneeName2\" : \""+singleRow[16]+"\"," +
     		                "  \"consigneeAddress1\" : \""+singleRow[17]+"\"," +
     		                "  \"consigneeAddress2\" : \""+singleRow[18]+"\"," +
     		                "  \"consigneeCity\" : \""+singleRow[19]+"\"," +
     		                "  \"consigneeProvinceCode\" : \""+singleRow[20]+"\"," +
     		                "  \"consigneePostalCode\" : \""+singleRow[21]+"\"," +
     		                "  \"consigneeCountryCode\" : \""+singleRow[22]+"\"," +
     		                "  \"currency\" : \""+singleRow[23]+"\"," +
     		                "  \"incoterms\" : \""+singleRow[24]+"\"," +
     		                "  \"packages\": [ {     " +
     		                "    \"packageType\" : \""+singleRow[29]+"\"," +
     		                "    \"weightPerPackage\" : "+singleRow[26]+"," +
     		                "    \"weightUOM\" : \""+singleRow[27]+"\"," +
     		                "    \"valuePerPackage\": "+singleRow[28]+",   " +
     		                "    \"numberOfPackages\":  "+singleRow[30]+"," +
     		                "\"items\":[" +
     		                itemlist+
     		                "]" +
     		                "    }]" +
     		                "}";
                    System.out.println(CanadaList);
//                    errtrackingNumber.add("ss......err");
//                    errtrackingNumber.add("aa......err2");
                    if(singleRow[0].equals("")||StringUtils.isEmpty(singleRow[0])){
                    	continue;
                    }
                    logger.info("上傳數據："+CanadaList);
     				String CanadaListRsponse = httpUtils.httpPost(url, CanadaList);
     				logger.info("服務商返回數據："+CanadaListRsponse);
     				JSONObject CanadaListRsponseJson = JSONObject.fromObject(CanadaListRsponse);
     				String status = CanadaListRsponseJson.getString("status");
     				String message=null;
     				if(CanadaListRsponseJson.has("message")){
     					message= CanadaListRsponseJson.getString("message");
     				}else{
     					message=CanadaListRsponseJson.getString("messages");
     				}
//     				referenceNumber="sda";
//     				message="sdaff";
     				if(status.toUpperCase().equals("SUCCESS")){	
     					new WriteExcel().writeExcel3(OriginalFilename, referenceNumber, "SUCCESS");
//     					errtrackingNumber.add(referenceNumber+"......"+message);
     				}else{
     					new WriteExcel().writeExcel3(OriginalFilename, referenceNumber, message);
     				}
                }
                System.out.println("===========================================================Sheet分割线===========================================================");
            }
        }
    }
	
	public void readB2CXlxs(String filepath) throws Exception {
//      File excelFile = new File("D://Execl/华东管理部--应收核价超过48H情况说明表9.4.xlsx");//文档地址
//      File excelFile = new File("D://Execl/绍兴  应收核价超过48H情况说明表 9.4 .xlsx");
      File excelFile = new File(filepath);
      XSSFWorkbook wb = null;
      try {
          wb = new XSSFWorkbook(new FileInputStream(excelFile));
      } catch (IOException e) {
          e.printStackTrace();
      }
      int numberOfSheets = wb.getNumberOfSheets();
      String str = "";
      
      for (int x = 0; x < numberOfSheets; x++) {
          XSSFSheet sheet = wb.getSheetAt(x);
          	int s=0;
              for (Row row : sheet) {
                  String[] singleRow = new String[33];
                  int n = 0;
                  for (int i = 0; i < 33; i++) {
                      Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                      switch (cell.getCellType()) {
                          case Cell.CELL_TYPE_BLANK:
                              singleRow[n] = "";
                              if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//                                  System.out.print("<Null>|");
                              } else {
//                                  System.out.print(singleRow[n] + "|");
                              }
                              break;
                          case Cell.CELL_TYPE_BOOLEAN:
                              singleRow[n] = Boolean.toString(cell
                                      .getBooleanCellValue());
//                              System.out.print(singleRow[n] + "|");
                              break;
                          // 数值
                          case Cell.CELL_TYPE_NUMERIC:
                              if (DateUtil.isCellDateFormatted(cell)) {
                                  SimpleDateFormat sdf = null;
                                  if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                          .getBuiltinFormat("h:mm")) {
                                      sdf = new SimpleDateFormat("HH:mm");
                                  } else {// 日期
                                      sdf = new SimpleDateFormat("yyyy-MM-dd");
                                  }
                                  Date date = cell.getDateCellValue();
//                                  System.out.print(sdf.format(date) + "|");
                              } else {
                                  cell.setCellType(Cell.CELL_TYPE_STRING);
                                  String temp = cell.getStringCellValue();
                                  // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                  if (temp.indexOf(".") > -1) {
                                      singleRow[n] = String.valueOf(new Double(temp))
                                              .trim();
//                                      System.out.print(singleRow[n] + "|");
                                  } else {
                                      singleRow[n] = temp.trim();
//                                      System.out.print(singleRow[n] + "|");
                                  }
                              }
                              break;
                          case Cell.CELL_TYPE_STRING:
                              singleRow[n] = cell.getStringCellValue().trim();
//                              System.out.print(singleRow[n] + "|");
                              break;
                          case Cell.CELL_TYPE_ERROR:
                              singleRow[n] = "";
//                              System.out.print(singleRow[n] + "|");
                              break;
                          case Cell.CELL_TYPE_FORMULA:
                              cell.setCellType(Cell.CELL_TYPE_STRING);
                              String temp = cell.getStringCellValue();
                              // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                              if (temp.indexOf(".") > -1) {
                                  temp = String.valueOf(new Double(temp))
                                          .trim();
                                  Double cny = Double.parseDouble(temp);//6.2041
                                  DecimalFormat df = new DecimalFormat("0.00");
                                  String CNY = df.format(cny);
//                                  System.out.print(CNY + "|");
                              } else {
                                  singleRow[n] = temp.trim();
//                                  System.out.print(singleRow[n] + "|");

                              }
                          default:
                              singleRow[n] = "";
                              break;
                      }
                      n++;
                  }
                   if(StringUtils.isNotBlank(singleRow[24])&&singleRow[24].contains("6900")){
//                  	 Branchoffice, waybillnumber, reason, people, booleanMon, Money
                  	 
                	   int lastIndexOf = filepath.lastIndexOf("\\");
                		String substring = filepath.substring(0, lastIndexOf);
//                  	String waybillnumber = new String(singleRow[1].getBytes("gbk"),"iso8859-1");
//                  	String reason = new String(singleRow[2].getBytes("gbk"),"iso8859-1");
//                  	String people = new String(singleRow[3].getBytes("gbk"),"iso8859-1");
//                  	String booleanMon = new String(singleRow[4].getBytes("gbk"),"iso8859-1");
//                  	String Money = new String(singleRow[5].getBytes("gbk"),"iso8859-1");
                  	new ReadXLXS().B2Cwrite(substring,singleRow[0], singleRow[1], singleRow[2], singleRow[3], singleRow[4], singleRow[5],singleRow[6],singleRow[7], singleRow[8], singleRow[9], singleRow[10], singleRow[11],singleRow[12],singleRow[13], singleRow[14], singleRow[15], singleRow[16], singleRow[17],singleRow[18],singleRow[19], singleRow[20], singleRow[21], singleRow[22], singleRow[23],singleRow[24],singleRow[25], singleRow[26], singleRow[27], singleRow[28], singleRow[29],singleRow[30],singleRow[31], singleRow[32]);
//                  	new ReadXLXS().sda();
//                      HDwriteExcel(Branchoffice, waybillnumber, reason, people, booleanMon, Money);
                   }
              }
              System.out.println("===========================================================Sheet分割线===========================================================");
      }
  }
	
	
    public void write(String id,String Branchoffice,String waybillnumber,String reason,String people,String booleanMon,String Money) throws IOException {
    	Workbook workbook;
        File Divfile = new File("D://ReadExecl/"+id+"//total//");
        File file=new File("D://ReadExecl/"+id+"//total//华东区 应收核价超过48H情况说明表.xlsx");
        Sheet sheet;
        Row row;
        if(!file.exists()){
        	workbook = new XSSFWorkbook();
        	Divfile.mkdirs();
        	file.createNewFile();
        	sheet = workbook.createSheet("a");
        	row = sheet.createRow(0);
        	workbook.setSheetName(0, "a");
        	CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue("所属分公司");
            row.createCell(1).setCellStyle(cellStyle);
            row.createCell(1).setCellValue("超过48H未核价单号");
            row.createCell(2).setCellStyle(cellStyle);
            row.createCell(2).setCellValue("具体未核价原因");
            row.createCell(3).setCellStyle(cellStyle);
            row.createCell(3).setCellValue("结算专员");
            row.createCell(4).setCellStyle(cellStyle);
            row.createCell(4).setCellValue("是否罚款");
            row.createCell(5).setCellStyle(cellStyle);
            row.createCell(5).setCellValue("罚款金额");
            
        }else{
        	FileInputStream fileInputStream=new FileInputStream("D://ReadExecl/"+id+"//total//华东区 应收核价超过48H情况说明表.xlsx");
			workbook = new XSSFWorkbook(fileInputStream);
        	sheet = workbook.getSheetAt(0);
        	row = sheet.createRow(sheet.getLastRowNum()+1);
//        	row = sheet.createRow(sheet.getLastRowNum()+1);
        	System.out.println(Branchoffice+"..."+waybillnumber);
            CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue(Branchoffice);
     
            row.createCell(1).setCellStyle(cellStyle);
            row.createCell(1).setCellValue(waybillnumber);
            
            row.createCell(2).setCellStyle(cellStyle);
            row.createCell(2).setCellValue(reason);
            
            row.createCell(3).setCellStyle(cellStyle);
            row.createCell(3).setCellValue(people);
            
            row.createCell(4).setCellStyle(cellStyle);
            row.createCell(4).setCellValue(booleanMon);
            
            row.createCell(5).setCellStyle(cellStyle);
            row.createCell(5).setCellValue(Money);
        }
        try {
            FileOutputStream fileoutputStream = new FileOutputStream("D://ReadExecl/"+id+"//total//华东区 应收核价超过48H情况说明表.xlsx");
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void B2Cwrite(String substring, String singleRow, String singleRow2, String singleRow3, String singleRow4, String singleRow5, String singleRow6, String singleRow7, String singleRow8, String singleRow9, String singleRow10, String singleRow11, String singleRow12, String singleRow13, String singleRow14, String singleRow15, String singleRow16, String singleRow17, String singleRow18, String singleRow19, String singleRow20, String singleRow21, String singleRow22, String singleRow23, String singleRow24, String singleRow25, String singleRow26, String singleRow27, String singleRow28, String singleRow29, String singleRow30, String singleRow31, String singleRow32, String singleRow33) throws IOException {
    	Workbook workbook;
        File Divfile = new File(substring);
        File file=new File(substring+"/B2CExcl.xls");
        Sheet sheet;
        Row row;
        if(!file.exists()){
        	workbook = new XSSFWorkbook();
        	Divfile.mkdirs();
        	file.createNewFile();
        	sheet = workbook.createSheet("a");
        	row = sheet.createRow(0);
        	workbook.setSheetName(0, "a");
        	CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue("OrderNumber");
            row.createCell(1).setCellStyle(cellStyle);
            row.createCell(1).setCellValue("PackageBarcode");
            row.createCell(2).setCellStyle(cellStyle);
            row.createCell(2).setCellValue("PrealertReference");
            row.createCell(3).setCellStyle(cellStyle);
            row.createCell(3).setCellValue("ShippingMethod");
            row.createCell(4).setCellStyle(cellStyle);
            row.createCell(4).setCellValue("Weight");
            row.createCell(5).setCellStyle(cellStyle);
            row.createCell(5).setCellValue("CompanyName");
            row.createCell(6).setCellStyle(cellStyle);
            row.createCell(6).setCellValue("ConsigneeName");
            row.createCell(7).setCellStyle(cellStyle);
            row.createCell(7).setCellValue("PhoneNumber");
            row.createCell(8).setCellStyle(cellStyle);
            row.createCell(8).setCellValue("EmailAddress");
            row.createCell(9).setCellStyle(cellStyle);
            row.createCell(9).setCellValue("Street");
            row.createCell(10).setCellStyle(cellStyle);
            row.createCell(10).setCellValue("HouseNumber");
            row.createCell(11).setCellStyle(cellStyle);
            row.createCell(11).setCellValue("HouseNumberExtension");
            row.createCell(12).setCellStyle(cellStyle);
            row.createCell(12).setCellValue("AdditionalAddressInfo");
            row.createCell(13).setCellStyle(cellStyle);
            row.createCell(13).setCellValue("City");
            row.createCell(14).setCellStyle(cellStyle);
            row.createCell(14).setCellValue("Province");
            row.createCell(15).setCellStyle(cellStyle);
            row.createCell(15).setCellValue("PostalCode");
            row.createCell(16).setCellStyle(cellStyle);
            row.createCell(16).setCellValue("CountryCode");
            row.createCell(17).setCellStyle(cellStyle);
            row.createCell(17).setCellValue("SKUCode");
            row.createCell(18).setCellStyle(cellStyle);
            row.createCell(18).setCellValue("SKUDescription");
            row.createCell(19).setCellStyle(cellStyle);
            row.createCell(19).setCellValue("Quantity");
            row.createCell(20).setCellStyle(cellStyle);
            row.createCell(20).setCellValue("Currency");
            row.createCell(21).setCellStyle(cellStyle);
            row.createCell(21).setCellValue("UnitPrice");
            row.createCell(22).setCellStyle(cellStyle);
            row.createCell(22).setCellValue("ShippingCosts");
            row.createCell(23).setCellStyle(cellStyle);
            row.createCell(23).setCellValue("HSCode");
            row.createCell(24).setCellStyle(cellStyle);
            row.createCell(24).setCellValue("WebSiteURL");
            row.createCell(25).setCellStyle(cellStyle);
            row.createCell(25).setCellValue("TYPNumber");
            row.createCell(26).setCellStyle(cellStyle);
            row.createCell(26).setCellValue("BagReference");
            row.createCell(27).setCellStyle(cellStyle);
            row.createCell(27).setCellValue("TrackingNumber");
            row.createCell(28).setCellStyle(cellStyle);
            row.createCell(28).setCellValue("DEU_RoutingCode");
            row.createCell(29).setCellStyle(cellStyle);
            row.createCell(29).setCellValue("DEU_KGName");
            row.createCell(30).setCellStyle(cellStyle);
            row.createCell(30).setCellValue("DEU_Street46");
            row.createCell(31).setCellStyle(cellStyle);
            row.createCell(31).setCellValue("DEU_StrCode");
            row.createCell(32).setCellStyle(cellStyle);
            row.createCell(32).setCellValue("RoutingFileVersion");
            
        }else{
        	FileInputStream fileInputStream=new FileInputStream(substring+"/B2CExcl.xls");
			workbook = new XSSFWorkbook(fileInputStream);
        	sheet = workbook.getSheetAt(0);
        	row = sheet.createRow(sheet.getLastRowNum()+1);
//        	row = sheet.createRow(sheet.getLastRowNum()+1);
            CellStyle cellStyle = workbook.createCellStyle();
            // 设置这些样式
            cellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
//            cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            cellStyle.setBorderBottom(CellStyle.BORDER_THIN);
            cellStyle.setBorderLeft(CellStyle.BORDER_THIN);
            cellStyle.setBorderRight(CellStyle.BORDER_THIN);
            cellStyle.setBorderTop(CellStyle.BORDER_THIN);
            cellStyle.setAlignment(CellStyle.ALIGN_CENTER);
            
            row.createCell(0).setCellStyle(cellStyle);
            row.createCell(0).setCellValue(singleRow);
            row.createCell(1).setCellStyle(cellStyle);
            row.createCell(1).setCellValue(singleRow2);
            row.createCell(2).setCellStyle(cellStyle);
            row.createCell(2).setCellValue(singleRow3);
            row.createCell(3).setCellStyle(cellStyle);
            row.createCell(3).setCellValue(singleRow4);
            row.createCell(4).setCellStyle(cellStyle);
            row.createCell(4).setCellValue(singleRow5);
            row.createCell(5).setCellStyle(cellStyle);
            row.createCell(5).setCellValue(singleRow6);
            row.createCell(6).setCellStyle(cellStyle);
            row.createCell(6).setCellValue(singleRow7);
            row.createCell(7).setCellStyle(cellStyle);
            row.createCell(7).setCellValue(singleRow8);
            row.createCell(8).setCellStyle(cellStyle);
            row.createCell(8).setCellValue(singleRow9);
            row.createCell(9).setCellStyle(cellStyle);
            row.createCell(9).setCellValue(singleRow10);
            row.createCell(10).setCellStyle(cellStyle);
            row.createCell(10).setCellValue(singleRow11);
            row.createCell(11).setCellStyle(cellStyle);
            row.createCell(11).setCellValue(singleRow12);
            row.createCell(12).setCellStyle(cellStyle);
            row.createCell(12).setCellValue(singleRow13);
            row.createCell(13).setCellStyle(cellStyle);
            row.createCell(13).setCellValue(singleRow14);
            row.createCell(14).setCellStyle(cellStyle);
            row.createCell(14).setCellValue(singleRow15);
            row.createCell(15).setCellStyle(cellStyle);
            row.createCell(15).setCellValue(singleRow16);
            row.createCell(16).setCellStyle(cellStyle);
            row.createCell(16).setCellValue(singleRow17);
            row.createCell(17).setCellStyle(cellStyle);
            row.createCell(17).setCellValue(singleRow18);
            row.createCell(18).setCellStyle(cellStyle);
            row.createCell(18).setCellValue(singleRow19);
            row.createCell(19).setCellStyle(cellStyle);
            row.createCell(19).setCellValue(singleRow20);
            row.createCell(20).setCellStyle(cellStyle);
            row.createCell(20).setCellValue(singleRow21);
            row.createCell(21).setCellStyle(cellStyle);
            row.createCell(21).setCellValue(singleRow22);
            row.createCell(22).setCellStyle(cellStyle);
            row.createCell(22).setCellValue(singleRow23);
            row.createCell(23).setCellStyle(cellStyle);
            row.createCell(23).setCellValue(singleRow24);
            row.createCell(24).setCellStyle(cellStyle);
            row.createCell(24).setCellValue(singleRow25);
            row.createCell(25).setCellStyle(cellStyle);
            row.createCell(25).setCellValue(singleRow26);
            row.createCell(26).setCellStyle(cellStyle);
            row.createCell(26).setCellValue(singleRow27);
            row.createCell(27).setCellStyle(cellStyle);
            row.createCell(27).setCellValue(singleRow28);
            row.createCell(28).setCellStyle(cellStyle);
            row.createCell(28).setCellValue(singleRow29);
            row.createCell(29).setCellStyle(cellStyle);
            row.createCell(29).setCellValue(singleRow30);
            row.createCell(30).setCellStyle(cellStyle);
            row.createCell(30).setCellValue(singleRow31);
            row.createCell(31).setCellStyle(cellStyle);
            row.createCell(31).setCellValue(singleRow32);
            row.createCell(32).setCellStyle(cellStyle);
            row.createCell(32).setCellValue(singleRow33);
        }
        try {
            FileOutputStream fileoutputStream = new FileOutputStream(substring+"/B2CExcl.xls");
            workbook.write(fileoutputStream);
            fileoutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
//    public ExecutorService newCachedThreadPool = Executors.newFixedThreadPool(2);
    
    public void readEMSXlxs(String filepath,String id) throws Exception {
        File excelFile = new File(filepath);
        int lastIndexOf = filepath.lastIndexOf("\\");
        String OriginalFilename=filepath.substring(0, lastIndexOf+1);
        XSSFWorkbook wb = null;
//        String url="https://api. tripleeaglelogistics.com/api/awb/submit";
  		HttpUtils httpUtils = new HttpUtils();
  		List<String> errtrackingNumber=new ArrayList<String>();
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = wb.getNumberOfSheets();
        String str = "";
        int hreadCount=0;
//        for (int x = 0; x < 100; x++) {
        for (int x = 0; x < numberOfSheets; x++) {
        	XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
            }
            if (columnNum > 0) {
            	int s=0;
                for (Row row : sheet) {
                	s++;
                	System.out.println(s);
                	if(s==1){
                		continue;
                	}
                    String[] singleRow = new String[columnNum];
                    int n = 0;
                    for (int i = 0; i < columnNum; i++) {
                        Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                singleRow[n] = "";
                                if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
                                    continue;
                                } else {
//                                    System.out.print(singleRow[n] + "|");
                                }
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                singleRow[n] = Boolean.toString(cell
                                        .getBooleanCellValue());
//                                System.out.print(singleRow[n] + "|");
                                break;
                            // 数值
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = null;
                                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                            .getBuiltinFormat("h:mm")) {
                                        sdf = new SimpleDateFormat("HH:mm");
                                    } else {// 日期
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    }
                                    Date date = cell.getDateCellValue();
//                                    System.out.print(sdf.format(date) + "|");
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        singleRow[n] = String.valueOf(new Double(temp))
                                                .trim();
//                                        System.out.print(singleRow[n] + "|");
                                    } else {
                                        singleRow[n] = temp.trim();
//                                        System.out.print(singleRow[n] + "|");
                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                singleRow[n] = cell.getStringCellValue().trim();
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                singleRow[n] = "";
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                if (temp.indexOf(".") > -1) {
                                    temp = String.valueOf(new Double(temp))
                                            .trim();
                                    Double cny = Double.parseDouble(temp);//6.2041
                                    DecimalFormat df = new DecimalFormat("0.00");
                                    String CNY = df.format(cny);
//                                    System.out.print(CNY + "|");
                                } else {
                                    singleRow[n] = temp.trim();
//                                    System.out.print(singleRow[n] + "|");

                                }
                            default:
                                singleRow[n] = "";
                                break;
                        }
                        n++;
                    }
                    if(StringUtils.isBlank(singleRow[0])||StringUtils.isEmpty(singleRow[0])){
                    	continue;
                    }
                    String httpGet = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+singleRow[0]);
                    logger.info("上傳數據："+"http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+singleRow[0]);
//     				String CanadaListRsponse = httpUtils.httpPost(url, CanadaList);
     				logger.info("服務商返回數據："+httpGet);
     				if(StringUtils.isBlank(httpGet)||httpGet.toString().contains("null")){
     					try {
 							Thread.sleep(1000);
 						} catch (InterruptedException e1) {
 							logger.info(e1.toString());
 							e1.printStackTrace();
 						}
     					String fs = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+singleRow[0]);
     					logger.info("再次确认EMS服務商返回數據："+fs);
     					if(StringUtils.isBlank(fs)||fs.toString().contains("null")){
     						try {
     							Thread.sleep(1000);
     						} catch (InterruptedException e1) {
     							logger.info(e1.toString());
     							e1.printStackTrace();
     						}
     						String as = httpUtils.httpGet("http://shipping.ems.com.cn/partner/api/public/p/track/query/cn/"+singleRow[0]);
     						logger.info("第三次确认EMS服務商返回數據："+as);
     						if(StringUtils.isBlank(as)||as.toString().contains("null")){
    	 						try {
    	 								new WriteExcel().writeEMSExcel(OriginalFilename, singleRow[0]);
    							} catch (IOException e) {
    	                            logger.info(e.toString());
    								e.printStackTrace();
    							}
     						}
     					}
     				}        
                    
//            MuEMS muEMS = new MuEMS(httpUtils,OriginalFilename,singleRow[0]);
//            new Thread(muEMS).start();
//        	newCachedThreadPool.execute(muEMS);
//        	hreadCount = ((ThreadPoolExecutor)newCachedThreadPool).getActiveCount();
//        	int size = ((ThreadPoolExecutor)newCachedThreadPool).getQueue().size();
//        	System.out.println("线程池活动的线程"+hreadCount);
//        	System.out.println("缓存中的线程"+size);
            }
           }
        }
        //shutdown通知线程要结束了 不再接受新任务  但是已经在等待队列里要执行的线程会继续执行完毕 再关闭线程池
//        newCachedThreadPool.shutdown();
//        //死循环是为了  一直查看线程任务是否都已经执行完毕  执行完毕 再进行其他工作
//        start:while(true){
//        	//isTerminated判断线程任务是否已经都执行完毕 但是判断前提是一定要已经调用了shutdown()方法 为true表示都执行完了 可以进行下一步操作 
//        	//但是线程一旦出现死锁 那么将出现 这个判断永远为false  后续逻辑都将无法执行
//        	if(newCachedThreadPool.isTerminated()){
//            	logger.info("工作已全部完成  线程池关闭");
//            	//shutdownNow才是结束线程  并且关闭线程池
////            	newCachedThreadPool.shutdownNow();
//            	break;
//            }else{
//            	continue;
//            }
//        }

    }
    
    public void readMaBangXlxs(String filepath,String id) throws Exception {
        File excelFile = new File(filepath);
        int lastIndexOf = filepath.lastIndexOf("\\");
        String OriginalFilename=filepath.substring(0, lastIndexOf+1);
        XSSFWorkbook wb = null;
//        String url="https://api. tripleeaglelogistics.com/api/awb/submit";
  		HttpUtils httpUtils = new HttpUtils();
  		List<String> errtrackingNumber=new ArrayList<String>();
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfSheets = wb.getNumberOfSheets();
        String str = "";
        int hreadCount=0;
//        for (int x = 0; x < 100; x++) {
        for (int x = 0; x < numberOfSheets; x++) {
        	XSSFSheet sheet = wb.getSheetAt(x);
            int columnNum = 0;
            if (sheet.getRow(0) != null) {
                columnNum = sheet.getRow(0).getLastCellNum()
                        - sheet.getRow(0).getFirstCellNum();
            }
            if (columnNum > 0) {
            	int s=0;
                for (Row row : sheet) {
                	s++;
                	System.out.println(s);
                	if(s==1){
                		continue;
                	}
                    String[] singleRow = new String[columnNum];
                    int n = 0;
                    for (int i = 0; i < columnNum; i++) {
                        Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                        switch (cell.getCellType()) {
                            case Cell.CELL_TYPE_BLANK:
                                singleRow[n] = "";
                                if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//                                    System.out.print("<Null>|");
                                } else {
//                                    System.out.print(singleRow[n] + "|");
                                }
                                break;
                            case Cell.CELL_TYPE_BOOLEAN:
                                singleRow[n] = Boolean.toString(cell
                                        .getBooleanCellValue());
//                                System.out.print(singleRow[n] + "|");
                                break;
                            // 数值
                            case Cell.CELL_TYPE_NUMERIC:
                                if (DateUtil.isCellDateFormatted(cell)) {
                                    SimpleDateFormat sdf = null;
                                    if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                            .getBuiltinFormat("h:mm")) {
                                        sdf = new SimpleDateFormat("HH:mm");
                                    } else {// 日期
                                        sdf = new SimpleDateFormat("yyyy-MM-dd");
                                    }
                                    Date date = cell.getDateCellValue();
//                                    System.out.print(sdf.format(date) + "|");
                                } else {
                                    cell.setCellType(Cell.CELL_TYPE_STRING);
                                    String temp = cell.getStringCellValue();
                                    // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                    if (temp.indexOf(".") > -1) {
                                        singleRow[n] = String.valueOf(new Double(temp))
                                                .trim();
//                                        System.out.print(singleRow[n] + "|");
                                    } else {
                                        singleRow[n] = temp.trim();
//                                        System.out.print(singleRow[n] + "|");
                                    }
                                }
                                break;
                            case Cell.CELL_TYPE_STRING:
                                singleRow[n] = cell.getStringCellValue().trim();
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_ERROR:
                                singleRow[n] = "";
//                                System.out.print(singleRow[n] + "|");
                                break;
                            case Cell.CELL_TYPE_FORMULA:
                                cell.setCellType(Cell.CELL_TYPE_STRING);
                                String temp = cell.getStringCellValue();
                                // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                if (temp.indexOf(".") > -1) {
                                    temp = String.valueOf(new Double(temp))
                                            .trim();
                                    Double cny = Double.parseDouble(temp);//6.2041
                                    DecimalFormat df = new DecimalFormat("0.00");
                                    String CNY = df.format(cny);
//                                    System.out.print(CNY + "|");
                                } else {
                                    singleRow[n] = temp.trim();
//                                    System.out.print(singleRow[n] + "|");

                                }
                            default:
                                singleRow[n] = "";
                                break;
                        }
                        n++;
                    }
                    long time = System.currentTimeMillis() / 1000L;
					String json = "{" + "\"code\":\""+singleRow[0]+"\","
							+ "\"changeStatus\":\"sent\","
							+ "\"expressChannelCode\":\""+singleRow[1]+"\"}";
					System.out.println("json = " + json);
					Base64 base64 = new Base64();
					byte[] as = base64.encode(json.getBytes("UTF-8"));
					String encodeParams = new String(as, "UTF-8");

					System.out.println("encodeParams = " + encodeParams);
					String apiKey = "47cee86605f77509a6167691d9d75cfe";
					try {
						as = Digests.md5(("api=api.biaoju.order.update&apiAccountId="
								+ "3763"
								+ "&encodeParams="
								+ encodeParams
								+ "&timestamp=" + time + apiKey).getBytes("UTF-8"));
					} catch (Exception e) {
						e.printStackTrace();
					}
					String http = http(encodeParams, "3763", ByteUtil.toString(as)
							.replace(" ", ""), time);
					System.out.println(http);
					JSONObject fromObject = JSONObject.fromObject(http);
					String ErrorCode = fromObject.getString("ErrorCode");
					String Message = fromObject.getString("Message");
					if(ErrorCode.equals("9999")){
						new WriteExcel().writeExcel3(OriginalFilename,singleRow[0],"成功");
					}else{
						new WriteExcel().writeExcel3(OriginalFilename,singleRow[0],Message);
					}
            }
           }
        }
    }
    
    
    
    public void readPCAXlxs(String filepath,String id) throws Exception {
      File excelFile = new File(filepath);
      int lastIndexOf = filepath.lastIndexOf("\\");
      String OriginalFilename=filepath.substring(0, lastIndexOf+1);
      XSSFWorkbook wb = null;
//      String url="https://api. tripleeaglelogistics.com/api/awb/submit";
		HttpUtils httpUtils = new HttpUtils();
		List<String> errtrackingNumber=new ArrayList<String>();
      try {
          wb = new XSSFWorkbook(new FileInputStream(excelFile));
      } catch (IOException e) {
          e.printStackTrace();
      }
      int numberOfSheets = wb.getNumberOfSheets();
      String str = "";
      
      for (int x = 0; x < numberOfSheets; x++) {
          XSSFSheet sheet = wb.getSheetAt(x);
          int columnNum = 0;
          if (sheet.getRow(0) != null) {
              columnNum = sheet.getRow(0).getLastCellNum()
                      - sheet.getRow(0).getFirstCellNum();
          }
          if (columnNum > 0) {
          	int s=0;
              for (Row row : sheet) {
              	s++;
              	System.out.println(s);
              	if(s==1){
              		continue;
              	}
                  String[] singleRow = new String[columnNum];
                  int n = 0;
                  for (int i = 0; i < columnNum; i++) {
                      Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
                      switch (cell.getCellType()) {
                          case Cell.CELL_TYPE_BLANK:
                              singleRow[n] = "";
                              if (cell == null || cell.equals("") || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK) {
//                                  System.out.print("<Null>|");
                              } else {
//                                  System.out.print(singleRow[n] + "|");
                              }
                              break;
                          case Cell.CELL_TYPE_BOOLEAN:
                              singleRow[n] = Boolean.toString(cell
                                      .getBooleanCellValue());
//                              System.out.print(singleRow[n] + "|");
                              break;
                          // 数值
                          case Cell.CELL_TYPE_NUMERIC:
                              if (DateUtil.isCellDateFormatted(cell)) {
                                  SimpleDateFormat sdf = null;
                                  if (cell.getCellStyle().getDataFormat() == HSSFDataFormat
                                          .getBuiltinFormat("h:mm")) {
                                      sdf = new SimpleDateFormat("HH:mm");
                                  } else {// 日期
                                      sdf = new SimpleDateFormat("yyyy-MM-dd");
                                  }
                                  Date date = cell.getDateCellValue();
//                                  System.out.print(sdf.format(date) + "|");
                              } else {
                                  cell.setCellType(Cell.CELL_TYPE_STRING);
                                  String temp = cell.getStringCellValue();
                                  // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                                  if (temp.indexOf(".") > -1) {
                                      singleRow[n] = String.valueOf(new Double(temp))
                                              .trim();
//                                      System.out.print(singleRow[n] + "|");
                                  } else {
                                      singleRow[n] = temp.trim();
//                                      System.out.print(singleRow[n] + "|");
                                  }
                              }
                              break;
                          case Cell.CELL_TYPE_STRING:
                              singleRow[n] = cell.getStringCellValue().trim();
//                              System.out.print(singleRow[n] + "|");
                              break;
                          case Cell.CELL_TYPE_ERROR:
                              singleRow[n] = "";
//                              System.out.print(singleRow[n] + "|");
                              break;
                          case Cell.CELL_TYPE_FORMULA:
                              cell.setCellType(Cell.CELL_TYPE_STRING);
                              String temp = cell.getStringCellValue();
                              // 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
                              if (temp.indexOf(".") > -1) {
                                  temp = String.valueOf(new Double(temp))
                                          .trim();
                                  Double cny = Double.parseDouble(temp);//6.2041
                                  DecimalFormat df = new DecimalFormat("0.00");
                                  String CNY = df.format(cny);
//                                  System.out.print(CNY + "|");
                              } else {
                                  singleRow[n] = temp.trim();
//                                  System.out.print(singleRow[n] + "|");

                              }
                          default:
                              singleRow[n] = "";
                              break;
                      }
                      n++;
                  }
                  System.out.println(singleRow[2]+"...."+singleRow[2].length());
                  if(StringUtils.isEmpty(singleRow[0])&&StringUtils.isEmpty(singleRow[1])&&StringUtils.isEmpty(singleRow[2])){
                	  continue;
                  }else if(StringUtils.isEmpty(singleRow[2])){
                	  new WriteExcel().writeExcel3(OriginalFilename, singleRow[0], "缺少上传状态数据");
                	  continue;
                  }
                  
                  String data_body="{" +
   		                "  \"cust_ref\" : \""+singleRow[0]+"\"," +
   		                "  \"ref\" : \""+singleRow[1]+"\"," +
   		             "  \"direct\" : \""+singleRow[2]+"\"" +
   		                "}";
                  
//                  System.out.println(CanadaList);
                  logger.info("上傳數據："+data_body);
//                  errtrackingNumber.add("ss......err");
//                  errtrackingNumber.add("aa......err2");
                  String searchPCA = httpUtils.searchPCA(data_body);
//   				String CanadaListRsponse = httpUtils.httpPost(url, CanadaList);
   				logger.info("服務商返回數據："+searchPCA);
   				JSONObject searchPCARsponseJson = JSONObject.fromObject(searchPCA);
   				String status = searchPCARsponseJson.getString("status");
   				String message=null;
//   				if(CanadaListRsponseJson.has("message")){
   					message= searchPCARsponseJson.getString("msg");
//   				}else{
//   					message=CanadaListRsponseJson.getString("messages");
//   				}
//   				referenceNumber="sda";
//   				message="sdaff";
   				if(status.equals("0")){	
   					new WriteExcel().writeExcel3(OriginalFilename, singleRow[1], message);
//   					errtrackingNumber.add(referenceNumber+"......"+message);
   				}
              }
              System.out.println("===========================================================Sheet分割线===========================================================");
          }
      }
  }
    
    public static String http(String encodeParam, String accountId,
			String sign, long time) {
		String httpUrl = "http://www.i8956.com/interface/index.php?api=api.biaoju.order.update&apiAccountId="
				+ accountId
				+ "&encodeParams="
				+ encodeParam
				+ "&timestamp="
				+ time + "&sign=" + sign;
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		try {
			URL url = new URL(httpUrl);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);// �Ƿ��������
			connection.connect();
			InputStream is = connection.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}  
    
}

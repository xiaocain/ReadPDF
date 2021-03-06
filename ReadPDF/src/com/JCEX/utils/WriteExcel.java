package com.JCEX.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import jxl.Workbook;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class WriteExcel {

	public static void writeExcel(String execlpath, String filename,
			String waybillnumber, String address, String HawbString)
			throws IOException {
		File file = new File(execlpath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("PDF文件名", filename);
			map.put("HAWB番号", HawbString);
			map.put("AWB番号", waybillnumber);
			map.put("纳税额总计", address);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(filename); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(HawbString); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 2).setCellValue(waybillnumber); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 3).setCellValue(address); // 设置第二个（从0开始）单元格的数据

			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public static void writeLiXiaoFeiExcel(String execlpath,
			String EnglishName, String HaseCode, String CAD, String Tax,
			String GST) throws IOException {
		File file = new File(execlpath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("英文品名", EnglishName);
			map.put("实际HS编码", HaseCode);
			map.put("申报金额", CAD);
			map.put("税金", Tax);
			map.put("GST", GST);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(EnglishName); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(HaseCode); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 2).setCellValue(CAD); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 3).setCellValue(Tax); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 4).setCellValue(GST);

			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public void writeEMSExcel(String execlpath, String referenceNumber)
			throws IOException {
		File file = new File(execlpath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("未上网单号", referenceNumber);
			// map.put("错误原因", message);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			System.out.println(path);
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(referenceNumber); // 设置第一个（从0开始）单元格的数据
			// row.createCell((short)1).setCellValue(message);
			// //设置第一个（从0开始）单元格的数据

			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public void writeExcel3(String execlpath, String referenceNumber,
			String message) throws IOException {
		File file = new File(execlpath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("错误单号", referenceNumber);
			map.put("错误原因", message);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			System.out.println(path);
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(referenceNumber); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(message); // 设置第一个（从0开始）单元格的数据

			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public void writeWishExcel(String execlpath, String DENotSigned,
			String DENotPushed, String ESNotSigned, String ESNotPushed,
			String NLNotSigned, String NLNotPushed, String ITNotSigned,
			String ITNotPushed, String GBNotSigned, String GBNotPushed,
			String BENotSigned, String BENotPushed, String FRNotSigned,
			String FRNotPushed) throws IOException {
		File file = new File(execlpath + "PDFtoExcl.xls");

		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("德国轨迹未签收", DENotSigned);
			map.put("德国签收轨迹未推送", DENotPushed);
			map.put("西班牙轨迹未签收", ESNotSigned);
			map.put("西班牙签收轨迹未推送", ESNotPushed);
			map.put("荷兰轨迹未签收", NLNotSigned);
			map.put("荷兰签收轨迹未推送", NLNotPushed);
			map.put("意大利轨迹未签收", ITNotSigned);
			map.put("意大利签收轨迹未推送", ITNotPushed);
			map.put("英国轨迹未签收", GBNotSigned);
			map.put("英国签收轨迹未推送", GBNotPushed);
			map.put("比利时轨迹未签收", BENotSigned);
			map.put("比利时签收轨迹未推送", BENotPushed);
			map.put("法国轨迹未签收", FRNotSigned);
			map.put("法国签收轨迹未推送", FRNotPushed);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			System.out.println(path);
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(DENotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(DENotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 2).setCellValue(ESNotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 3).setCellValue(ESNotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 4).setCellValue(NLNotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 5).setCellValue(NLNotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 6).setCellValue(ITNotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 7).setCellValue(ITNotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 8).setCellValue(GBNotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 9).setCellValue(GBNotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 10).setCellValue(BENotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 11).setCellValue(BENotPushed); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 12).setCellValue(FRNotSigned); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 13).setCellValue(FRNotPushed); // 设置第一个（从0开始）单元格的数据
			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public void writeEuropeanTaxBillExcel(String execlpath,
			String MainOrderNumber, String seperate, String jcexbillno,
			String taxNumber, String address, String totalVat, String totalDty,
			String total) throws IOException {
		System.out.println(execlpath);
		execlpath = execlpath.substring(0, execlpath.lastIndexOf("\\") + 1);
		File file = new File(execlpath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("主单号", MainOrderNumber);
			map.put("分单号", seperate);
			map.put("佳成单号", jcexbillno);
			map.put("税号", taxNumber);
			map.put("公司地址", address);
			map.put("VAT", totalVat);
			map.put("Duty", totalDty);
			map.put("Total", total);
			list.add(map);
			// 存放路径
			String path = execlpath + "PDFtoExcl.xls";
			System.out.println(path);
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(MainOrderNumber); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(seperate); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 2).setCellValue(jcexbillno); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 3).setCellValue(taxNumber); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 4).setCellValue(address); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 5).setCellValue(totalVat); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 6).setCellValue(totalDty); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 7).setCellValue(total); // 设置第一个（从0开始）单元格的数据
			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public static void creatExcel(List<Map<String, Object>> list, String path) {
		try {
			// Excel底部的表名
			String sheetn = "table1";
			// 用JXL向新建的文件中添加内容
			File myFilePath = new File(path);
			if (!myFilePath.exists())
				myFilePath.createNewFile();
			OutputStream outf = new FileOutputStream(path);
			WritableWorkbook wwb = Workbook.createWorkbook(outf);
			jxl.write.WritableSheet writesheet = wwb.createSheet(sheetn, 1);
			// 设置标题
			if (list.size() > 0) {
				int j = 0;
				for (Entry<String, Object> entry : list.get(0).entrySet()) {
					String title = entry.getKey();
					writesheet.addCell(new Label(j, 0, title));
					j++;
				}
			}
			// 内容添加
			for (int i = 1; i <= list.size(); i++) {
				int j = 0;
				for (Entry<String, Object> entry : list.get(i - 1).entrySet()) {
					Object o = entry.getValue();
					if (o instanceof Double) {
						writesheet.addCell(new jxl.write.Number(j, i,
								(Double) entry.getValue()));
					} else if (o instanceof Integer) {
						writesheet.addCell(new jxl.write.Number(j, i,
								(Integer) entry.getValue()));
					} else if (o instanceof Float) {
						writesheet.addCell(new jxl.write.Number(j, i,
								(Float) entry.getValue()));
					} else if (o instanceof Float) {
						writesheet.addCell(new DateTime(j, i, (Date) entry
								.getValue()));
					} else if (o instanceof BigDecimal) {
						writesheet.addCell(new jxl.write.Number(j, i,
								((BigDecimal) entry.getValue()).doubleValue()));
					} else if (o instanceof Long) {
						writesheet.addCell(new jxl.write.Number(j, i,
								((Long) entry.getValue()).doubleValue()));
					} else {
						writesheet.addCell(new Label(j, i, (String) entry
								.getValue()));
					}
					j++;
				}
			}
			wwb.write();
			wwb.close();
		} catch (WriteException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void writeB2CExcel(String execlpath, String contents,
			String contents2, String contents3, String contents4,
			String contents5, String contents6, String contents7,
			String contents8, String contents9, String contents10,
			String contents11, String contents12, String contents13,
			String contents14, String contents15, String contents16,
			String contents17, String contents18, String contents19,
			String contents20, String contents21, String contents22,
			String contents23, String contents24, String contents25,
			String contents26, String contents27, String contents28,
			String contents29, String contents30, String contents31,
			String contents32, String contents33) throws IOException {
		File file = new File(execlpath + "/B2CExcl.xls");
		if (StringUtils.isBlank(contents24)) {
			contents24 = "6109909060";
		}
		String decode = URLDecoder.decode(contents15, "UTF-8");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("OrderNumber", contents);
			map.put("PackageBarcode", contents2);
			map.put("PrealertReference", contents3);
			map.put("ShippingMethod", contents4);
			map.put("Weight", contents5);
			map.put("CompanyName", new String(contents6.getBytes(), "UTF-8"));
			map.put("ConsigneeName", new String(contents7.getBytes(), "UTF-8"));
			map.put("PhoneNumber", new String(contents8.getBytes(), "UTF-8"));
			map.put("EmailAddress", new String(contents9.getBytes(), "UTF-8"));
			map.put("Street", new String(contents10.getBytes(), "UTF-8"));
			map.put("HouseNumber", new String(contents11.getBytes(), "UTF-8"));
			map.put("HouseNumberExtension", new String(contents12.getBytes(),
					"UTF-8"));
			map.put("AdditionalAddressInfo", new String(contents13.getBytes(),
					"UTF-8"));
			map.put("City", new String(contents14.getBytes(), "UTF-8"));
			map.put("Province", decode);
			map.put("PostalCode", new String(contents16.getBytes(), "UTF-8"));
			map.put("CountryCode", new String(contents17.getBytes(), "UTF-8"));
			map.put("SKUCode", new String(contents18.getBytes(), "UTF-8"));
			map.put("SKUDescription",
					new String(contents19.getBytes(), "UTF-8"));
			map.put("Quantity", contents20);
			map.put("Currency", contents21);
			map.put("UnitPrice", new String(contents22.getBytes(), "UTF-8"));
			map.put("ShippingCosts", new String(contents23.getBytes(), "UTF-8"));
			map.put("HSCode", new String(contents24.getBytes(), "UTF-8"));
			map.put("WebSiteURL", new String(contents25.getBytes(), "UTF-8"));
			map.put("TYPNumber", new String(contents26.getBytes(), "UTF-8"));
			map.put("BagReference", new String(contents27.getBytes(), "UTF-8"));
			map.put("TrackingNumber",
					new String(contents28.getBytes(), "UTF-8"));
			map.put("DEU_RoutingCode", new String(contents29.getBytes(),
					"UTF-8"));
			map.put("DEU_KGName", new String(contents30.getBytes(), "UTF-8"));
			map.put("DEU_Street46", new String(contents31.getBytes(), "UTF-8"));
			map.put("DEU_StrCode", new String(contents32.getBytes(), "UTF-8"));
			map.put("RoutingFileVersion", new String(contents33.getBytes(),
					"UTF-8"));
			list.add(map);
			// 存放路径
			String path = execlpath + "/B2CExcl.xls";
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(execlpath
					+ "/B2CExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(execlpath
					+ "/B2CExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			contents14 = contents14.trim();
			contents15 = contents15.trim();
			contents15.getBytes();
			if (StringUtils.isBlank(contents15)) {
				contents15 = "";
			}
			for (; contents15.contains("  ");) {
				contents15 = contents15.replace("  ", "");
			}
			System.out.println(contents15 + "....." + contents15.length());
			row.createCell((short) 0).setCellValue(contents); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(contents2); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 2).setCellValue(contents3); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 3).setCellValue(contents4); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 4).setCellValue(contents5); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 5).setCellValue(
					new String(contents6.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 6).setCellValue(
					new String(contents7.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 7).setCellValue(
					new String(contents8.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 8).setCellValue(
					new String(contents9.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 9).setCellValue(
					new String(contents10.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 10).setCellValue(
					new String(contents11.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 11).setCellValue(
					new String(contents12.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 12).setCellValue(
					new String(contents13.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 13).setCellValue(
					new String(contents14.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 14).setCellValue(decode); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 15).setCellValue(
					new String(contents16.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 16).setCellValue(
					new String(contents17.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 17).setCellValue(
					new String(contents18.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 18).setCellValue(
					new String(contents19.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 19).setCellValue(contents20); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 20).setCellValue(contents21); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 21).setCellValue(
					new String(contents22.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 22).setCellValue(
					new String(contents23.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 23).setCellValue(
					new String(contents24.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 24).setCellValue(
					new String(contents25.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 25).setCellValue(
					new String(contents26.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 26).setCellValue(
					new String(contents27.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 27).setCellValue(
					new String(contents28.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 28).setCellValue(
					new String(contents29.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 29).setCellValue(
					new String(contents30.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 30).setCellValue(
					new String(contents31.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 31).setCellValue(
					new String(contents32.getBytes(), "UTF-8")); // 设置第二个（从0开始）单元格的数据
			row.createCell((short) 32).setCellValue(
					new String(contents33.getBytes(), "UTF-8")); // 设置第一个（从0开始）单元格的数据
			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}
	}

	public void writeYaoYeExcel(String absolutePath, String key, String value) throws IOException {
		System.out.println(absolutePath);
		absolutePath = absolutePath.substring(0, absolutePath.lastIndexOf("\\") + 1);
		File file = new File(absolutePath + "PDFtoExcl.xls");
		if (!file.isFile()) {
			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
			Map<String, Object> map = new LinkedHashMap<String, Object>();
			map.put("英文品名", key);
			map.put("hscode", value);
			list.add(map);
			// 存放路径
			String path = absolutePath + "PDFtoExcl.xls";
			System.out.println(path);
			try {
				new WriteExcel().creatExcel(list, path);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			FileInputStream fileInputStream = new FileInputStream(absolutePath
					+ "PDFtoExcl.xls");
			POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
					fileInputStream);
			HSSFWorkbook wb = new HSSFWorkbook(poifsFileSystem);
			HSSFSheet sheet = wb.getSheet("table1");
			HSSFRow row = sheet.getRow(0);
			// 分别得到最后一行的行号，和一条记录的最后一个单元格
			// System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
			FileOutputStream out = new FileOutputStream(absolutePath
					+ "PDFtoExcl.xls");
			row = sheet.createRow((short) (sheet.getLastRowNum() + 1)); // 最后一行加1
			row.createCell((short) 0).setCellValue(key); // 设置第一个（从0开始）单元格的数据
			row.createCell((short) 1).setCellValue(value); // 设置第一个（从0开始）单元格的数据
			out.flush();
			wb.write(out);
			out.close();
			// System.out.println(row.getPhysicalNumberOfCells()+" "+row.getLastCellNum());
		}

	}
}
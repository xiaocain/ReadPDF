package com.JCEX.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jxl.read.biff.BiffException;

import org.apache.commons.lang.StringUtils;
import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdfparser.PDFStreamParser;
import org.apache.pdfbox.pdfwriter.ContentStreamWriter;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.util.logging.resources.logging;

import com.JCEX.serviceImpl.WishTrackImpl;
import com.JCEX.utils.DownloadExecl;
import com.JCEX.utils.PDFtoString;
import com.JCEX.utils.PartitionPdfFile;
import com.JCEX.utils.PdfReplacer;
import com.JCEX.utils.ReadExcl;
import com.JCEX.utils.ReadXLXS;
import com.JCEX.utils.WriteExcel;
import com.JCEX.utils.ZipUtils;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;

import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class ReadPDFMonWb {
	private Logger logger = LoggerFactory.getLogger(getClass());
	private static String result = null; // 用来保存pdf文件中的信息
	private static FileInputStream is = null; // 输入流
	private static PDDocument document = null;

	// public static String getPdfFileText(String fileName) throws IOException {
	// PdfReader reader = new PdfReader(fileName);
	// PdfReaderContentParser parser = new PdfReaderContentParser(reader);
	// StringBuffer buff = new StringBuffer();
	// TextExtractionStrategy strategy;
	// for (int i = 1; i <= reader.getNumberOfPages(); i++) {
	// strategy = parser.processContent(i,
	// new SimpleTextExtractionStrategy());
	// buff.append(strategy.getResultantText());
	// }
	// return buff.toString();
	// }

	// 获取pdf文件文件中全部信息
	public static String getAllInfoFromPDF(String pdfFilePath) {
		String result = null;
		FileInputStream is = null;
		PDDocument document = null;
		try {
			document = PDDocument.load(new File(pdfFilePath));
			PDFTextStripper stripper = new PDFTextStripper();
			result = stripper.getText(document);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (document != null) {
				try {
					document.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}

	/**
	 * 993822922.pdf
	 * 
	 * @param filepathdata
	 * @throws Exception
	 */
	// ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(8);
	// new DeletePDFContent()
	// newFixedThreadPool.execute(command);
	public void deletePDFContent(String filepathdata) throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info("开始时间............" + startTime);
		// System.out.println(filepathdata);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {

			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			logger.info(f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				// 是pdf格式的文件
				// 得到全部pdf文件中的信息

				// String textFromPdf = new
				// PDFtoString().getTextFromPdf("C:\\pdf\\266-270.pdf");
				// **********正式代码
				String textFromPdf = new PDFtoString().getTextFromPdf(f
						.getAbsolutePath());
				// System.out.println(textFromPdf);
				String str = textFromPdf;
				// 需要对比的字符串
				String compareStr = "rinter";
				// 字符串查找初始从0开始查找
				int indexStart = 0;
				// 获取查找字符串的长度，这里有个规律：第二次查找出字符串的起始位置等于 第一次ab字符串出现的位置+ab的长度
				int compareStrLength = compareStr.length();
				int count = 0;
				while (true) {
					int tm = str.indexOf(compareStr, indexStart);
					if (tm >= 0) {
						count++;
						// 没查找一次就从新计算下次开始查找的位置
						indexStart = tm + compareStrLength;
					} else {
						// 直到没有匹配结果为止
						break;
					}
				}

				// int
				// b=textFromPdf.length()-textFromPdf.replaceAll("<AIR/IMP>",
				// "").length();
				// StringBuffer a=new StringBuffer();
				List<String> a = new ArrayList<String>();
				String AWB = null;
				List<String> money = new ArrayList<String>();
				String MoneyData = null;
				List<String> HAWB = new ArrayList<String>();
				String oneHawb = null;

				ArrayList<Integer> countindex = new ArrayList<Integer>();
				File file2 = new File(filepathdata + "/PartitionPDF/");
				if (!file2.exists()) {
					file2.mkdirs();
				}
				String AIRtoRinter;
				PdfReplacer textReplacer = new PdfReplacer();
				textReplacer.PdfStart(f.getAbsolutePath());
				String absolutePath2 = f.getAbsolutePath().substring(
						f.getAbsolutePath().lastIndexOf("\\") + 1,
						f.getAbsolutePath().length());
				for (int i = 0; i < count; i++) {
					int AIRindex = textFromPdf.indexOf("<AIR/IMP>");
					int rinterIndex = textFromPdf.indexOf("rinter") + 6;
					// 一页的内容
					AIRtoRinter = textFromPdf.substring(AIRindex, rinterIndex);
					int numberindex = AIRtoRinter.indexOf("1 / 2");
					// int number2index = AIRtoRinter.indexOf("2 / 2");
					if (numberindex != -1) {
						countindex.add(i);
					}

					if (AIRtoRinter.contains("輸 入 者")
							&& AIRtoRinter.contains("住 所")
							&& AIRtoRinter.contains("電 話")
							&& AIRtoRinter.contains("税関事務管理人")) {
						int indexOf = AIRtoRinter.indexOf("輸 入 者");
						int indexOf2 = AIRtoRinter.indexOf("住 所");
						int indexOf3 = AIRtoRinter.indexOf("電 話");
						int indexOf4 = AIRtoRinter.indexOf("税関事務管理人");
						String interimDatePeople = AIRtoRinter.substring(
								indexOf + 6, indexOf2);
						String interimDateAddress = AIRtoRinter.substring(
								indexOf2 + 4, indexOf3);
						String[] Addresssplit = interimDateAddress
								.split("\r\n");
						String Address1 = Addresssplit[0];
						String Address2 = Addresssplit[1];
						String interimDatePhone = AIRtoRinter.substring(
								indexOf3 + 4, indexOf4);
						textReplacer.setPageNumber(i + 1);
						interimDatePeople = interimDatePeople.trim();
						Address1 = Address1.trim();
						Address2 = Address2.trim();
						if (interimDatePhone.contains("\r\n")) {
							interimDatePhone = interimDatePhone.substring(0,
									interimDatePhone.indexOf("\r\n")).trim();
						}
						textReplacer.replaceText(interimDatePeople, "");
						textReplacer.replaceText(Address1, "");
						textReplacer.replaceText(Address2, "");
						textReplacer.replaceText(interimDatePhone, "");
						textReplacer.toPdf();
						textFromPdf = textFromPdf.substring(rinterIndex,
								textFromPdf.length());
					}
				}
				textReplacer.toFile(filepathdata + "/PartitionPDF/"
						+ absolutePath2);
			}
		}
		new ZipUtils().createCardImgZip(filepathdata + "/PartitionPDF",
				filepathdata + "/PartitionPDF/Zip/");
	}

	public void pdfo(String filepathdata) throws Exception {
		long startTime = System.currentTimeMillis();
		logger.info("开始时间............" + startTime);
		// System.out.println(filepathdata);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {

			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			logger.info(f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				// 是pdf格式的文件
				// 得到全部pdf文件中的信息

				// String textFromPdf = new
				// PDFtoString().getTextFromPdf("C:\\pdf\\266-270.pdf");
				// **********正式代码
				String textFromPdf = new PDFtoString().getTextFromPdf(f
						.getAbsolutePath());
				// System.out.println(textFromPdf);
				String str = textFromPdf;
				// 需要对比的字符串
				String compareStr = "rinter";
				// 字符串查找初始从0开始查找
				int indexStart = 0;
				// 获取查找字符串的长度，这里有个规律：第二次查找出字符串的起始位置等于 第一次ab字符串出现的位置+ab的长度
				int compareStrLength = compareStr.length();
				int count = 0;
				while (true) {
					int tm = str.indexOf(compareStr, indexStart);
					if (tm >= 0) {
						count++;
						// 没查找一次就从新计算下次开始查找的位置
						indexStart = tm + compareStrLength;
					} else {
						// 直到没有匹配结果为止
						break;
					}
				}

				// int
				// b=textFromPdf.length()-textFromPdf.replaceAll("<AIR/IMP>",
				// "").length();
				// StringBuffer a=new StringBuffer();
				List<String> a = new ArrayList<String>();
				String AWB = null;
				List<String> money = new ArrayList<String>();
				String MoneyData = null;
				List<String> HAWB = new ArrayList<String>();
				String oneHawb = null;

				ArrayList<Integer> countindex = new ArrayList<Integer>();

				for (int i = 0; i < count; i++) {
					int AIRindex = textFromPdf.indexOf("<AIR/IMP>");
					int rinterIndex = textFromPdf.indexOf("rinter") + 6;
					String AIRtoRinter = textFromPdf.substring(AIRindex,
							rinterIndex);
					int numberindex = AIRtoRinter.indexOf("1 / 2");
					// int number2index = AIRtoRinter.indexOf("2 / 2");
					if (numberindex != -1) {
						countindex.add(i);
					}
					if (AIRtoRinter.contains("ＡＷＢ番号")
							|| AIRtoRinter.contains("納税額合計 \\")
							|| AIRtoRinter.contains("ＨＡＷＢ番号")) {
						int AWBindex = AIRtoRinter.indexOf("ＡＷＢ番号");
						int Moneyindex = AIRtoRinter.indexOf("納税額合計 \\");
						int HAWBindex = AIRtoRinter.indexOf("ＨＡＷＢ番号");
						// int numberindex = AIRtoRinter.indexOf("1 / 2");

						if (AWBindex != -1) {
							String agAWBindex = AIRtoRinter.substring(
									AWBindex - 1, AWBindex);
							if (!agAWBindex.equals("Ｍ")) {
								if (AWBindex - 1 == HAWBindex) {
									AWB = "0";
								} else {
									String substring3 = AIRtoRinter.substring(
											AWBindex + 6, AIRtoRinter.length());
									int indexOf3 = substring3.indexOf(" ");
									AWB = substring3.substring(0, indexOf3);
								}
								if (HAWBindex != -1) {
									String substring4 = AIRtoRinter
											.substring(HAWBindex + 7,
													AIRtoRinter.length());
									int indexOf4 = substring4.indexOf(" ");
									oneHawb = substring4.substring(0, indexOf4);
								} else {
									oneHawb = "0";
								}
								if (Moneyindex != -1) {
									String substring2 = AIRtoRinter.substring(
											Moneyindex + 7,
											AIRtoRinter.length());
									int indexOf2 = substring2.indexOf(" ");
									MoneyData = substring2.substring(0,
											indexOf2);
									if (AWB.contains("-")) {
										AWB = AWB.replace("-", "");
									}
									if (oneHawb.contains("-")) {
										oneHawb = oneHawb.replace("-", "");
									}
									a.add(AWB);
									HAWB.add(oneHawb);
									if (MoneyData.contains(",")) {
										MoneyData = MoneyData.replace(",", "");
									}
									if (MoneyData.equals("0")) {
										money.add("0");
									} else {
										money.add("TAX" + MoneyData + "JPY");
									}
								} else {
									String substring2 = AIRtoRinter.substring(
											Moneyindex + 7,
											AIRtoRinter.length());
									int indexOf2 = substring2.indexOf(" ");
									MoneyData = substring2.substring(0,
											indexOf2);
									if (AWB.contains("-")) {
										AWB = AWB.replace("-", "");
									}
									if (oneHawb.contains("-")) {
										oneHawb = oneHawb.replace("-", "");
									}
									a.add(AWB);
									HAWB.add(oneHawb);
									money.add("0");

								}
							} else {
								HAWB.add("0");
								a.add("0");
								money.add("0");
								textFromPdf = textFromPdf.substring(
										rinterIndex, textFromPdf.length());
								continue;
							}
						} else {
							if (Moneyindex != -1) {
								String substring3 = AIRtoRinter.substring(
										Moneyindex + 7, AIRtoRinter.length());
								int indexOf3 = substring3.indexOf(" ");
								MoneyData = substring3.substring(0, indexOf3);
								a.add("0");
								HAWB.add("0");
								if (MoneyData.contains(",")) {
									MoneyData = MoneyData.replace(",", "");
								}
								if (MoneyData.equals("0")) {
									money.add("0");
								} else {
									money.add("TAX" + MoneyData + "JPY");
								}
							} else {
								HAWB.add("0");
								a.add("0");
								money.add("0");
							}
						}
						textFromPdf = textFromPdf.substring(rinterIndex,
								textFromPdf.length());
					} else {
						a.add("0");
						money.add("0");
						HAWB.add("0");
						textFromPdf = textFromPdf.substring(rinterIndex,
								textFromPdf.length());
						continue;
					}
				}
				new PartitionPdfFile().partitionPdfFile(count,
						f.getAbsolutePath(), filepathdata + "/PartitionPDF/",
						countindex, HAWB, a);
				// System.out.println(a.toString()+"......"+money.toString());
				int lastIndexOf = absolutePath.lastIndexOf("\\");
				String filename = absolutePath.substring(lastIndexOf + 1,
						absolutePath.length());
				int size3 = a.size();
				for (int j = 0; j < size3; j++) {
					String AWBString = a.get(j);
					String MoneyString = money.get(j);
					String HAWBString = HAWB.get(j);
					new WriteExcel().writeExcel(filepathdata, filename,
							AWBString, MoneyString, HAWBString);
				}
			}
		}
		new ZipUtils().createCardImgZip(filepathdata + "/PartitionPDF",
				filepathdata + "/PartitionPDF/Zip/");
	}

	public void SHpdfo(String filepathdata) throws Exception {
		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			logger.info(f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				// 是pdf格式的文件
				// 得到全部pdf文件中的信息

				// String textFromPdf = new
				// PDFtoString().getTextFromPdf("C:\\pdf\\266-270.pdf");
				// **********正式代码
				String textFromPdf = new PDFtoString().getTextFromPdf(f
						.getAbsolutePath());
				System.out.println(textFromPdf);
				String filed = absolutePath.substring(
						absolutePath.lastIndexOf("\\") + 1,
						absolutePath.length());
				System.out.println("文件名...." + filed);
				// System.out.println(textFromPdf);
				Integer pageNumber = 0;
				if (textFromPdf.contains("ECONOMY SELECT")
						|| textFromPdf.contains("EXPRESS DOMESTIC")) {
					// int Refindex = textFromPdf.indexOf("Ref: ");
					// if(Refindex!=-1){
					// String substring =
					// textFromPdf.substring(Refindex+5,textFromPdf.length());
					// int indexOf = substring.indexOf(" ");
					// String Waybillnumber = substring.substring(0, indexOf);

					// int kgindex = textFromPdf.indexOf("kg ");
					int kgindex = textFromPdf.indexOf("kg");
					String substring2 = textFromPdf.substring(kgindex + 3,
							textFromPdf.length());
					int indexOf2 = substring2.indexOf(" ");
					// String substring3 = substring2.substring(indexOf2+1,
					// substring2.length());
					String substring3 = null;
					if (substring2.indexOf("/") != -1) {
						// if(substring3.indexOf("/")!=-1&&substring3.indexOf("/")==0){
						substring3 = substring2.substring(
								substring2.indexOf("/") + 1,
								substring2.length());
					}
					// int indexOf3 = substring3.indexOf(" ");
					substring3 = substring3.replaceFirst("\n", "#");
					int Contentsindex = substring3.indexOf("#");
					// Pattern compile = Pattern.compile("\n");
					// Matcher matcher = compile.matcher(substring3);
					// if(matcher.find()){
					// matcher.regionStart()
					// }
					// System.out.println("之前的索引..."+indexOf3+"之后的索引..."+Contentsindex);
					String pagenumber = substring3.substring(0, Contentsindex)
							.replace(" ", "");
					System.out.println(pagenumber);
					pageNumber = Integer.parseInt(pagenumber.trim());
				} else if (textFromPdf.contains("VAN MON TO FRI Meter")) {
					int indexOf = textFromPdf.indexOf("1 of ");
					String substring = textFromPdf.substring(indexOf + 5,
							textFromPdf.length());
					int indexOf2 = substring.indexOf("\n");
					String substring2 = substring.substring(0, indexOf2);
					pageNumber = Integer.parseInt(substring2.trim());
				}
				// String filed =
				// absolutePath.substring(absolutePath.lastIndexOf("\\")+1,
				// absolutePath.length());
				// System.out.println("文件名...."+filed);
				new PartitionPdfFile().SHfromtoendPdfFile(absolutePath, filed,
						1, pageNumber);
			}
		}
		long currentTimeMillis2 = System.currentTimeMillis();
		System.out.println("结束时间........" + currentTimeMillis2);
		new ZipUtils().createCardImgZip(filepathdata
				+ "/PartitionPDF/Partition/", filepathdata
				+ "/PartitionPDF/Partition/Zip/");
		long currentTimeMillis3 = System.currentTimeMillis();
		System.out.println("打包时间........" + currentTimeMillis3);
	}

	// public static void main(String[] args) throws Exception {
	// new ReadPDFMonWb().DJpdfo("D://Execl2","2");
	// }

	public void DJpdfo(String filepathdata, String id) throws Exception {
		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		List<String> readXlxs = new ArrayList<String>();
		// 把获取到的文件名保存在数组中
		// File[] files = file.listFiles();
		// for(File f:files){
		// --------------------------1.获取文件路径
		String absolutePath = file.getAbsolutePath();
		// System.out.println("文件路径:"+f.getAbsolutePath());
		logger.info(file.getAbsolutePath());

		// 获取文件类型，即文件后缀名
		int start = file.getAbsolutePath().length() - 3;
		int end = file.getAbsolutePath().length();
		// 得到文件的后缀名
		String pdf = file.getAbsolutePath().substring(start, end);
		System.out.println();
		// 判断是否是pdf格式的文件
		new ReadXLXS().readXlxs(absolutePath, id);
		// }
	}

	public void B2CExecl(String filepathdata) throws Exception {
		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			logger.info(f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是xls格式的文件
			if (pdf.equals("xls")) {
				new ReadExcl().ReadFromExcel(f.getAbsolutePath());
			}
		}
	}

	public void MaBangpdfo(String filepathdata, String id) throws Exception {

		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		List<String> readXlxs = new ArrayList<String>();

		String absolutePath = file.getAbsolutePath();
		logger.info(file.getAbsolutePath());

		// 获取文件类型，即文件后缀名
		int start = file.getAbsolutePath().length() - 3;
		int end = file.getAbsolutePath().length();
		// 得到文件的后缀名
		String pdf = file.getAbsolutePath().substring(start, end);
		System.out.println();

		new ReadXLXS().readMaBangXlxs(absolutePath, id);
		// }
	}

	public void EMSpdfo(String filepathdata, String id) throws Exception {

		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		List<String> readXlxs = new ArrayList<String>();

		String absolutePath = file.getAbsolutePath();
		logger.info(file.getAbsolutePath());

		// 获取文件类型，即文件后缀名
		int start = file.getAbsolutePath().length() - 3;
		int end = file.getAbsolutePath().length();
		// 得到文件的后缀名
		String pdf = file.getAbsolutePath().substring(start, end);
		System.out.println();

		new ReadXLXS().readEMSXlxs(absolutePath, id);
		// }
	}

	public void PCApdfo(String filepathdata, String id) throws Exception {

		System.out.println(filepathdata);
		long currentTimeMillis = System.currentTimeMillis();
		System.out.println("开始时间........" + currentTimeMillis);
		/*
		 * 通过递归得到某一路径下所有的目录及其PDF文件
		 */
		// 通过传入文件路径获取文件
		logger.info(filepathdata);
		String code = null;
		File file = new File(filepathdata);
		List<String> readXlxs = new ArrayList<String>();

		String absolutePath = file.getAbsolutePath();
		logger.info(file.getAbsolutePath());

		// 获取文件类型，即文件后缀名
		int start = file.getAbsolutePath().length() - 3;
		int end = file.getAbsolutePath().length();
		// 得到文件的后缀名
		String pdf = file.getAbsolutePath().substring(start, end);
		System.out.println();

		new ReadXLXS().readPCAXlxs(absolutePath, id);
		// }
	}

	public void YaoYepdfo(String path) throws Exception {
		logger.info(path);
		String code = null;
		File file = new File(path);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			logger.info("现在处理到" + f.getAbsolutePath());
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				String textFromPdf = "";
				try {
					textFromPdf = new PDFtoString().getTextFromPdf(f
							.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.info("读取PDF出现异常 文件名" + f.getAbsolutePath());
				}
				// System.out.println(textFromPdf);
				String str = textFromPdf;
				String Seperatepattern = "31\\ [^0-9]+ PKG=.+32\\ [0-9]+\\ 33\\ [0-9]+";
				Matcher matcher = Pattern.compile(Seperatepattern).matcher(str);
				List<Map<String,String>> execlData=new ArrayList<Map<String,String>>();
				while(matcher.find()){
					String group = matcher.group();
					String EnglishName = group.substring(3, group.indexOf("PKG="));
					while(group.contains("  ")){
						group=group.replace("  ", " ");
					}
					String[] split = group.split(" ");
					String hscode = split[split.length-1];
					HashMap<String, String> hashMap = new HashMap<String,String>();
					hashMap.put(EnglishName, hscode);
					execlData.add(hashMap);
				}
				for (Map<String, String> map : execlData) {
					Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
					while(iterator.hasNext()){
						Entry<String, String> next = iterator.next();
						try{
							new WriteExcel().writeYaoYeExcel(absolutePath,next.getKey(),next.getValue());
						}catch(IOException e){
							logger.info("写入Execl出现异常" + f.getAbsolutePath());
						}
						
					}
				}
			}
		}
	}
	
	public void EuropeanTaxBillpdfo(String path) throws Exception {
		logger.info(path);
		String code = null;
		File file = new File(path);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			logger.info("现在处理到" + f.getAbsolutePath());
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				String textFromPdf = "";
				try {
					textFromPdf = new PDFtoString().getTextFromPdf(f
							.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.info("读取PDF出现异常 文件名" + f.getAbsolutePath());
				}
				// System.out.println(textFromPdf);
				String str = textFromPdf;
				// System.out.println(str+"\n\n\n\n\n\n");
				// int indexOf = str.indexOf("6");
				String Seperatepattern = "5\\ [0-9]+\\ +6\\ [0-9]+\\ +7\\ ";
				Pattern Seperater = Pattern.compile(Seperatepattern);
				Matcher Seperatem = Seperater.matcher(str);
				String seperate = "";
				if (Seperatem.find()) {
					String group = Seperatem.group();
					str = str.substring(str.indexOf(group) + group.length(),
							str.length());
					seperate = str.substring(0, str.indexOf(" "));
				}

				// MYC 截取 “, IAIS:”前8位
				String jcexbillno = "";
				if (str.indexOf(", IAIS:") != -1) {
					jcexbillno = str.substring(str.indexOf(", IAIS:") - 8,
							str.indexOf(", IAIS:"));
					// seperate = str.substring(0, str.indexOf(" "));
				}

				String TaxNumberpattern = "8\\ +([A-Z]{2}|[A-Z]{5})[0-9]+\\ +21";
				Pattern TaxNumberr = Pattern.compile(TaxNumberpattern);
				Matcher TaxNumberm = TaxNumberr.matcher(str);
				String TaxNumber = "";
				if (TaxNumberm.find()) {
					String group = TaxNumberm.group();
					group = group.substring(1, group.lastIndexOf("21"));
					TaxNumber = group.trim();
					// str=str.substring(str.indexOf(group)+1, str.length());
					// TaxNumber=str.substring(0, str.indexOf("21"));
					// TaxNumber=TaxNumber.trim();
				}
				String AddressPattern = "21\\ [A-Z]{2}[0-9A-Z]+\\ [0-9]{2}\\ [A-Za-z]{3,4}\\ [0-9]{4}\\ +[A-Z]{2}";
				Pattern Addressr = Pattern.compile(AddressPattern);
				Matcher Addressm = Addressr.matcher(str);
				String Address = "";
				if (Addressm.find()) {
					String group = Addressm.group();

					str = str.substring(str.indexOf(group) + group.length(),
							str.length());
					String OneAddress = "";
					if (str.indexOf("22 GBP") != -1) {
						OneAddress = str.substring(0, str.indexOf("22 GBP"));
					} else if (str.indexOf("22 USD") != -1) {
						OneAddress = str.substring(0, str.indexOf("22 USD"));
					} else if (str.indexOf("22 EUR") != -1) {
						OneAddress = str.substring(0, str.indexOf("22 EUR"));
					}

					String TwoAddressPattern = "22\\ (GBP|USD|EUR) [0-9]+\\.[0-9]{2}";
					Pattern TwoAddressr = Pattern.compile(TwoAddressPattern);
					Matcher TwoAddressm = TwoAddressr.matcher(str);
					if (TwoAddressm.find()) {
						String Twogroup = TwoAddressm.group();
						String ThreeAddressPattern = "25\\ [0-9]+\\ +26";
						Pattern ThreeAddressPatterr = Pattern
								.compile(ThreeAddressPattern);
						Matcher ThreeAddressPatterm = ThreeAddressPatterr
								.matcher(str);
						if (ThreeAddressPatterm.find()) {
							String ThreeAddress = ThreeAddressPatterm.group();
							String TwoAddress = str.substring(
									str.indexOf(Twogroup) + Twogroup.length(),
									str.indexOf(ThreeAddress));
							Address = OneAddress + TwoAddress;
							Address = Address.trim();
							while (Address.contains("  ")) {
								Address = Address.replace("  ", "");
							}
							Address = Address.replaceAll("[\\t\\n\\r]", "");
						}
					}
				}
				String MainOrderNumberPattern = "40 Z 74[10]\\ +[A-Z0-9\\-]+";
				Pattern MainOrderNumberr = Pattern
						.compile(MainOrderNumberPattern);
				Matcher MainOrderNumberm = MainOrderNumberr.matcher(str);
				String MainOrderNumber = "";
				if (MainOrderNumberm.find()) {
					String group = MainOrderNumberm.group();
					while (group.contains("  ")) {
						group = group.replace("  ", " ");
					}
					MainOrderNumber = group.substring(9, group.length());
				}
				String TotalDtyPattern = "Total Dty:\\ +[0-9]+\\.[0-9]{2}";
				String TotalVatPattern = "Total Vat:\\ +[0-9]+\\.[0-9]{2}";
				Pattern TotalVatr = Pattern.compile(TotalVatPattern);
				Pattern TotalDtyr = Pattern.compile(TotalDtyPattern);
				Matcher TotalVatm = TotalVatr.matcher(str);
				Matcher TotalDtym = TotalDtyr.matcher(str);
				String TotalVat = "";
				String TotalDty = "";
				if (TotalVatm.find()) {
					String group = TotalVatm.group();
					while (group.contains("  ")) {
						group = group.replace("  ", " ");
					}
					TotalVat = group.substring(11, group.length());
				}
				if (TotalDtym.find()) {
					String group = TotalDtym.group();
					while (group.contains("  ")) {
						group = group.replace("  ", " ");
					}
					TotalDty = group.substring(11, group.length());
				}
				BigDecimal a1 = new BigDecimal(TotalVat);
				BigDecimal b1 = new BigDecimal(TotalDty);
				BigDecimal add = a1.add(b1);
				String total = String.valueOf(add);
				try {
					new WriteExcel().writeEuropeanTaxBillExcel(absolutePath,
							MainOrderNumber, seperate, jcexbillno, TaxNumber,
							Address, TotalVat, TotalDty, total);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					logger.info("写入Execl出现异常" + f.getAbsolutePath());
				}
				System.out.println("seperate...." + seperate);
				System.out.println("TaxNumber...." + TaxNumber);
				System.out.println("MainOrderNumber...." + MainOrderNumber);
				System.out.println("Total Dty:...." + TotalDty
						+ ".....Total Vat:...." + TotalVat);
				System.out.println("Address...." + Address);
				logger.info(f.getAbsolutePath() + "已处理完");
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String textFromPdf = new PDFtoString()
				.getTextFromPdf("D:\\error\\GB239906082-6100341734 C88.pdf");
		System.out.println(textFromPdf);
		// int indexOf = textFromPdf.indexOf("B3-3 (04)\r\nCanada");
		// System.out.println(indexOf);
		// System.out.println("Droits de Douane Cotisation de LMSI".length());
		// new ReadPDFMonWb().deletePDFContent("D:\\error\\11");
	}

	public void LiXiaoFeipdfo(String path) throws Exception {
		logger.info(path);
		String code = null;
		File file = new File(path);
		// 把获取到的文件名保存在数组中
		File[] files = file.listFiles();
		for (File f : files) {
			// --------------------------1.获取文件路径
			String absolutePath = f.getAbsolutePath();
			// System.out.println("文件路径:"+f.getAbsolutePath());
			// 获取文件类型，即文件后缀名
			int start = f.getAbsolutePath().length() - 3;
			int end = f.getAbsolutePath().length();
			logger.info("现在处理到" + f.getAbsolutePath());
			// 得到文件的后缀名
			String pdf = f.getAbsolutePath().substring(start, end);
			// 判断是否是pdf格式的文件
			if (pdf.equals("pdf")) {
				String textFromPdf = "";
				try {
					textFromPdf = new PDFtoString().getTextFromPdf(f
							.getAbsolutePath());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					logger.info("读取PDF出现异常 文件名" + f.getAbsolutePath());
				}
				// System.out.println(textFromPdf);
				String str = textFromPdf;
				// System.out.println(str+"\n\n\n\n\n\n");
				// int indexOf = str.indexOf("6");

				String EnglishName = "";
				String HaseCode = "";
				String CAD = "";
				String Tax = "";
				String GST = "";
				PDDocument document = PDDocument.load(new File(absolutePath));
				int endPage = document.getNumberOfPages();
				if (str.contains("CANADA CUSTOMS CODING FORM")) {
					for (int i = 0; i < endPage; i++) {
						int startindex = str
								.indexOf("CANADA CUSTOMS CODING FORM");
						int endindex = str.indexOf("B3-3 (04)\r\nCanada");
						if (startindex != -1 && endindex != -1) {
							String onePDFtext = str.substring(startindex,
									endindex);
							while (onePDFtext
									.contains("37 Value for Duty - Valeur en Douane")) {
								if (onePDFtext
										.contains("Ligne Poids/KGM Transaction Antérieure Numéro Ligne")) {
									String substring = onePDFtext
											.substring(
													onePDFtext
															.indexOf("Ligne Poids/KGM Transaction Antérieure Numéro Ligne") + 51,
													onePDFtext
															.indexOf("27 Classification No. 28 Tariff Code 29 Quantity - Quantité"));
									// String EnglishNamePatter =
									// "[0-9]+\\ [A-Z]+";
									if(substring.indexOf(" ")!=-1){
										EnglishName = substring.substring(
												substring.indexOf(" ") + 1,
												substring.length());
									}else{
										EnglishName="";
									}
									onePDFtext = onePDFtext
											.substring(
													onePDFtext
															.indexOf("27 Classification No. 28 Tariff Code 29 Quantity - Quantité") + 59,
													onePDFtext.length());
								}
								if (onePDFtext
										.contains("No de classement Tarifaire Code VD CLMSI Taux de droit de douane Taux T.A. Taux de TPS Conversion valeur pour change")) {
									String substring = onePDFtext
											.substring(
													onePDFtext
															.indexOf("No de classement Tarifaire Code VD CLMSI Taux de droit de douane Taux T.A. Taux de TPS Conversion valeur pour change") + 116,
													onePDFtext
															.indexOf("37 Value for Duty - Valeur en Douane 38 Customs Duties 39 SIMA Assessment"));
									if(substring.indexOf(" ")!=-1){
										HaseCode = substring.substring(0,
												substring.indexOf(" "));
									}else{
										HaseCode="";
									}
									
									onePDFtext = onePDFtext
											.substring(
													onePDFtext
															.indexOf("37 Value for Duty - Valeur en Douane 38 Customs Duties 39 SIMA Assessment") + 73,
													onePDFtext.length());
								}

								if (onePDFtext
										.contains("Droits de Douane Cotisation de LMSI")) {
									int threeIndex = 0;
									int threelength = 0;
									if (onePDFtext
											.contains("21 Line 22 Description - Désignation 23 Weight/KGM 24 Previous Transaction Number")) {
										threeIndex = onePDFtext
												.indexOf("21 Line 22 Description - Désignation 23 Weight/KGM 24 Previous Transaction Number");
										threelength = "21 Line 22 Description - Désignation 23 Weight/KGM 24 Previous Transaction Number"
												.length();
									} else {
										threeIndex = onePDFtext
												.indexOf("Declaration - Déclaration 43 Deposit - Dépôt 47 Customs");
										threelength = "Declaration - Déclaration 43 Deposit - Dépôt 47 Customs"
												.length();
									}
									String substring = onePDFtext
											.substring(
													onePDFtext
															.indexOf("Droits de Douane Cotisation de LMSI") + 35,
													threeIndex);
									if(StringUtils.isNotBlank(substring)){
										while (substring.contains("  ")) {
											substring = substring
													.replace("  ", " ");
										}
										String[] split = substring.split(" ");

										CAD = split[0];
										Tax = split[1];
										GST = split[3];
									}else{
										CAD="";
										Tax="";
										GST="";
									}
									onePDFtext = onePDFtext.substring(
											threeIndex + threelength,
											onePDFtext.length());
								}
								String execlPath = absolutePath.substring(0,
										absolutePath.lastIndexOf("\\") + 1);
								if(StringUtils.isNotBlank(EnglishName)||StringUtils.isNotBlank(HaseCode)||StringUtils.isNotBlank(CAD)||StringUtils.isNotBlank(Tax)||StringUtils.isNotBlank(GST)){
									WriteExcel.writeLiXiaoFeiExcel(execlPath,
											EnglishName, HaseCode, CAD, Tax, GST);
								}
							}
						}
						if(endindex==-1){
							break;
						}
						str = str.substring(endindex + 16, str.length());
					}
					// while (onePDFtext
					// .contains("37 Value for Duty - Valeur en Douane")) {
					//
					// }

				}
				// CANADA CUSTOMS CODING FORM
				// B3-3 (04)
				// Canada

			}
		}
	}

}

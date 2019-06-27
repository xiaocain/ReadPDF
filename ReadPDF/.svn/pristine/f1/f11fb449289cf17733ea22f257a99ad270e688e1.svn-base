package com.JCEX.pdf;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.JCEX.utils.PDFtoString;
import com.JCEX.utils.WriteExcel;

public class CreatEuropeanTaxBill implements Runnable{
	private Logger logger = LoggerFactory.getLogger(getClass());
	
    private File f;
	
	public CreatEuropeanTaxBill(File f){
		this.f=f;
	}
	
	
	@Override
	public void run() {
		//--------------------------1.获取文件路径
	    String absolutePath = f.getAbsolutePath();
//	    System.out.println("文件路径:"+f.getAbsolutePath());
	    //获取文件类型，即文件后缀名
	    int start = f.getAbsolutePath().length()-3;
	    int end  = f.getAbsolutePath().length();
	    logger.info("现在处理到"+f.getAbsolutePath());
	    //得到文件的后缀名
	    String pdf = f.getAbsolutePath().substring(start, end);
	    //判断是否是pdf格式的文件
	    if(pdf.equals("pdf")){
	    	String textFromPdf="";
			try {
				textFromPdf = new PDFtoString().getTextFromPdf(f.getAbsolutePath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logger.info("读取PDF出现异常 文件名"+f.getAbsolutePath());
			}
//	 	    System.out.println(textFromPdf);
	 	    String str = textFromPdf;
//	 	    System.out.println(str+"\n\n\n\n\n\n");
//	 	    int indexOf = str.indexOf("6");
	 	    String Seperatepattern = "5\\ [0-9]+\\ +6\\ [0-9]+\\ +7\\ ";
			Pattern Seperater = Pattern.compile(Seperatepattern);
			Matcher Seperatem = Seperater.matcher(str);
			String seperate="";
			if(Seperatem.find()){
				String group = Seperatem.group();
				str=str.substring(str.indexOf(group)+group.length(), str.length());
				seperate = str.substring(0, str.indexOf(" "));
			}
			String TaxNumberpattern = "8\\ +([A-Z]{2}|[A-Z]{5})[0-9]+\\ +21";
			Pattern TaxNumberr = Pattern.compile(TaxNumberpattern);
			Matcher TaxNumberm = TaxNumberr.matcher(str);
			String TaxNumber="";
			if(TaxNumberm.find()){
				String group = TaxNumberm.group();
				group=group.substring(1, group.lastIndexOf("21"));
				TaxNumber=group.trim();
//				str=str.substring(str.indexOf(group)+1, str.length());
//				TaxNumber=str.substring(0, str.indexOf("21"));
//				TaxNumber=TaxNumber.trim();
			}
			String AddressPattern = "21\\ [A-Z]{2}[0-9A-Z]+\\ [0-9]{2}\\ [A-Za-z]{3,4}\\ [0-9]{4}\\ +[A-Z]{2}";
			Pattern Addressr = Pattern.compile(AddressPattern);
			Matcher Addressm = Addressr.matcher(str);
			String Address="";
			if(Addressm.find()){
				String group = Addressm.group();
				
				str=str.substring(str.indexOf(group)+group.length(), str.length());
				String OneAddress="";
				if(str.indexOf("22 GBP")!=-1){
					OneAddress = str.substring(0,str.indexOf("22 GBP"));
				}else if(str.indexOf("22 USD")!=-1){
					OneAddress = str.substring(0,str.indexOf("22 USD"));
				}else if(str.indexOf("22 EUR")!=-1){
					OneAddress = str.substring(0,str.indexOf("22 EUR"));
				}
				
				String TwoAddressPattern = "22\\ (GBP|USD|EUR) [0-9]+\\.[0-9]{2}";
				Pattern TwoAddressr = Pattern.compile(TwoAddressPattern);
				Matcher TwoAddressm = TwoAddressr.matcher(str);
				if(TwoAddressm.find()){
					String Twogroup = TwoAddressm.group();
					String ThreeAddressPattern = "25\\ [0-9]+\\ +26";
					Pattern ThreeAddressPatterr = Pattern.compile(ThreeAddressPattern);
					Matcher ThreeAddressPatterm = ThreeAddressPatterr.matcher(str);
					if(ThreeAddressPatterm.find()){
						String ThreeAddress = ThreeAddressPatterm.group();
						String TwoAddress = str.substring(str.indexOf(Twogroup)+Twogroup.length(), str.indexOf(ThreeAddress));
						Address=OneAddress+TwoAddress;
						Address=Address.trim();
						while(Address.contains("  ")){
							Address=Address.replace("  ", "");
						}
						Address = Address.replaceAll("[\\t\\n\\r]", "");
					}
				}
			}
			String MainOrderNumberPattern = "40 Z 74[10]\\ +[A-Z0-9\\-]+";
			Pattern MainOrderNumberr = Pattern.compile(MainOrderNumberPattern);
			Matcher MainOrderNumberm = MainOrderNumberr.matcher(str);
			String MainOrderNumber="";
			if(MainOrderNumberm.find()){
				String group = MainOrderNumberm.group();
				while(group.contains("  ")){
					group=group.replace("  ", " ");
				}
				MainOrderNumber = group.substring(9, group.length());
			}
			String TotalDtyPattern = "Total Dty:\\ +[0-9]+\\.[0-9]{2}";
			String TotalVatPattern = "Total Vat:\\ +[0-9]+\\.[0-9]{2}";
			Pattern TotalVatr = Pattern.compile(TotalVatPattern);
			Pattern TotalDtyr = Pattern.compile(TotalDtyPattern);
			Matcher TotalVatm = TotalVatr.matcher(str);
			Matcher TotalDtym = TotalDtyr.matcher(str);
			String TotalVat="";
			String TotalDty="";
			if(TotalVatm.find()){
				String group = TotalVatm.group();
				while(group.contains("  ")){
					group=group.replace("  ", " ");
				}
				TotalVat = group.substring(11, group.length());
			}
			if(TotalDtym.find()){
				String group = TotalDtym.group();
				while(group.contains("  ")){
					group=group.replace("  ", " ");
				}
				TotalDty = group.substring(11, group.length());
			}
			BigDecimal a1 = new BigDecimal(TotalVat);
			BigDecimal b1 = new BigDecimal(TotalDty);
			BigDecimal add = a1.add(b1);
			String total = String.valueOf(add);
//			try {
//				new WriteExcel().writeEuropeanTaxBillExcel(absolutePath, MainOrderNumber, seperate,TaxNumber,Address,TotalVat,TotalDty,total);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				logger.info("写入Execl出现异常"+f.getAbsolutePath());
//			}
			System.out.println("seperate...."+seperate);
			System.out.println("TaxNumber...."+TaxNumber);
			System.out.println("MainOrderNumber...."+MainOrderNumber);
			System.out.println("Total Dty:...."+TotalDty+".....Total Vat:...."+TotalVat);
			System.out.println("Address...."+Address);
			logger.info(f.getAbsolutePath()+"已处理完");
	    }
	}

	

}

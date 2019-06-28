package com.JCEX.test;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import com.JCEX.utils.PdfReplacer;
import com.itextpdf.text.DocumentException;

public class Test {
    public static void main(String[] args) throws IOException, ParseException, DocumentException {
//    	System.out.println("sdada");
//   		 PdfReplacer textReplacer = new PdfReplacer("D:/error/993822922.pdf",3);
//   			textReplacer.replaceText("5180001112433-0000", "454");
////   			textReplacer.replaceText("本科", "社会大学");
////   			textReplacer.replaceText("0755-29493863", "15112345678");
//   			textReplacer.toPdf("D:/error/9938.pdf");

//    	String fs="sdada";
//		String[] split = fs.split("");
//		String str = "sdada";
//        String[] array = str.trim().split("");
//        System.out.println(array.length);
                System.out.println("split.length = " + split.length);
//		System.out.println("split.length = " + split.length);
		String a="31 SWITCH SDSD PKG=3xCT Addressed,                32 05 33 8536699099 dadas";
		String Seperatepattern = "31\\ [^0-9]+ PKG=.+32\\ [0-9]+\\ 33\\ [0-9]+";
		Matcher matcher = Pattern.compile(Seperatepattern).matcher(a);
		while(matcher.find()){
			String group = matcher.group();
			System.out.println(group);
		}
		
    	
		
		
		
		
		
		
		
		
		
		
		
		
    	
//   			String[] findtextSplit1 = "4455sdsdds sds".split("");
//			String[] findtextSplit=new String[findtextSplit1.length];
//			if(StringUtils.isEmpty(findtextSplit1[0])){
//				for(int textindex=0;textindex<findtextSplit1.length;textindex++){
//					if(textindex+1==findtextSplit1.length){
//						break;
//					}
//					findtextSplit[textindex]=findtextSplit1[textindex+1];
//				}
//			}
//			
//			System.out.println(findtextSplit);
//   		 boolean replaceContent = replaceContent("D:/error/993822922.pdf");
//   		 System.out.println(replaceContent);
		
		
	}
}

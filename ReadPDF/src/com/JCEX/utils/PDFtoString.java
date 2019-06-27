package com.JCEX.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFtoString {
	public static void main(String[] args) throws Exception {
		String pdfPath = "D:\\error\\LiXiaoFei\\828-10377791 B3.pdf";
		PDFtoString pdfutil = new PDFtoString();
		try {
			String content = pdfutil.getTextFromPdf(pdfPath);
			// if(content.contains("ＡＷＢ番号")){
			//
			// }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getTextFromPdf(String pdfPath) throws Exception {
		// 是否排序
		boolean sort = true;
		// 开始提取页数
		int startPage = 1;
		// 结束提取页数
		int endPage = Integer.MAX_VALUE;
		String content = null;
		InputStream input = null;
		PDDocument document = null;
		File pdfFile = new File(pdfPath);
		Return: try {
			System.out.println("读取的PDF" + pdfPath);
			input = new FileInputStream(pdfFile);
			// 加载 pdf 文档
			// PDFParser parser = new PDFParser(input);
			// try{
			// parser.parse();
			// }catch(IOException ioex){
			// content="失败的pdf"+pdfPath;
			// break Return;
			// }
			//
			// document = parser.getPDDocument();
			document = PDDocument.load(new File(pdfPath));
			// 获取内容信息
			PDFTextStripper pts = new PDFTextStripper();
			pts.setSortByPosition(sort);
			endPage = document.getNumberOfPages();
			pts.setStartPage(startPage);
			pts.setEndPage(endPage);
			try {
				content = pts.getText(document);
				// String[] lines = content.split("\\r?\\n");
				// for(String line : lines) {
				// // System.out.println(line);
				// }
			} catch (Exception e) {
				throw e;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != input)
				input.close();
			if (null != document)
				document.close();
		}
		return content;
	}
}

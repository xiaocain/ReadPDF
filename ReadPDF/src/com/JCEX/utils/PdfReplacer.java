package com.JCEX.utils;
 
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;

import com.JCEX.pojo.ReplaceRegion;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import org.apache.commons.lang.StringUtils;

/**
 * 替换PDF文件某个区域内的文本
 */
public class PdfReplacer {
	private static final Logger logger = LoggerFactory.getLogger(PdfReplacer.class);
	
	private int fontSize;
	private Map<String, ReplaceRegion> replaceRegionMap = new HashMap<String, ReplaceRegion>();
	private Map<String, Object> replaceTextMap =new HashMap<String, Object>();
	private ByteArrayOutputStream output;
	private PdfReader reader;
	private PdfStamper stamper;
	private PdfContentByte canvas;
	//页数
	private int  pageNumber;
	private Font font;
	private List<ReplaceRegion> SuccessTextAndCoordinate=new ArrayList<ReplaceRegion>();
	private Map<String,List<ReplaceRegion>>  parseResult;
	
	public PdfReplacer(byte[] pdfBytes) throws DocumentException, IOException{
		init(pdfBytes);
	}
	
	public PdfReplacer(){
	}
	
	public void PdfStart(String fileName) throws IOException, DocumentException{
		FileInputStream in = null;
		try{
//			this.pageNumber=pageNumber;
			in =new FileInputStream(fileName);
			byte[] pdfBytes = new byte[in.available()];
			in.read(pdfBytes);
			init(pdfBytes);
		}finally{
			in.close();
		}
	}
	
	private void init(byte[] pdfBytes) throws DocumentException, IOException{
		logger.info("初始化开始");
		System.out.println("初始化开始");
		reader = new PdfReader(pdfBytes);
		output = new ByteArrayOutputStream();

		stamper = new PdfStamper(reader, output);
		setFont(8);

	    logger.info("初始化成功");
	}
	
	private void close() throws DocumentException, IOException{
		if(reader != null){
			reader.close();
		}
		if(output != null){
			output.close();
		}
		
		output=null;
		replaceRegionMap=null;
		replaceTextMap=null;
	}
	
	public void replaceText(float x, float y, float w,float h, String text){
		ReplaceRegion region = new ReplaceRegion(text); 	//用文本作为别名
		region.setH(h);
		region.setW(w);
		region.setX(x);
		region.setY(y);
		addReplaceRegion(region);
		this.replaceText(text, text);
	}
	
	public void replaceText(String name, String text){
		this.replaceTextMap.put(name, text);
	}
	
	/**
	 * 替换文本
	 * @throws IOException 
	 * @throws DocumentException
	 */
	private void process() throws DocumentException, IOException{
		
			parseReplaceText();
			canvas.saveState();
			System.out.println(pageNumber);
			StringBuffer a=new StringBuffer();
			for (ReplaceRegion TextAndCoordinate:
			SuccessTextAndCoordinate) {
				a.append(TextAndCoordinate.getAliasName());
				System.out.println("TextAndCoordinate.toString() = " + TextAndCoordinate.toString());
				//背景颜色
//				canvas.setColorFill(BaseColor.RED);
				canvas.setColorFill(BaseColor.WHITE);
				canvas.rectangle(TextAndCoordinate.getX(),TextAndCoordinate.getY(),TextAndCoordinate.getW(),TextAndCoordinate.getH());
			}
		    System.out.println(a.toString());
	        canvas.fill();
	        canvas.restoreState();
	        //开始写入文本 
	        canvas.beginText();
			Set<Entry<String, Object>> entries = replaceTextMap.entrySet();
			Set<Entry<String, List<ReplaceRegion>>> SuccessOrFailedentries = parseResult.entrySet();
			
			other:for (Entry<String, Object> en:
			entries) {
					if(StringUtils.isNotBlank((String)en.getValue())){
						for (Entry<String, List<ReplaceRegion>> Success:
								SuccessOrFailedentries) {
							if(en.getKey().equals(Success.getKey())){
								ReplaceRegion TextAndCoordinate = Success.getValue().get(0);
                                //设置字体并且让替换字显示 Y轴是否加减 根据自己需求调整
								canvas.setFontAndSize(font.getBaseFont(), getFontSize());
								canvas.setTextMatrix(TextAndCoordinate.getX(),TextAndCoordinate.getY()+2/*修正背景与文本的相对位置*/);
								canvas.showText((String) en.getValue());
								continue other;
							}
						}
					}
			}
			canvas.endText();
		    SuccessTextAndCoordinate.clear();
	}
	
	public void setPageNumber(int pageNumber){
		this.pageNumber=pageNumber;
	}
	
	
	/**
	 * 未指定具体的替换位置时，系统自动查找位置
	 */
	private void parseReplaceText() {
		PdfPositionParse parse = new PdfPositionParse(reader);
		Set<Entry<String, Object>> entrys = this.replaceTextMap.entrySet();
		for (Entry<String, Object> entry : entrys) {
//			if(this.replaceRegionMap.get(entry.getKey()) == null){
				parse.addFindText(entry.getKey());
//			}
		}
		
		try {
//			Map<String, ReplaceRegion> parseResult = parse.parse();
//			Set<Entry<String, ReplaceRegion>> parseEntrys = parseResult.entrySet();
//			for (Entry<String, ReplaceRegion> entry : parseEntrys) {
//				if(entry.getValue() != null){
//					this.replaceRegionMap.put(entry.getKey(), entry.getValue());
//				}
//			}
			//获取PDF页数内容 传几 convas里存储的就是第几页的数据 
		    canvas = stamper.getOverContent(pageNumber);
		    
			parseResult = parse.parse(pageNumber);
			Set<Entry<String, List<ReplaceRegion>>> entries = parseResult.entrySet();
			for (Entry<String, List<ReplaceRegion>> Result:
					entries) {
				List<ReplaceRegion> value = Result.getValue();
				for (ReplaceRegion res:
				value) {
					if(StringUtils.isNotBlank(res.getAliasName())){
						this.SuccessTextAndCoordinate.add(res);
					}
				}
			}

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
	}
 
	/**
	 * 生成新的PDF文件
	 * @param
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void toPdf() throws DocumentException, IOException{
		try{
			process();
		}catch(IOException e){
			logger.error(e.getMessage(), e);
			throw e;
		}
	}

	public void toFile(String fileName) throws DocumentException, IOException{
		FileOutputStream fileOutputStream = null;
		try{
			//PdfStamper要在输出之前关闭 并且如果是多页  必须在全部的修改完成以后才能进行关闭
			if(stamper != null){
				stamper.close();
			}
			fileOutputStream = new FileOutputStream(fileName);
			fileOutputStream.write(output.toByteArray());
			fileOutputStream.flush();
		}catch(IOException e){
			logger.error(e.getMessage(), e);
			throw e;
		}finally{
			
			if(fileOutputStream != null){
				fileOutputStream.close();
			}
			close();
		}
		logger.info("文件生成成功");
	}
	
	/**
	 * 将生成的PDF文件转换成二进制数组
	 * @return
	 * @throws DocumentException
	 * @throws IOException
	 */
	public byte[] toBytes() throws DocumentException, IOException{
		try{
			process();
			logger.info("二进制数据生成成功");
			return output.toByteArray();
		}finally{
			close();
		}
	}
	
	/**
	 * 添加替换区域
	 * @param replaceRegion
	 */
	public void addReplaceRegion(ReplaceRegion replaceRegion){
		this.replaceRegionMap.put(replaceRegion.getAliasName(), replaceRegion);
	}
	
	/**
	 * 通过别名得到替换区域
	 * @param aliasName
	 * @return
	 */
	public ReplaceRegion getReplaceRegion(String aliasName){
		return this.replaceRegionMap.get(aliasName);
	}
 
	public int getFontSize() {
		return fontSize;
	}
 
	/**
	 * 设置字体大小
	 * @param fontSize
	 * @throws DocumentException
	 * @throws IOException
	 */
	public void setFont(int fontSize) throws DocumentException, IOException{
		if(fontSize != this.fontSize){
			this.fontSize = fontSize;
//			String fileUtl = this.getClass().getResource("ARIALUNI.TTF").getPath()+'\n';
			BaseFont bf = BaseFont.createFont("D:\\demo\\src\\main\\resources\\ARIALUNI.TTF", "Identity-H", true);
		    font = new Font(bf,this.fontSize,Font.BOLD);
		}
	}
	
	public void setFont(Font font){
		if(font == null){
			throw new NullPointerException("font is null");
		}
		this.font = font;
	}

}

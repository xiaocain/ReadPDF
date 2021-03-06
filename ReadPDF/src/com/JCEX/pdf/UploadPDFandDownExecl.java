package com.JCEX.pdf;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.JCEX.pojo.WishWaybillnumer;
import com.JCEX.service.WishTrackService;
import com.JCEX.serviceImpl.WishTrackImpl;
import com.JCEX.utils.ProjectPath;
import com.JCEX.utils.ReadExcl;
import com.JCEX.utils.WriteExcel;






@Controller
public class UploadPDFandDownExecl {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
   	private WishTrackService wishTrackService;

	@RequestMapping(value="uploadWish",produces="text/html;charset=UTF-8")
	public String uploadWishExecl(@RequestParam("sfa")String file)throws Exception{
		
		WishWaybillnumer wishtrack = wishTrackService.Wishtrack(file);
	    return "csa";
	}
	
	@RequestMapping(value="uploadWishTrack",produces="text/html;charset=UTF-8")
	public ModelAndView uploadWishExecl(@RequestParam("Wishfile")MultipartFile file)throws Exception{
		long currentTimeMillis = System.currentTimeMillis();
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
//	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (file instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) file;
	            	
	            	path="D://ReadPDF/"+id+"/";
	                file1 = new File(path + file.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                file.transferTo(file1);
	            }
	            logger.info(file.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
//	    }
//	    new ReadExcl().readWishExecl(path+file.getOriginalFilename(),id);
//	    new ReadPDFMonWb().Wishpdfo(path+file.getOriginalFilename(),id);
	    String absolutePath=path+file.getOriginalFilename();
	    File excelFile = new File(absolutePath);
        int lastIndexOf = absolutePath.lastIndexOf("/");
        String OriginalFilename=absolutePath.substring(0, lastIndexOf+1);
        
//        InputStream in = new FileInputStream(excelFile); 
//		InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
//		inputStreamReader.read();

		Workbook wb = Workbook.getWorkbook(new FileInputStream(excelFile));   //获得excel文件对象
		Sheet s = wb.getSheet(0);
		WriteExcel writeExcel = new WriteExcel();
		WishTrackImpl wishTrackImpl = new WishTrackImpl();
		for(int i=1;i<s.getRows();i++){
			Cell[] row = s.getRow(i);
			System.out.println(row.length);
			if(row.length<=0){
				continue;
			}
			
			String waybillnumber = row[0].getContents();
			if(waybillnumber.equals("")||StringUtils.isEmpty(waybillnumber)){
				continue;
			}
			WishWaybillnumer wishtrack = wishTrackService.Wishtrack(waybillnumber);
			System.out.println("国家......"+wishtrack.getCountry()+"单号......"+waybillnumber+"问题......"+wishtrack.getMessage());
			String country = wishtrack.getCountry();
			if(wishtrack.getMessage().equals("系统签收推送无问题")){
				continue;
			}
			if(country.equals("DE")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, waybillnumber, "", "", "", "", "", "", "", "", "", "", "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", waybillnumber, "", "", "", "", "", "", "", "", "", "", "", "");
				}
			}else if(country.equals("ES")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", waybillnumber, "", "", "", "", "", "", "", "", "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", waybillnumber, "", "", "", "", "", "", "", "", "", "");
				}
			}else if(country.equals("NL")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", waybillnumber, "", "", "", "", "", "", "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", waybillnumber, "", "", "", "", "", "", "", "");
				}
			}else if(country.equals("IT")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", waybillnumber, "", "", "", "", "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", waybillnumber, "", "", "", "", "", "");
				}
			}else if(country.equals("GB")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", waybillnumber, "", "", "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "","", waybillnumber, "", "", "", "");
				}
			}else if(country.equals("BE")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", waybillnumber, "", "", "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", waybillnumber, "", "");
				}
			}else if(country.equals("FR")){
				if(wishtrack.getMessage().equals("系统无签收")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", "", waybillnumber, "");
				}else if(wishtrack.getMessage().equals("系统已签收但是无推送")){
					writeExcel.writeWishExcel(OriginalFilename, "", "", "", "", "", "", "", "", "", "", "", "", "", waybillnumber);
				}
			}
		}
	    
	    
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("Wishpath", path);
	    model.addAllObjects(hashMap);
	    long sdsfsad = System.currentTimeMillis();
	    long sda=sdsfsad-currentTimeMillis;
	    System.out.println(sda);
	    return model;
	}
	
	@RequestMapping(value="uploadMaBang",produces="text/html;charset=UTF-8")
	public ModelAndView uploadMaBang(@RequestParam("MaBangfile") MultipartFile file) throws Exception{
		long currentTimeMillis = System.currentTimeMillis();
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
//	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (file instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) file;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + file.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                file.transferTo(file1);
	            }
	            logger.info(file.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
//	    }
	    new ReadPDFMonWb().MaBangpdfo(path+file.getOriginalFilename(),id);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("MaBangpath", path);
	    model.addAllObjects(hashMap);
	    long sdsfsad = System.currentTimeMillis();
	    long sda=sdsfsad-currentTimeMillis;
	    System.out.println(sda);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	    
	    
	}
	
	@RequestMapping(value="/downloadMaBang")
	public void downloadMaBang(@RequestParam(value="MaBangpath")String EMSpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(EMSpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = EMSpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	/**
	 * 获取PDF内容  放入Execl文件里返回
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="upload",produces="text/html;charset=UTF-8")
	public ModelAndView upload(@RequestParam("file") MultipartFile[] file) throws Exception{
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().pdfo(path);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("path", path);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	/**
	 * 清除PDF内容 返回新PDF
	 * @param file
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="DeletePDFContent",produces="text/html;charset=UTF-8")
	public ModelAndView DeletePDFContent(@RequestParam("DeletePDFContentfile") MultipartFile[] file) throws Exception{
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    
	    new ReadPDFMonWb().deletePDFContent(path);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("downDeletePDFContentZippath", path);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	
	
	@RequestMapping(value="uploadEMS",produces="text/html;charset=UTF-8")
	public ModelAndView uploadEMS(@RequestParam("EMSfile") MultipartFile file) throws Exception{
		long currentTimeMillis = System.currentTimeMillis();
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
//	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (file instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) file;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + file.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                file.transferTo(file1);
	            }
	            logger.info(file.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
//	    }
	    new ReadPDFMonWb().EMSpdfo(path+file.getOriginalFilename(),id);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("EMSpath", path);
	    model.addAllObjects(hashMap);
	    long sdsfsad = System.currentTimeMillis();
	    long sda=sdsfsad-currentTimeMillis;
	    System.out.println(sda);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	    
	    
	}
	
	@RequestMapping(value="/downloadWish")
	public void downloadWish(@RequestParam(value="Wishpath")String Wishpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(Wishpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = Wishpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="YaoYeupload",produces="text/html;charset=UTF-8")
	public ModelAndView YaoYeupload(@RequestParam("YaoYefile") MultipartFile[] file) throws Exception{
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().YaoYepdfo(path);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("YaoYepath", path);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	@RequestMapping(value="/downloadYaoYe")
	public void downloadYaoYe(@RequestParam(value="YaoYepath")String EuropeanTaxBillpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(EuropeanTaxBillpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = EuropeanTaxBillpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	
	@RequestMapping(value="uploadEuropeanTaxBill",produces="text/html;charset=UTF-8")
	public ModelAndView EuropeanTaxBillupload(@RequestParam("EuropeanTaxBillfile") MultipartFile[] file) throws Exception{
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().EuropeanTaxBillpdfo(path);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("EuropeanTaxBillpath", path);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	
	
	@RequestMapping(value="/downloadEMS")
	public void downloadEMS(@RequestParam(value="EMSpath")String EMSpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(EMSpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = EMSpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="/downloadEuropeanTaxBill")
	public void downloadEuropeanTaxBill(@RequestParam(value="EuropeanTaxBillpath")String EuropeanTaxBillpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(EuropeanTaxBillpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = EuropeanTaxBillpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="/download")
	public void download(@RequestParam(value="path")String path,HttpServletResponse response){
//		System.out.println(path);
		logger.info(path);
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = path+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="/downloadCanadaList")
	public void downloadCanadaListRsponse(@RequestParam(value="CanadaListpath")String CanadaListpath,HttpServletResponse response){
//		System.out.println(path);
		logger.info(CanadaListpath);
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = CanadaListpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="/downloadPCA")
	public void downloadPCA(@RequestParam(value="PCApath")String PCApath,HttpServletResponse response){
//		System.out.println(path);
		logger.info(PCApath);
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = PCApath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	
	@RequestMapping(value="/downloadPDF")
	public void downloadPartitionPdf(@RequestParam(value="path")String path,HttpServletResponse response){
//		System.out.println(path);
		logger.info(path);
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = path+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	
	@RequestMapping(value="/downloadB2CExecl")
	public void downloadB2CExecl(@RequestParam(value="B2Cpath")String path,HttpServletResponse response){
//		System.out.println(path);
		logger.info(path);
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = path+"B2CExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
	@RequestMapping(value="SHupload",produces="text/html;charset=UTF-8")
	public ModelAndView uploadSH(@RequestParam("SHfile") MultipartFile[] file) throws Exception{
		String SHpath=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
        System.out.println("s4da5");
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	SHpath="D://ReadPDF/"+id+"//";
	                file1 = new File(SHpath + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().SHpdfo(SHpath);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("SHpath", SHpath);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	@RequestMapping(value="DJupload",produces="text/html;charset=UTF-8")
	public ModelAndView uploadDJ(@RequestParam("DJfile") MultipartFile file) throws Exception{
		String DJpath=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
        String originalFilename=null;
//	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (file instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) file;
	            	
	            	DJpath="D://ReadExecl/"+id+"//";
	                file1 = new File(DJpath + file.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                file.transferTo(file1);
	            }
	            logger.info(file.getOriginalFilename());
	            originalFilename = file.getOriginalFilename();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
//	    }
	    new ReadPDFMonWb().DJpdfo(DJpath+file.getOriginalFilename(),id);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("DJpath", DJpath);
//	    model.addObject(dJpdfo);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	
	@RequestMapping(value="B2CExecl",produces="text/html;charset=UTF-8")
	public ModelAndView B2CExecl(@RequestParam("B2Cfile") MultipartFile[] file) throws Exception{
		String SHpath=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	SHpath="D://ReadPDF/"+id+"//";
	                file1 = new File(SHpath + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().B2CExecl(SHpath);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("B2Cpath", SHpath);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	@RequestMapping(value="PCAupload",produces="text/html;charset=UTF-8")
	public ModelAndView uploadPCA(@RequestParam("PCAfile") MultipartFile file) throws Exception{
		String PCApath=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
        String originalFilename=null;
	    File file1 ;
	    String name="";
	        try {
	            if (file instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) file;
	            	
	            	PCApath="D://ReadExecl/"+id+"//";
	                file1 = new File(PCApath + file.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
	                file.transferTo(file1);
	            }
	            logger.info(file.getOriginalFilename());
	            originalFilename = file.getOriginalFilename();
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    new ReadPDFMonWb().PCApdfo(PCApath+file.getOriginalFilename(),id);
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("PCApath", PCApath);
//	    model.addObject(dJpdfo);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	@RequestMapping(value="LiXiaoFeiUpload",produces="text/html;charset=UTF-8")
	public ModelAndView LiXiaoFeiUpload(@RequestParam("LiXiaoFeifile") MultipartFile[] file) throws Exception{
		String path=null;
        Date date = new Date();
        SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
        int nextInt = new Random().nextInt(100);
        String format = smft.format(date);
        String id=format+nextInt;
        System.out.println(id);
	    for(MultipartFile f:file){

	        File file1 ;
	        String name="";
	        try {
	            if (f instanceof CommonsMultipartFile) {
	                //转换成这个对象，然后我们需要通过里面的FileItem来获得相对路径
	            	CommonsMultipartFile f2 = (CommonsMultipartFile) f;
	            	
	            	path="D://ReadPDF/"+id+"//";
	                file1 = new File(path + f.getOriginalFilename());
	                if(!file1.exists()){
	                	file1.mkdirs();
	                }
//	                file1.createNewFile();
	                f.transferTo(file1);
	            }
	            logger.info(f.getOriginalFilename());
	        }catch (Exception e){
	            e.printStackTrace();
	        }
	    }
	    new ReadPDFMonWb().LiXiaoFeipdfo(path);
//	    request.getRequestDispatcher("/html/MyHtml.html").forward(request, response);
//	    attr.addFlashAttribute("id", path);
//	    return "redirect:/html/MyHtml.html?"+path;
	    ModelAndView model=new ModelAndView("MyJsp");
	    HashMap<String, String> hashMap = new HashMap<String,String>();
	    hashMap.put("downloadLiXiaoFeipath", path);
	    model.addAllObjects(hashMap);
	    return model;
//	    return "{\"id\", \""+path+"\"}";
	}
	
	@RequestMapping(value="/downloadLiXiaoFei")
	public void downloadLiXiaoFei(@RequestParam(value="downloadLiXiaoFeipath")String EuropeanTaxBillpath,HttpServletResponse response) throws IOException{
//		System.out.println(path);
		logger.info(EuropeanTaxBillpath);
		
        
		    Date date = new Date();
            SimpleDateFormat smft=new SimpleDateFormat("HHmmss");
            String format = smft.format(date);
		    String filepath = EuropeanTaxBillpath+"PDFtoExcl.xls";
			File file = new File(filepath);
			InputStream inputStream = null;
			OutputStream outputStream = null;
			byte[] b= new byte[1024];
			int len = 0;
			try {
				inputStream = new FileInputStream(file);
				outputStream = response.getOutputStream();
				response.setContentType("application/force-download");
				String filename = file.getName();
				System.out.println(filename);
				response.addHeader("Content-Disposition","attachment; filename=" + URLEncoder.encode(format+filename, "UTF-8"));
				response.setContentLength( (int) file.length( ) );
				
				while((len = inputStream.read(b)) != -1){
					outputStream.write(b, 0, len);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}finally{
				if(inputStream != null){
					try {
						inputStream.close();
						inputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				if(outputStream != null){
					try {
						outputStream.close();
						outputStream = null;
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
	}
	
}

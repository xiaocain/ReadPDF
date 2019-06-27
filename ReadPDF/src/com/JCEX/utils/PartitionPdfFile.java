package com.JCEX.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

public class PartitionPdfFile { 
    public static void main(String[] args) {
    	String filepath="D://yundanPdf/992687124.pdf";
    	SHfromtoendPdfFile(filepath,"D://yundanPdf/9926871240000.pdf",1,16);
//		SHpartitionPdfFile(filepath);
	}
	
	
	//合并PDF
	public static void mergePdfFiles(String[] files, String savepath)  
    {  
        try   
        {  
            Document document = new Document(new PdfReader(files[0]).getPageSize(1));  
              
            PdfCopy copy = new PdfCopy(document, new FileOutputStream(savepath));  
              
            document.open();  
              
            for(int i=0; i<files.length; i++)  
            {  
                PdfReader reader = new PdfReader(files[i]);  
                  
                int n = reader.getNumberOfPages();  
  
                for(int j=1; j<=n; j++)  
                {  
                    document.newPage();   
                    PdfImportedPage page = copy.getImportedPage(reader, j);  
                    copy.addPage(page);  
                }  
            }  
              
            document.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch(DocumentException e) {  
            e.printStackTrace();  
        }  
    }  
	
	
	public static void SHpartitionPdfFile(String filepath,int N)  
    {  
        Document document = null;  
        PdfCopy copy = null;  
          
        try   
        {  
            PdfReader reader = new PdfReader(filepath);  
              
            int n = reader.getNumberOfPages();  
              
            if(n < N)  
            {  
                System.out.println("The document does not have " + N + " pages to partition !");  
                return;  
            }  
              
            int size = n/N;           
            String staticpath = filepath.substring(0, filepath.lastIndexOf("\\")+1); 
            staticpath=staticpath+"Partition/";
            File file=new File(staticpath);
            if(!file.exists()){
            	file.mkdirs();
            }
            String savepath = null;  
            ArrayList<String> savepaths = new ArrayList<String>();  
            for(int i=1; i<=N; i++)  
            {  
                if(i < 10)  
                {  
                    savepath = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.length()-4);  
                    savepath = staticpath + savepath + "-00" + i + ".pdf";  
                    savepaths.add(savepath);                      
                }  
                else  
                {  
                    savepath = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.length()-4);  
                    savepath = staticpath + savepath + "-0"+i + ".pdf";  
                    savepaths.add(savepath);  
                }  
            }             
              
            for(int i=0; i<N-1; i++)  
            {  
                document = new Document(reader.getPageSize(1));  
                copy = new PdfCopy(document, new FileOutputStream(savepaths.get(i)));             
                document.open();  
                for(int j=size*i+1; j<=size*(i+1); j++)  
                {  
                    document.newPage();   
                    PdfImportedPage page = copy.getImportedPage(reader, j);  
                    copy.addPage(page);  
                }  
                document.close();  
            }  
              
              
            document = new Document(reader.getPageSize(1));  
            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(N-1)));  
            document.open();  
            for(int j=size*(N-1)+1; j<=n; j++)  
            {  
                document.newPage();   
                PdfImportedPage page = copy.getImportedPage(reader, j);  
                copy.addPage(page);  
            }  
            document.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch(DocumentException e) {  
            e.printStackTrace();  
        }  
    }
	
	//直接拆分整个PDF
	public static void partitionPdfFile(int N,String filepath,String staticpath,ArrayList<Integer> countindex,List<String> HAWB,List<String> AWB)  
    {  
        Document document = null;  
        PdfCopy copy = null;  
        File file = new File(staticpath);
        if(!file.exists()){
        	file.mkdirs();
        }
        try   
        {  
            PdfReader reader = new PdfReader(filepath);  
              
            int n = reader.getNumberOfPages();  
              
            if(n < N)  
            {  
                System.out.println("The document does not have " + N + " pages to partition !");  
                return;  
            }  
              
            int size = n/N;           
            //保存路径  保存在本目录下
//            String staticpath = filepath.substring(0, filepath.lastIndexOf("\\")+1);              
            String savepath = null;  
            ArrayList<String> savepaths = new ArrayList<String>();  
            for(int i=0; i<N; i++)  
            {  
            	String AWBstring = AWB.get(i);
            	String HAWBstring = HAWB.get(i);
            	if(!AWBstring.equals("0")){
            		savepaths.add(staticpath+AWBstring+".pdf");
            	}else if(!HAWBstring.equals("0")){
            		savepaths.add(staticpath+HAWBstring+".pdf");
            	}else{
            		savepaths.add("0");
            	}
//                if(i < 10)  
//                {  
//                    savepath = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.length()-4);
////                    System.out.println(savepath);
//                    savepath = staticpath + savepath + "0" + i + ".pdf";  
////                    System.out.println(savepath);
//                    savepaths.add(savepath);                      
//                }  
//                else  
//                {  
//                    savepath = filepath.substring(filepath.lastIndexOf("\\")+1, filepath.length()-4);  
//                    savepath = staticpath + savepath + i + ".pdf";  
//                    System.out.println(savepath);
//                    savepaths.add(savepath);  
//                }  
            }             
            other1:for(int i=0; i<N-1; i++)  
            {  
                document = new Document(reader.getPageSize(1));  
                String SavepathString = savepaths.get(i);
                if(SavepathString.equals("0")){
                	continue;
                }
                for(int l=0;l<countindex.size();l++){
                	Integer integer = countindex.get(l);
                	if(integer==i||integer+1==i){
                		continue other1;
                	}
                }
                copy = new PdfCopy(document, new FileOutputStream(SavepathString));             
                document.open();  
                for(int j=size*i+1; j<=size*(i+1); j++)  
                {  
                    document.newPage();   
                    PdfImportedPage page = copy.getImportedPage(reader, j);  
                    copy.addPage(page);  
                }  
                document.close();  
            }
            
	        for(int l=0;l<countindex.size();l++){
	            Integer integer = countindex.get(l);
	            String string = savepaths.get(integer);
	            String filed = string.substring(string.lastIndexOf("/")+1, string.length());
	    		fromtoendPdfFile(filepath,filed,integer+1,integer+2);
//	            if(integer==i||integer+1==i){
//	            		continue other1;
//	            }
	        }
              
    		
    		
            document = new Document(reader.getPageSize(1));  
            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(N-1)));  
            document.open();  
            for(int j=size*(N-1)+1; j<=n; j++)  
            {  
                document.newPage();   
                PdfImportedPage page = copy.getImportedPage(reader, j);  
                copy.addPage(page);  
            }  
            document.close();  
  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch(DocumentException e) {  
            e.printStackTrace();  
        }  
    }
	
	//根据页数来截取PDF
	public static void fromtoendPdfFile(String pdfFile,  
            String newFile, int from, int end) {  
        Document document = null;  
        PdfCopy copy = null;          
        try {  
            PdfReader reader = new PdfReader(pdfFile);            
            int n = reader.getNumberOfPages();            
            if(end==0){  
                end = n;  
            }  
            ArrayList<String> savepaths = new ArrayList<String>();  
            String staticpath = pdfFile.substring(0, pdfFile.lastIndexOf("\\")+1);  
            String savepath = staticpath+"/PartitionPDF/"+ newFile;  
            savepaths.add(savepath);  
            document = new Document(reader.getPageSize(1));  
            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(0)));  
            document.open();  
            for(int j=from; j<=end; j++) {  
                document.newPage();   
                PdfImportedPage page = copy.getImportedPage(reader, j);  
                copy.addPage(page);  
            }  
            document.close();  
            
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch(DocumentException e) {  
            e.printStackTrace();  
        }  
    }  
    
	
	//根据页数来截取PDF
		public static void SHfromtoendPdfFile(String pdfFile,  
	            String newFile, int from, int end) {  
	        Document document = null;  
	        PdfCopy copy = null;          
	        try {  
	            PdfReader reader = new PdfReader(pdfFile);            
	            int n = reader.getNumberOfPages();            
	            if(end==0){  
	                end = n;  
	            }  
	            ArrayList<String> savepaths = new ArrayList<String>();  
	            String staticpath = pdfFile.substring(0, pdfFile.lastIndexOf("\\")+1);  
	            String savepath = staticpath+"PartitionPDF\\"+newFile;  
//	            String savepath=newFile;
	            String substring = savepath.substring(0,savepath.lastIndexOf("\\"));
	            File file=new File(substring);
	            if(!file.exists()){
	            	file.mkdirs();
	            }
	            savepaths.add(savepath);  
	            document = new Document(reader.getPageSize(1));  
	            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(0)));  
	            document.open();  
	            for(int j=from; j<=end; j++) {  
	                document.newPage();   
	                PdfImportedPage page = copy.getImportedPage(reader, j);  
	                copy.addPage(page);  
	            }  
	            document.close();  
	            SHpartitionPdfFile(savepath,end);
	        } catch (IOException e) {  
	            e.printStackTrace();  
	        } catch(DocumentException e) {  
	            e.printStackTrace();  
	        }  
	    }  
	
}

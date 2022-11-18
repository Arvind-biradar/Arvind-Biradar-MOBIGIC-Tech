package com.mobigic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadUtil {

	private final String upload_dir="C:\\Users\\Arvind Biradar\\Documents\\workspace-spring-tool-suite-4-4.15.3.RELEASE\\MERN\\src\\main\\resources\\static\\image";
	 private boolean UploadFile(MultipartFile file) {
		 boolean f=false;
		 
		 
		 
		 System.out.println(file.getName());
		 System.out.println(file.getOriginalFilename());
		 System.out.println(file.getContentType());
		 System.out.println(file.getResource());
		 try {
			 InputStream is=file.getInputStream();
			byte []data=new byte[is.available()];
			is.read(data);
			
			FileOutputStream os=new FileOutputStream(upload_dir+File.separator+file.getOriginalFilename());
		
		 os.write(data);
		 os.close();
		 f=true;
		 
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		}
		 
		 
		 return f;
	 }
	
}

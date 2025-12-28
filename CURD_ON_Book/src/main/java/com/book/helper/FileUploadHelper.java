package com.book.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	public static String UPLOAD_DIR = "D:\\STS workSpace (D)\\Git\\repository\\CURD_ON_Book\\src\\main\\resources\\static\\Image";
	
	public boolean fileUpload(MultipartFile file) {
		boolean b=false;
		try {
			
			//Old stream API method
			//Read
			InputStream is = file.getInputStream();
			byte[] data = new byte[is.available()];
			is.read(data);
			//write
			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
			fos.write(data);
			
			fos.flush();
			fos.close();
			b=true;
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
}

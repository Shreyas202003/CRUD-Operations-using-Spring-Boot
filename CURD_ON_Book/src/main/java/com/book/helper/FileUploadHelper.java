package com.book.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

	// Static file path..
//	public static String UPLOAD_DIR = "D:\\STS workSpace (D)\\Git\\repository\\CURD_ON_Book\\src\\main\\resources\\static\\Image";

	// Dynamic file path
	public final String UPLOAD_DIR;

    public FileUploadHelper() throws Exception {
        File dir = new ClassPathResource("static/image/").getFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        this.UPLOAD_DIR = dir.getAbsolutePath();
    }
	


	public boolean fileUpload(MultipartFile file) {
		boolean b = false;
		try {

			// Old stream API method
			// Read
//			InputStream is = file.getInputStream();
//			byte[] data = new byte[is.available()];
//			is.read(data);
//			//write
//			FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+file.getOriginalFilename());
//			fos.write(data);
//			
//			fos.flush();
//			fos.close();

			// Using Stream API (NIO Package)
			Files.copy(file.getInputStream(), Paths.get(UPLOAD_DIR + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);

			b = true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}

}

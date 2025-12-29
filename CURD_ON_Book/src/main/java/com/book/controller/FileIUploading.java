package com.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.book.helper.FileUploadHelper;

@RestController
@RequestMapping("/file")
public class FileIUploading {

	@Autowired
	private FileUploadHelper fileHelper;
	
	@PostMapping("/fileupload")
	public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file) {

		//Check the file is Empty
		if(file.isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("compulsory file needs to be uploaded");
		}
		
		//check the file is JPEG
		if(!file.getContentType().equals("image/jpeg")) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File content should be JPEG");
		}
		
		boolean bool = fileHelper.fileUpload(file);
		if(bool) {
//			return ResponseEntity.ok().body("File uploaded successfully");
			
			//returning in the form of uri
			return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload the file");
	}

}

package com.spring.instinctblogs.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	public ResponseEntity<String> fileUpload(MultipartFile file) {
		try {
			System.out.println("File Upload Controller");
			String UPLOAD_DIR="/image";
			Path path=Paths.get(UPLOAD_DIR,file.getOriginalFilename());
			Files.write(path,file.getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>("Invalid File Format",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>("File uploaded!!",HttpStatus.OK);
	}
}

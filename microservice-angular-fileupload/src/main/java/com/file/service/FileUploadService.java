package com.file.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
	
	private final Path rootLocation = Paths.get("C:\\Users\\Ananth\\Desktop\\fileupload");
	 public void store(MultipartFile file) {
	  try {
	   System.out.println(file.getOriginalFilename());
	   System.out.println(rootLocation.toUri());
	   Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
	  } catch (Exception e) {
	   throw new RuntimeException("FAIL!");
	  }
	 }

}

package com.file.controller;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.file.service.FileUploadService;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RestController
@RequestMapping("/file")
public class FileUploadController {
	
	@Autowired
	FileUploadService fileService;
	

	@PostMapping("/upload/picture")
	ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		String message="";
		try {		
		fileService.store(file);
		message="You successfully uploaded " + file.getOriginalFilename() + "!";
		return new ResponseEntity<String>(message, HttpStatus.CREATED);
		}
		catch(Exception e) {
			message="Fail to upload Profile Picture " + file.getOriginalFilename() + "!";
			return new ResponseEntity<String>(message,HttpStatus.EXPECTATION_FAILED);
		}
	}

}

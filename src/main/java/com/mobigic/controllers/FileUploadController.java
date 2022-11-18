package com.mobigic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.function.EntityResponse;

import com.mobigic.entities.Filedata;
import com.mobigic.payloads.FileDataDto;
import com.mobigic.services.FileUploadService;

@CrossOrigin
@RestController
@RequestMapping("/fileupload")
public class FileUploadController {
	
	@Autowired
	private FileUploadService fus;
	@PostMapping
	public ResponseEntity<String> upload(@ModelAttribute FileDataDto file){

		System.out.println(file.getUserid()+"  "+file.getFile().getOriginalFilename());
		if(file.getFile().isEmpty()) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Must Contain file");
		}else
			fus.savefile(file);
		
		
		return ResponseEntity.ok("Wokiiingg");
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> findOwnersApartments(@PathVariable("id") int id) {
		Filedata f=new Filedata();
//		f.getFilename()
		
		System.out.println(fus.getAllListByUser(id).toString());
		return ResponseEntity.ok(fus.getAllListByUser(id));
	}

}

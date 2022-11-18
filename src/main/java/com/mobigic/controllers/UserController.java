package com.mobigic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mobigic.entities.User;
import com.mobigic.payloads.UserDto;
import com.mobigic.services.UserService1;
import com.mobigic.exceptions.ResourceNotFoundException;


@CrossOrigin
@RestController
@RequestMapping("/customers")
public class UserController {

	@Autowired private UserService1 cservice;
	//create user
	@PostMapping
	public ResponseEntity<?> save(@RequestBody UserDto dto) {	
		System.out.println("User Addd :"+dto.getUsername()+" "+dto.getPassword()+" "+dto.toString());
		if(cservice.checkExist(dto.getUsername())) {
			
			return ResponseEntity.badRequest().body("Email already registered");
		}
		cservice.createUser(dto);
	
		return ResponseEntity.ok("user registered successfully");
	}
	
	
	
	//get single user
//	@GetMapping("{id}")
//	public ResponseEntity<?> findById(@PathVariable("id") String id) {
//		
//		return ResponseEntity.ok(cservice.);
//		
//
//		
//	}
	
	@PostMapping("/validate")
	public ResponseEntity<?> validateUser(@RequestBody UserDto dto) throws ResourceNotFoundException {
		System.out.println(dto);
		User cust=cservice.validate(dto);
		System.out.println(cust.getId()+" "+cust.getPassword()+" "+cust.getUsername());
		if(cust!=null) {
			return ResponseEntity.ok(new UserDto(cust.getId(),cust.getUsername(), cust.getPassword()));
		}
				return ResponseEntity.badRequest().body("Invalid username or password");
		
	}
	
	
}
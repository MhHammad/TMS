package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.AdminServiceImpl;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins="http://localhost:3000")
public class AdminController {

	public AdminController() {
		System.out.println("In ctor " + getClass());
	}

	@Autowired
	private AdminServiceImpl service;

//	req handling method to authenticate user as : ADMIN
	@GetMapping("/login/{email}/{pwd}")
	public ResponseEntity<?> authenticateAdmin(@PathVariable String email, @PathVariable String pwd) {
		System.out.println("In authenticateAdmin: " + email + " " + pwd);
		return ResponseEntity.ok(service.authenticateAdmin(email, pwd));
		
//		try {
//			return ResponseEntity.ok(service.authenticateAdmin(email, pwd));
//		} catch (Exception e) {
//			System.out.println("Error in authenticateAdmin " + e);
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}

//	req handling method to get details of all the orders
	@GetMapping
	public ResponseEntity<?> getAllOrders() {

		service.getAllOrders().forEach(System.out::println);
		return ResponseEntity.ok(service.getAllOrders());

	}

}

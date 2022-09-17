package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.HomeMakerDTO;
import com.app.service.IHomeMakerService;

@RestController
@RequestMapping("/api/homemakers")
@CrossOrigin
public class HomeMakerController {

	@Autowired
	private IHomeMakerService service;

	public HomeMakerController() {
		System.out.println("In ctor of " + getClass());
	}

//	to authenticate user as : HomeMaker
	@GetMapping("/login/{email}/{pwd}")
	public ResponseEntity<?> authenticateHomeMaker(@PathVariable String email, @PathVariable String pwd) {
//		if no error, httpStatus code -> ok
//		in case of  any error, it is handled in service layer and accordingly httpStatus code is sent (Global Exc Handler)

		return ResponseEntity.ok(service.authenticateHomeMaker(email, pwd));
//		try {
//			return ResponseEntity.ok(service.authenticateHomeMaker(email, pwd));
//
//		} catch (Exception e) {
//			System.out.println("err in Authenticate HomeMaker  " + e);
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//		}
	}

//	to return list of all HomeMakers
	@GetMapping
	public ResponseEntity<?> getAllHomeMakers() {
		System.out.println("In getAllHomeMakers() ");
		return ResponseEntity.ok(service.getAllHomeMakers());
	}

//	to return HomeMaker details by ID
	@GetMapping("{HomeMakerId}")
	public ResponseEntity<?> getHomeMakerById(@PathVariable int HomeMakerId) {
		return ResponseEntity.ok(service.getHomeMakerById(HomeMakerId));
	}

//	to delete a HomeMaker by ID
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteHomeMakerById(@PathVariable int id) {
		return ResponseEntity.ok(service.deleteHomeMakerById(id));
	}

//	to signup a new HomeMaker
	@PostMapping("/signup")
	public ResponseEntity<?> signupNewHomeMaker(@RequestBody HomeMakerDTO homeMakerDTO) {
		return ResponseEntity.ok(service.signUpHomeMaker(homeMakerDTO));
	}

//	to update HomeMaker details
	@PutMapping
	public ResponseEntity<?> updateHomeMakerDetails(@RequestBody HomeMakerDTO homeMakerDTO) {
		System.out.println("ID: " + homeMakerDTO.getId());
		return ResponseEntity.ok(service.updateHomeMakerDetails(homeMakerDTO));
	}

}

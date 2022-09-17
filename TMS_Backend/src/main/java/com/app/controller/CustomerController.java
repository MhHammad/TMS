package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import com.app.dto.CustomerDTO;
import com.app.dto.ResponseDTO;
import com.app.service.ICustomerService;

@RestController
@RequestMapping("/api/customers")
@CrossOrigin
public class CustomerController {

	@Autowired
	private ICustomerService service;

	public CustomerController() {
		System.out.println("In ctor of " + getClass());
	}

//	to authenticate user as a: Customer
	@GetMapping("/login/{email}/{pwd}")
	public ResponseEntity<?> authenticateCustomer(@PathVariable String email, @PathVariable String pwd) {

		System.out.println("In Authenticate Customer: " + email + " " + pwd);
//		if no error, httpStatus code -> ok
//		in case of  any error, it is handled in service layer and accordingly httpStatus code is sent (Global Exc Handler)
		return ResponseEntity.ok(service.findByEmailAndPassword(email, pwd));
	}

//	to signup a new customer
	@PostMapping("/signup")
	public ResponseEntity<?> signupNewCustomer(@RequestBody CustomerDTO custDTO) {

		System.out.println("In customer signup" + custDTO);
		CustomerDTO newCustomer = service.signUpCustomer(custDTO);
		if (newCustomer == null) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		}
		return ResponseEntity.ok(newCustomer);
//		return ResponseEntity.ok(new ResponseDTO<	>(newCustomer));
	}

//	to return list of all Customers
	@GetMapping
	public ResponseEntity<?> getAllCustomers() {

		System.out.println("In getAllCustomers() ");
		return ResponseEntity.ok(service.getAllCustomers());
	}

	// to return Customer details by ID
	@GetMapping("{CustId}")
	public ResponseEntity<?> getCustById(@PathVariable int CustId) {

		return ResponseEntity.ok(service.getCustById(CustId));
	}

//	to delete a Customer by ID
	@DeleteMapping("{id}")
	public ResponseEntity<?> deleteCustById(@PathVariable int id) {

		return ResponseEntity.ok(new ResponseDTO<>(service.deleteCustById(id)));
	}

//	to save a Customer received as json object from front end 
	@PostMapping()
	public ResponseEntity<?> saveCustomerDetails(@RequestBody CustomerDTO Cust) {

		return ResponseEntity.ok(service.saveCustDetails(Cust));
	}

//	to update Customer details
	@PutMapping
	public ResponseEntity<?> updateCustDetails(@RequestBody CustomerDTO Cust) {

		return ResponseEntity.ok(service.updateCustDetails(Cust));
	}

//	to add homemaker
	@GetMapping("/add-homemaker/{custId}/{hmId}")
	public ResponseEntity<?> addMyHomeMaker(@PathVariable String hmId, @PathVariable String custId) {

		return ResponseEntity.ok(service.addMyHomeMaker(Integer.parseInt(custId), Integer.parseInt(hmId)));
	}

//	to get homeMaker details for a customer
	@GetMapping("/getMyHomeMaker/{custId}")
	public ResponseEntity<?> getMyHomeMaker(@PathVariable String custId) {

		return ResponseEntity.ok(service.getMyHomeMaker(Integer.parseInt(custId)));
	}

//	to remove a homeMaker for a customer
	@GetMapping("/removeMyHomeMaker/{custId}")
	public ResponseEntity<?> removeMyHomeMaker(@PathVariable String custId) {

		return ResponseEntity.ok(service.removeMyHomeMaker(Integer.parseInt(custId)));
	}

//	to add a package  plan and plan type for a customer
	@PutMapping("/updatePackage/{planType}/{pack}")
	public ResponseEntity<?> updatePackage(@PathVariable String planType, @PathVariable String pack,
			@RequestBody CustomerDTO customerDTO) {

		return ResponseEntity.ok(service.updatePackage(planType, pack, customerDTO));
	}
}

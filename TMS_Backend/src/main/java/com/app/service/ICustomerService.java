package com.app.service;

import java.util.List;

import com.app.dto.CustomerDTO;
import com.app.dto.HomeMakerDTO;
import com.app.pojos.Customer;

public interface ICustomerService {
	
//	to authenticate user as a: Customer
	CustomerDTO findByEmailAndPassword(String em, String pass);	
//	to signup a new customer
	CustomerDTO signUpCustomer(CustomerDTO customer);	
//	to get details of all Customers
	List<Customer> getAllCustomers();
//	to get a Customer details by id
	CustomerDTO getCustById(int id);	
//	to delete a Customer
	String deleteCustById(int id);	
//	to save a Customer received as json object from frontend
	CustomerDTO saveCustDetails(CustomerDTO customer);	
//	to update details of a Customer
	CustomerDTO updateCustDetails(CustomerDTO detachedCustomer);	
//	to add a homeMaker for a customer
	CustomerDTO addMyHomeMaker(int hmId, int custId);
//	to get homeMaker details for a customer
	HomeMakerDTO getMyHomeMaker(int custId);
//	to remove a homeMaker for a customer
	String removeMyHomeMaker(int custId);	
//	to add a package  plan and plan type for a customer
	CustomerDTO updatePackage(String planType, String pack, CustomerDTO customer);
}

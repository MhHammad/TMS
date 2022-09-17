package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CustomerRepository;
import com.app.dao.HomeMakerRepository;
import com.app.dto.CustomerDTO;
import com.app.dto.HomeMakerDTO;
import com.app.pojos.Customer;
import com.app.pojos.HomeMaker;
import com.app.pojos.PlanPackage;
import com.app.pojos.PlanType;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
	@Autowired
	private CustomerRepository customerRepo;

	@Autowired
	private HomeMakerRepository homeMakerRepo;

//	dep : model mapper for mapping dto --- entity
	@Autowired
	private ModelMapper mapper;

//	to authenticate user as a: Customer
	@Override
	public CustomerDTO findByEmailAndPassword(String em, String pass) {

		Customer persistentCustomer = customerRepo.findByEmailAndPassword(em, pass)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
		// map entity -> DTO
		return mapper.map(persistentCustomer, CustomerDTO.class);
	}

//	signup a new customer
	@Override
	public CustomerDTO signUpCustomer(CustomerDTO customer) {
//		check if customer already exists, if not ->  save customer else -> return null
//		map DTO -> entity
		Customer transientCustomer = mapper.map(customer, Customer.class);
		if (customerRepo.findByEmail(transientCustomer.getEmail()) != null) {
//			Customer exist with this email
			return null;
		}

		Customer persistentCustomer = customerRepo.save(transientCustomer);
//		map entity -> DTO
		return mapper.map(persistentCustomer, CustomerDTO.class);
	}

//	to get list of all customers
	@Override
	public List<Customer> getAllCustomers() {

		return customerRepo.findAll();
	}

//	to retrieve a customer by ID
	@Override
	public CustomerDTO getCustById(int id) {
		Customer persistentCustomer = customerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer with ID: " + id + " does not exist!!!"));
		return mapper.map(persistentCustomer, CustomerDTO.class);
	}

//	to delete  a customer by ID
	@Override
	public String deleteCustById(int id) {
		String mg = "Customer with ID: " + id + " does not exist!!!";

		if (customerRepo.existsById(id)) {
			customerRepo.deleteById(id);
			mg = "Customer with ID: " + id + " deleted successfully";
		}
		return mg;
	}

//	to save customer details
	@Override
	public CustomerDTO saveCustDetails(CustomerDTO Cust) {

//		map DTO -> entity
		Customer transientCustomer = mapper.map(Cust, Customer.class);
		Customer persistentCustomer = customerRepo.save(transientCustomer);
//		map entity -> DTO
		return mapper.map(persistentCustomer, CustomerDTO.class);
	}

//	to update customer details
	@Override
	public CustomerDTO updateCustDetails(CustomerDTO detachedCust) {

//		map DTO -> entity
		Customer transientCustomer = mapper.map(detachedCust, Customer.class);
		Customer persistentCustomer = customerRepo.save(transientCustomer);
//		map entity -> DTO
		return mapper.map(persistentCustomer, CustomerDTO.class);

	}

//	to add a homeMaker for a customer
	@Override
	public CustomerDTO addMyHomeMaker(int custId, int hmId) {
//		find customer by calling getCustById() so that if customer does not exist, exc is handled
//		otherwise persistent object is returned
//		map DTO -> entity
		Customer persistentCustomer = mapper.map(getCustById(custId), Customer.class);
		HomeMaker persistentHM = homeMakerRepo.findById(hmId)
				.orElseThrow(() -> new ResourceNotFoundException("HomeMaker with ID: " + hmId + " does not exist!!!"));

		persistentCustomer.setHomeMaker(persistentHM);
		System.out.println("HomeMaker added successfully....");
//		map entity -> DTO
		return mapper.map(customerRepo.save(persistentCustomer), CustomerDTO.class);

	}

//	to get homeMaker details for a customer
	@Override
	public HomeMakerDTO getMyHomeMaker(int custId) {

//		map DTO -> entity
		Customer persistentCustomer = mapper.map(getCustById(custId), Customer.class);

		HomeMaker homeMaker = persistentCustomer.getHomeMaker();
		if(homeMaker==null)
			return null;
//		map entity -> DTO
		return mapper.map(homeMaker, HomeMakerDTO.class);

	}

//	to remove a homeMaker for a customer
	@Override
	public String removeMyHomeMaker(int custId) {
		String mesg = "HomeMaker deletion failed!!!";
//		map DTO -> entity
		Customer persistentCustomer = mapper.map(getCustById(custId), Customer.class);
		persistentCustomer.setHomeMaker(null);
		customerRepo.save(persistentCustomer);
		mesg = "HomeMaker details removed successfully...";
		return mesg;
	}

//	to add a package  plan and plan type for a customer
	@Override
	public CustomerDTO updatePackage(String planType, String pack, CustomerDTO customerDTO) {
		
//		map DTO -> entity
		Customer customer = mapper.map(customerDTO, Customer.class);
		int custId = customer.getId();
//		map DTO -> entity
		Customer persistentCustomer = mapper.map(getCustById(custId), Customer.class);
		persistentCustomer.setPlanType(PlanType.valueOf(planType));
		persistentCustomer.setPlanPackage(PlanPackage.valueOf(pack));
		return mapper.map(customerRepo.save(persistentCustomer), CustomerDTO.class);
	}

}

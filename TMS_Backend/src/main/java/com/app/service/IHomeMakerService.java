package com.app.service;

import java.util.List;

import com.app.dto.CustomerDTO;
import com.app.dto.HomeMakerDTO;
import com.app.pojos.HomeMaker;

public interface IHomeMakerService {
	
//	to authenticate user as : HomeMaker
	HomeMakerDTO authenticateHomeMaker(String email, String pwd);	
//	to signup a new HomeMaker
	HomeMakerDTO signUpHomeMaker(HomeMakerDTO homeMakerDTO);	
//	to get all HomeMakers
	List<HomeMaker> getAllHomeMakers();
//	to get HomeMaker details by ID
	HomeMakerDTO getHomeMakerById(int id);	
//	to delete HomeMaker details by ID
	String deleteHomeMakerById(int id);	
//	to update details of a HomeMaker
	HomeMakerDTO updateHomeMakerDetails(HomeMakerDTO homeMakerDTO);
//	to get list of all customers
	List<CustomerDTO> getMyCustomers(int hId);
//	to get list of all HomeMakers from given city
	List<HomeMakerDTO> homeMakersByCity(String city);
//	to get list of all distinct cities
	List<String> getAllCities();
}

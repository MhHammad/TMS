package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.HomeMakerRepository;
import com.app.dto.CustomerDTO;
import com.app.dto.HomeMakerDTO;
import com.app.pojos.HomeMaker;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class HomeMakerServiceImpl implements IHomeMakerService {
	@Autowired
	private HomeMakerRepository homeMakerRepo;

	@Autowired
	private ModelMapper mapper;

//	to authenticate user as : HomeMaker
	@Override
	public HomeMakerDTO authenticateHomeMaker(String email, String pwd) {

		HomeMaker persistentHomemaker = homeMakerRepo.findByEmailAndPassword(email, pwd)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid email or password"));
//		 map entity -> DTO
		return mapper.map(persistentHomemaker, HomeMakerDTO.class);
	}

//	to signup a new HomeMaker
	@Override
	public HomeMakerDTO signUpHomeMaker(HomeMakerDTO homeMakerDTO) {
//		map DTO -> entity
		HomeMaker transientHomeMaker = mapper.map(homeMakerDTO, HomeMaker.class);
//		check if HomeMaker already exists, if not ->  save HomeMaker else -> return null
		if (homeMakerRepo.findByEmail(transientHomeMaker.getEmail()) != null) {
//			HomeMaker exist with this email
			return null;
		}
		return mapper.map(homeMakerRepo.save(transientHomeMaker), HomeMakerDTO.class);
	}

//	to get all HomeMakers
	@Override
	public List<HomeMaker> getAllHomeMakers() {
		return homeMakerRepo.findAll();
	}

//	to get HomeMaker details by ID
	@Override
	public HomeMakerDTO getHomeMakerById(int id) {
		HomeMaker persistentHomemaker = homeMakerRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("HomeMaker with ID: " + id + " does not exist!!!"));
		// map entity -> DTO
		return mapper.map(persistentHomemaker, HomeMakerDTO.class);
	}

//	to delete HomeMaker details by ID
	@Override
	public String deleteHomeMakerById(int id) {
		String mg = "Deletion not successful...!!!!";

		if (homeMakerRepo.existsById(id)) {
			homeMakerRepo.deleteById(id);
			mg = "HomeMaker with ID: " + id + " deleted successfully";
		}
		return mg;
	}

//	to update details of a HomeMaker
	@Override
	public HomeMakerDTO updateHomeMakerDetails(HomeMakerDTO homeMakerDTO) {
//		map DTO -> entity
		HomeMaker transientHomeMaker = mapper.map(homeMakerDTO, HomeMaker.class);
//		map entity -> DTO
		return mapper.map(homeMakerRepo.save(transientHomeMaker), HomeMakerDTO.class);
	}

//	to get list of all customers
	@Override
	public List<CustomerDTO> getMyCustomers(int hId) {
//		find homemaker by calling getHomeMakerById() so that if homemaker does not exist, exc is handled
//		otherwise persistent object is returned
		HomeMaker persistentHomeMaker = mapper.map(getHomeMakerById(hId), HomeMaker.class);
		List<CustomerDTO> customers = new ArrayList<>();
//		get list of customers for given HomeMaker
//		map each customer entity to customerDTO
//		add customerDTO to the list of customerDTO
		persistentHomeMaker.getCustomers().forEach(c -> {
			CustomerDTO dto = mapper.map(c, CustomerDTO.class);
			customers.add(dto);			
		});	
		return customers;
	}

//	to get list of all HomeMakers from given city
	@Override
	public List<HomeMakerDTO> homeMakersByCity(String city) {
		
		List<HomeMakerDTO> homeMakers = new ArrayList<>();
		homeMakerRepo.findByCity(city).forEach(h -> {
			HomeMakerDTO dto = mapper.map(h, HomeMakerDTO.class);
			homeMakers.add(dto);			
		});
		return homeMakers;
	}

//	to get list of all distinct cities
	@Override
	public List<String> getAllCities() {
//		List<String> cities =new ArrayList<>();		
		return homeMakerRepo.getAllCities();
	}
}

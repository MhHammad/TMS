package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.HomeMaker;

public interface HomeMakerRepository extends JpaRepository<HomeMaker, Integer> {
	
	//to authenticate user as : HomeMaker
	Optional<HomeMaker> findByEmailAndPassword(String email, String pwd);
	
	HomeMaker findByEmail(String email);
	
	List<HomeMaker> findByCity(String city);
	
	@Query("select distinct city from HomeMaker")
	List<String> getAllCities();

}

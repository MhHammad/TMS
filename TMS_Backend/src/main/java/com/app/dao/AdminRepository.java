package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	//to authenticate user as : Admin
	Optional<Admin> findByEmailAndPassword(String email, String pwd);	

}

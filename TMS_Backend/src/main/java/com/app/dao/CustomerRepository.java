package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	
//	@Query("select c from Customer c  where c.email=:email and c.password = :password")
//	Optional<Customer> authenticateCustomer(@Param("email") String email, @Param("password") String password);
	
	Customer findByEmail(String email);
	
//	findByDepartmentAndWorkLocation(String dept,String loc);
	
	Optional<Customer> findByEmailAndPassword(String em, String pass);


}

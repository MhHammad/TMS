package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	//to get all orders
	List<Orders> findAll();	

}

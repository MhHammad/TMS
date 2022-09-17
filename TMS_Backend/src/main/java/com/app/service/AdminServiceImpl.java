package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.AdminRepository;
import com.app.dao.OrderRepository;
import com.app.pojos.Admin;
import com.app.pojos.Orders;

import custom_exceptions.ResourceNotFoundException;

@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	@Autowired
	private AdminRepository adminRepo;
	
	@Autowired
	private OrderRepository orderRepo;

	@Override
	public Admin authenticateAdmin(String email, String pwd) {

		return adminRepo.findByEmailAndPassword(email, pwd)
				.orElseThrow(() -> new ResourceNotFoundException("Invalid credentials..!!"));
	}

	@Override
	public List<Orders> getAllOrders() {
		
		return orderRepo.findAll();
	}

}

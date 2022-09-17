package com.app.service;

import java.util.List;

import com.app.pojos.Admin;
import com.app.pojos.Orders;

public interface IAdminService {
	
	//to authenticate use as : Admin
	Admin authenticateAdmin(String email, String pwd);	
	
	//to get all orders
	List<Orders> getAllOrders();
}

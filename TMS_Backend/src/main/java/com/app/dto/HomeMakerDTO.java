package com.app.dto;

import java.util.ArrayList;
import java.util.List;

import com.app.pojos.Customer;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class HomeMakerDTO{
	
	private int id;	
	private String name;	
	private String email;
	private String password;	
	private String confirmPassword;
	private String phoneNo;
	private String city;
	private String pincode;
	private String primaryAddress;
	private String state;
	private String country;
	private List<Customer> customers = new ArrayList<>();
	
}

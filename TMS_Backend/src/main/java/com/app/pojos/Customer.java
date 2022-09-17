package com.app.pojos;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="customer")
public class Customer extends BaseEntity{
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30, unique=true)
	private String email;
	
	@Column(length = 30, nullable=false)
	private String password;
	
	@Column(length = 30, nullable=false)
	private String confirmPassword;
	
	@Column(length = 30, unique=true)
	private String phoneNo;
	
	@Column(length = 30)
	private String city;
	
	@Column(length = 30)
	private String pincode;
	
	@Column(length = 30, unique=true)
	private String primaryAddress;
	
	@Column(length = 30)
	private String state;
	
	@Column(length = 30)
	private String country;
	
	@Enumerated(EnumType.STRING)
	private PlanPackage planPackage;
	
	@Enumerated(EnumType.STRING)
	private PlanType planType;
	
	// Customer  HAS-A HomeMaker (i.e linked with HomeMaker)
	// HomeMaker  1<-----* Customer
	@ManyToOne //(fetch = FetchType.LAZY)// => 1 homemaker can have multiple Customers
	@JoinColumn(name = "h_id", nullable = true)// to specify name of the FK col to hibernate
	@JsonIgnoreProperties("customers")
	@JsonIgnore
	private HomeMaker homeMaker;
		
}

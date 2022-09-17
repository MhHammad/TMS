package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;

//import java.util.HashSet;
//import java.util.Set;
//
//import javax.persistence.CollectionTable;

//import java.util.ArrayList;
//import java.util.List;

import javax.persistence.Column;
//import javax.persistence.ElementCollection;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.OneToMany;
//import javax.persistence.EnumType;
//import javax.persistence.Enumerated;
//import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="home_maker")
public class HomeMaker extends BaseEntity{
	
	@Column(length = 30)
	private String name;
	
	@Column(length = 30, unique=true)
	private String email;
	
	@Column(length = 30,nullable=false)
	private String password;
	
	@Column(length = 30,nullable=false)
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
	
	@OneToMany(cascade = CascadeType.ALL , mappedBy = "homeMaker")//, fetch = FetchType.LAZY, orphanRemoval = true)
	@JsonIgnoreProperties("homeMaker")
	@JsonIgnore
	private List<Customer> customers = new ArrayList<>();

	
//	@ElementCollection // MANDATORY to specify that following is a collection of composite type (UDT)
//	@CollectionTable(name = "menu", joinColumns = @JoinColumn(name = "h_id"))
//	private Set<Menu> menus = new HashSet<>();
	
}

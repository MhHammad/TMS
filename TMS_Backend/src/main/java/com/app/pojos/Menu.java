package com.app.pojos;

//import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
//import javax.persistence.JoinColumn;
//import javax.persistence.MapsId;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Embeddable
public class Menu{
	
	@Enumerated(EnumType.STRING)
	private Weekday days;
	
	private String item;
	
	private double price;
	
	// uni dir one to one relationship between entities
//	@OneToOne
//	@JoinColumn(name = "h_id",nullable = false)
//	@MapsId //to tell hibernate to use shared PK approach i.e., "h_id"-->shared PK for (Menu&Homemaker) & also FK in Menu
//	private HomeMaker homeMaker; 
	
}

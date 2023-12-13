package com.qsp.krushimart.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private double price ;
	private int quantity ;
	private String description ;
	
//	@ManyToOne
//	@JoinColumn
//	private User user ;
}

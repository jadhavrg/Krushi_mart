package com.qsp.krushimart.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String firstName ;
	private String lastName ;
	private String address ;
	private String password ;
	private String email ;
	private String role ;
	private long phone ;
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> product ;
}

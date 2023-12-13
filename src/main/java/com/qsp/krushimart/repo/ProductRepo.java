package com.qsp.krushimart.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.qsp.krushimart.dto.Product;

public interface ProductRepo extends JpaRepositoryImplementation<Product, Integer>  
{
	
}

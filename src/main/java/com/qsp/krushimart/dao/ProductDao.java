package com.qsp.krushimart.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.krushimart.dto.Product;
import com.qsp.krushimart.exception.IdNotFound;
import com.qsp.krushimart.repo.ProductRepo;

@Repository
public class ProductDao
{
	@Autowired
	private ProductRepo repo ;
	
	public Product saveProduct(Product product)
	{
		return repo.save(product) ;
	}
	
	public Product getProduct(int id)
	{
		Optional<Product> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			throw new IdNotFound("Products Not Available") ;
		}
		return optional.get() ;
	}
	
	public List<Product> getAllProducts()
	{
		return repo.findAll() ;
	}
	
	public Product deleteProduct(int id) 
	{
		Optional<Product> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			repo.deleteById(id);
			return optional.get() ;
		}
		return null ;
	}
	
	public Product updateProduct(Product product, int id) 
	{
		Optional<Product> optional = repo.findById(id) ;
		if (optional.isEmpty()) 
		{
			return null ;
		}
		product.setId(id);
		return repo.save(product) ;
	}
}

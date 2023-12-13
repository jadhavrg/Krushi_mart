package com.qsp.krushimart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.krushimart.dao.ProductDao;
import com.qsp.krushimart.dto.Product;
import com.qsp.krushimart.exception.DataIsNotAvailabe;
import com.qsp.krushimart.exception.IdNotFound;
import com.qsp.krushimart.util.ResponseStructure;

@Service
public class ProductService
{
	@Autowired
	private ProductDao dao ;
	
	public ResponseEntity<ResponseStructure<Product>> saveProduct(Product product) 
	{
		ResponseStructure<Product> structure = new ResponseStructure<>() ;
		structure.setMessage("Product is Added...!");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dao.saveProduct(product));
		return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.CREATED) ;
	}
	
	public ResponseEntity<ResponseStructure<Product>> getProduct(int id) 
	{
		Product product = dao.getProduct(id) ;
		ResponseStructure<Product> structure = new ResponseStructure<>() ;
		if (product != null) 
		{
			structure.setMessage("Product is added...!");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.FOUND) ;
		}
		throw new IdNotFound("Product with given Id is not found..!") ;
	}
	
	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() 
	{
		List<Product> list = dao.getAllProducts() ;
		ResponseStructure<List<Product>> structure = new ResponseStructure<>() ;
		if (list.isEmpty()) 
		{
			throw new DataIsNotAvailabe("Products are not available..!");
		}
		structure.setMessage("Products are Available..!");
		structure.setStatus(HttpStatus.FOUND.value());
		structure.setData(list);
		return new ResponseEntity<ResponseStructure<List<Product>>>(structure, HttpStatus.FOUND) ;
	}
	
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(int id) 
	{
		Product product = dao.deleteProduct(id) ;
		ResponseStructure<Product> structure = new ResponseStructure<>() ;
		if (product != null) 
		{
			structure.setMessage("Product Is deleted..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK) ;
		}
		
		throw new IdNotFound("Product with given id is not present..!") ;
	}
	
	public ResponseEntity<ResponseStructure<Product>> updateProduct(int id, Product product) 
	{
		Product dbProduct = dao.updateProduct(product, id) ;
		ResponseStructure<Product> structure = new ResponseStructure<>() ;
		if (dbProduct != null) 
		{
			structure.setMessage("Product is Available..!");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(product);
			return new ResponseEntity<ResponseStructure<Product>>(structure, HttpStatus.OK) ;
		}
		
		throw new IdNotFound("Product with given id is not present..!") ;
	}
}

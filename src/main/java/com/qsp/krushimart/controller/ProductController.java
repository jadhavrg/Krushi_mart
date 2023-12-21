package com.qsp.krushimart.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.krushimart.dto.Product;
import com.qsp.krushimart.service.ProductService;
import com.qsp.krushimart.util.ResponseStructure;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProductController 
{
	@Autowired
	private ProductService service ;
	
	@PostMapping("/product")
	public ResponseEntity<ResponseStructure<Product>> saveProduct(@RequestBody Product product) 
	{
		return service.saveProduct(product) ;
	}
	
	@GetMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Product>> getProduct(@PathVariable int id) 
	{
		return service.getProduct(id) ;
	}
//	
//	@GetMapping("/products")
//	public ResponseEntity<ResponseStructure<List<Product>>> getAllProduct() 
//	{
//		return service.getAllProduct() ;
//	}
	
	@GetMapping("/products")
	public List<Product> getAllProduct()
	{
	     return service.getAllProduct() ;
	}
	
	@DeleteMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Product>> deleteProduct(@PathVariable int id) 
	{
		return service.deleteProduct(id) ;
	}
	
	@PutMapping("/product/{id}")
	public ResponseEntity<ResponseStructure<Product>> updateProduct(@PathVariable int id, @RequestBody Product product) 
	{
		return service.updateProduct(id, product) ;
	}
}

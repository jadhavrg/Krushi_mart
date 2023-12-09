package com.qsp.krushimart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.krushimart.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler 
{
	public ResponseEntity<ResponseStructure<String>> idNotFound(IdNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setId(HttpStatus.BAD_REQUEST.value());
		structure.setData("User with given id is not present..!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
}

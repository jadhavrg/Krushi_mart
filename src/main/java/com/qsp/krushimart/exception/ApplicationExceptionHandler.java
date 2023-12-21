package com.qsp.krushimart.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.qsp.krushimart.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler 
{
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> idNotFoundExceptionHandler(IdNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("User with given id is not present..!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(LoginIsNotDone.class)
	public ResponseEntity<ResponseStructure<String>> loginIsNotDoneExceptionHandler(LoginIsNotDone ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Please First Register your Account...!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(DataIsNotAvailabe.class)
	public ResponseEntity<ResponseStructure<String>> dataIsNotAvailableExceptionHamdler(DataIsNotAvailabe ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Please Add Products First...!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
	
	@ExceptionHandler(UserNotFound.class)
	public ResponseEntity<ResponseStructure<String>> userNotFoundExceptionHamdler(UserNotFound ex) 
	{
		ResponseStructure<String> structure = new ResponseStructure<>() ;
		structure.setMessage(ex.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Please register First...!");
		return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.BAD_REQUEST) ;
	}
}

package com.qsp.krushimart.exception;

public class LoginIsNotDone extends RuntimeException
{
	String message ;
	
	public String getMessage() 
	{
		return message ;
	}
	
	public LoginIsNotDone(String message)
	{
		super() ;
		this.message = message ;
	}
}

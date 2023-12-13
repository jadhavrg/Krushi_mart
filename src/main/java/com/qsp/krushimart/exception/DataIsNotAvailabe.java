package com.qsp.krushimart.exception;

public class DataIsNotAvailabe extends RuntimeException
{
	String message ;
	
	public String getMessage()
	{
		return message ;
	}
	
	public DataIsNotAvailabe(String message)
	{
		super() ;
		this.message = message ;
	}
}

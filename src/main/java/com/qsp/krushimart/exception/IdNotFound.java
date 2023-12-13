package com.qsp.krushimart.exception;

public class IdNotFound extends RuntimeException
{
	String message ;
	
	public String getMessage() {
		return message;
	}

	public IdNotFound(String message) {
		super();
		this.message = message;
	}
	
	
}



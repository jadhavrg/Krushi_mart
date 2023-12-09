package com.qsp.krushimart.util;

import lombok.Data;

@Data
public class ResponseStructure <T>
{
	private String message ;
	private int id ;
	private T data ;
	
}

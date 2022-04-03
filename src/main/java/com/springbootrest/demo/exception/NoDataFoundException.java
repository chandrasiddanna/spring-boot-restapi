package com.springbootrest.demo.exception;

public class NoDataFoundException extends RuntimeException {
	
	public NoDataFoundException(String message) {
		super(message);
	}
}

package com.demo.exception;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class InternalServerException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public InternalServerException(String message) {
		super(message);
	}
	
	public InternalServerException(String message, Throwable t) {
		super(message, t);
	}
}

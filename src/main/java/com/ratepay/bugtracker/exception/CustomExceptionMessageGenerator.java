package com.ratepay.bugtracker.exception;

public class CustomExceptionMessageGenerator extends RuntimeException {

	private static final long serialVersionUID = 1L;
	

	public CustomExceptionMessageGenerator() {
		super();
		
	}

	
	public CustomExceptionMessageGenerator(String message) {
		super(message);
		
	}

}

package com.github.chandrasekar246.banking.exception;

public class InvalidCustomerIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidCustomerIdException(String message) {
		super(message);
	}
}

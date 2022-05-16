package com.github.chandrasekar246.banking.exception;

public class InvalidAccountNumberException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccountNumberException(String message) {
		super(message);
	}
}

package com.github.chandrasekar246.banking.exception;

public class InvalidAccountIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidAccountIdException(String message) {
		super(message);
	}
}

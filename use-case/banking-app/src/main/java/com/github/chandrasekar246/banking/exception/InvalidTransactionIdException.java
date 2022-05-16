package com.github.chandrasekar246.banking.exception;

public class InvalidTransactionIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidTransactionIdException(String message) {
		super(message);
	}
}

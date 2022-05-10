package com.github.chandrasekar246.banking.exception;

public class InvalidBeneficiaryIdException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidBeneficiaryIdException(String message) {
		super(message);
	}
}

package com.github.chandrasekar246.banking.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.github.chandrasekar246.banking.exception.BeneficiaryNotRegisteredException;
import com.github.chandrasekar246.banking.exception.DateRangeMismatchException;
import com.github.chandrasekar246.banking.exception.InsufficientBalanceException;
import com.github.chandrasekar246.banking.exception.InvalidAccountIdException;
import com.github.chandrasekar246.banking.exception.InvalidAccountNumberException;
import com.github.chandrasekar246.banking.exception.InvalidBeneficiaryIdException;
import com.github.chandrasekar246.banking.exception.InvalidCustomerIdException;
import com.github.chandrasekar246.banking.exception.InvalidTransactionIdException;
import com.github.chandrasekar246.banking.model.ErrorCode;
import com.github.chandrasekar246.banking.model.ErrorResponse;

@RestControllerAdvice
public class MyControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ErrorResponse(ErrorCode.getErrorCode(MethodArgumentNotValidException.class), errors.toString());
	}

	@ExceptionHandler(value = { InvalidDefinitionException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse invalidDefinitionException(Exception ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(InvalidDefinitionException.class), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(Exception.class), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(IOException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(IOException.class), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { PropertyReferenceException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse propertyReferenceException(PropertyReferenceException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(PropertyReferenceException.class), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse propertyReferenceException(DataIntegrityViolationException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(DataIntegrityViolationException.class),
				ex.getMostSpecificCause().getLocalizedMessage());
	}

	@ExceptionHandler(value = { InvalidCustomerIdException.class, InvalidAccountIdException.class,
			InvalidBeneficiaryIdException.class, InvalidTransactionIdException.class,
			InvalidAccountNumberException.class, BeneficiaryNotRegisteredException.class,
			InsufficientBalanceException.class, DateRangeMismatchException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse invalidDepartmentException(Exception ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(ex.getClass()), ex.getLocalizedMessage());
	}
	
}

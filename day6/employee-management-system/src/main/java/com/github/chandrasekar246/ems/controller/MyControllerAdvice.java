package com.github.chandrasekar246.ems.controller;

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
import com.github.chandrasekar246.ems.exception.InvalidDepartmentException;
import com.github.chandrasekar246.ems.model.ErrorCode;
import com.github.chandrasekar246.ems.model.ErrorResponse;

@RestControllerAdvice
public class MyControllerAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ErrorResponse handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return new ErrorResponse(ErrorCode.getErrorCode(MethodArgumentNotValidException.class).get(),
				errors.toString());
	}

	@ExceptionHandler(value = { InvalidDefinitionException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse invalidDefinitionException(Exception ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(InvalidDefinitionException.class).get(),
				ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse unKnownException(Exception ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(Exception.class).get(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { IOException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse badRequest(IOException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(IOException.class).get(), ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { PropertyReferenceException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse propertyReferenceException(PropertyReferenceException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(PropertyReferenceException.class).get(),
				ex.getLocalizedMessage());
	}

	@ExceptionHandler(value = { DataIntegrityViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse propertyReferenceException(DataIntegrityViolationException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(DataIntegrityViolationException.class).get(),
				ex.getMostSpecificCause().getLocalizedMessage());
	}

	@ExceptionHandler(value = { InvalidDepartmentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorResponse invalidDepartmentException(InvalidDepartmentException ex) {
		return new ErrorResponse(ErrorCode.getErrorCode(InvalidDepartmentException.class).get(),
				ex.getLocalizedMessage());
	}
}

package com.github.chandrasekar246.hungerbox.model;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import lombok.Getter;

@Getter
public enum ErrorCode {
	ERR1001(Exception.class), ERR1002(IOException.class), ERR1003(PropertyReferenceException.class),
	ERR1004(MethodArgumentNotValidException.class), ERR1005(DataIntegrityViolationException.class);

	private final Class<? extends Throwable> throwable;

	ErrorCode(Class<? extends Throwable> throwable) {
		this.throwable = throwable;
	}

	public static ErrorCode getErrorCode(Class<? extends Throwable> throwable) {
		return Arrays.stream(ErrorCode.values()).filter(throwable2 -> throwable2.getThrowable().equals(throwable))
				.findFirst().orElse(ERR1001);
	}

}

package com.github.chandrasekar246.banking.model;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.web.bind.MethodArgumentNotValidException;

import com.github.chandrasekar246.banking.exception.BeneficiaryNotRegisteredException;
import com.github.chandrasekar246.banking.exception.DateRangeMismatchException;
import com.github.chandrasekar246.banking.exception.InsufficientBalanceException;
import com.github.chandrasekar246.banking.exception.InvalidAccountIdException;
import com.github.chandrasekar246.banking.exception.InvalidAccountNumberException;
import com.github.chandrasekar246.banking.exception.InvalidBeneficiaryIdException;
import com.github.chandrasekar246.banking.exception.InvalidCustomerIdException;
import com.github.chandrasekar246.banking.exception.InvalidTransactionIdException;

import lombok.Getter;

@Getter
public enum ErrorCode {
	ERR1001(Exception.class), ERR1002(IOException.class), ERR1003(PropertyReferenceException.class),
	ERR1004(MethodArgumentNotValidException.class), ERR1005(InvalidCustomerIdException.class),
	ERR1006(InvalidAccountIdException.class), ERR1007(InvalidBeneficiaryIdException.class),
	ERR1008(InvalidTransactionIdException.class), ERR1009(InvalidAccountNumberException.class),
	ERR10010(BeneficiaryNotRegisteredException.class), ERR10011(InsufficientBalanceException.class),
	ERR10012(DataIntegrityViolationException.class), ERR10013(DateRangeMismatchException.class);

	private final Class<? extends Throwable> throwable;

	ErrorCode(Class<? extends Throwable> throwable) {
		this.throwable = throwable;
	}

	public static Optional<ErrorCode> getErrorCode(Class<? extends Throwable> throwable) {
		return Arrays.stream(ErrorCode.values()).filter(throwable2 -> throwable2.getThrowable().equals(throwable))
				.findFirst();
	}

}

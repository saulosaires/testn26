package com.n26.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)

public class InvalidTransactionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 507932543621264814L;

	public InvalidTransactionException(String errorMessage) {
		super(errorMessage);
	}
}

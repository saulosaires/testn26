package com.n26.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class InvalidJsonException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 507932543621264814L;

	public InvalidJsonException(String errorMessage) {
		super(errorMessage);
	}
}

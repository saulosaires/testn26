package com.n26.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class ExpiredTransactionException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8831637618951801272L;

	public ExpiredTransactionException(String errorMessage) {
        super(errorMessage);
    }
}
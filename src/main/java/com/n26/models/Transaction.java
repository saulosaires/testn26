package com.n26.models;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.n26.helper.TransactionDeserializer;

@JsonDeserialize(using=TransactionDeserializer.class) 
public class Transaction {

	private BigDecimal amount;
	
	@DateTimeFormat(pattern="YYYY-MM-DDThh:mm:ss.sssZ")
	private ZonedDateTime timestamp;

	public Transaction() {}
	
	public Transaction(BigDecimal amount, ZonedDateTime timestamp) {
		super();
		this.amount = amount;
		this.timestamp = timestamp;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public ZonedDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(ZonedDateTime timestamp) {
		this.timestamp = timestamp;
	}

 

}

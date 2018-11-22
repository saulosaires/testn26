package com.n26.models;

import java.time.LocalDateTime;

public class Transaction {

	private Double amount;
	private LocalDateTime time;

	public Transaction(Double amount, LocalDateTime time) {
		super();
		this.amount = amount;
		this.time = time;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

}

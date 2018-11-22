package com.n26.repositories.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;

public class TransactionRepositoryImpl implements TransactionRepository {

	private Map<LocalDateTime, Transaction> transactionsMap = new ConcurrentHashMap<>();
	
	@Override
	public void save(Transaction transaction) {
		
		transactionsMap.put(transaction.getTime(), transaction);
		
	}

	@Override
	public List<Transaction> findAll() {

		return transactionsMap.values().stream().collect(Collectors.toList());
	}

	@Override
	public void deleteAll() {
		
		transactionsMap.clear();
		
	}

}

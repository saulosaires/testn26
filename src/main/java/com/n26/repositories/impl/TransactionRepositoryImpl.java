package com.n26.repositories.impl;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	private Map<LocalDateTime, Transaction> transactionsMap = new ConcurrentHashMap<>();
	
	@Override
	public void save(Transaction transaction) {
		
		transactionsMap.put(transaction.getTime(), transaction);
		
	}

	@Override
	public Collection<Transaction> findAll() {

		return transactionsMap.values();
	}

	@Override
	public void deleteAll() {
		
		transactionsMap.clear();
		
	}

}

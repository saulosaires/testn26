package com.n26.repositories.impl;

import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Repository;

import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

	AtomicInteger id = new AtomicInteger(1);
	
	private ConcurrentSkipListMap<Integer, Transaction> transactionsMap = new ConcurrentSkipListMap<>();
	
	@Override
	public void save(Transaction transaction) {
		
		transactionsMap.put(id.incrementAndGet(), transaction);
		
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

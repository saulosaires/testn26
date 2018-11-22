package com.n26.repositories;

import java.util.Collection;

import com.n26.models.Transaction;

public interface TransactionRepository {

    void save(Transaction transaction);

    Collection<Transaction> findAll();
    
    void deleteAll();
	
}

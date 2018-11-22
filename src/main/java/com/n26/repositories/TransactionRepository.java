package com.n26.repositories;

import java.util.List;

import com.n26.models.Transaction;

public interface TransactionRepository {

    void save(Transaction transaction);

    List<Transaction> findAll();
    
    void deleteAll();
	
}

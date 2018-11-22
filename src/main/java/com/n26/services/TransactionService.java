package com.n26.services;

import com.n26.models.Transaction;

public interface TransactionService {

    public void addTransaction(Transaction transaction);

    public boolean isValid(Transaction transaction);

    public void deleteAll();

}

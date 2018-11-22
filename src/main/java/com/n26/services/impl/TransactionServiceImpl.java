package com.n26.services.impl;

import com.n26.exceptions.InvalidTransactionException;
import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;
import com.n26.services.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    public static final int TEMPORAL_WINDOW_SECONDS = 60;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void addTransaction(Transaction transaction) {


        if(isValid(transaction)) {
            transactionRepository.save(transaction);
        }
    }

    public void deleteAll(){
        transactionRepository.deleteAll();
    }

    @Override
    public boolean isValid(Transaction transaction){

        if(!isValidFields(transaction) || !isInTheFuture(transaction)){
            throw new InvalidTransactionException("Transaction time is in the future or not parsable");
        }


        if(!isInTheTemporalWindow(transaction)){
            throw new InvalidTransactionException("Transaction time is not in the temporal window of "+TEMPORAL_WINDOW_SECONDS+" seconds");
        }

        return true;
    }

    private boolean isValidFields(Transaction transaction){

        return transaction.getTime()!=null;
    }

    private boolean isInTheTemporalWindow(Transaction transaction){

        return ChronoUnit.SECONDS.between(LocalDateTime.now(),transaction.getTime())< TEMPORAL_WINDOW_SECONDS;
    }

    private boolean isInTheFuture(Transaction transaction){

        return LocalDateTime.now().compareTo(transaction.getTime())<0;

    }

}
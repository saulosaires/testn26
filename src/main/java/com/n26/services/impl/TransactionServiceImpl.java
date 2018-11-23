package com.n26.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.n26.exceptions.ExpiredTransactionException;
import com.n26.exceptions.InvalidTransactionException;
import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;
import com.n26.services.TransactionService;
import com.n26.utils.TransactionUtils;

@Service
public class TransactionServiceImpl implements TransactionService {

	@Value("${temporal_window}")
    public  int TEMPORAL_WINDOW_SECONDS;
	
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
            throw new ExpiredTransactionException("Transaction time is not in the temporal window of "+TEMPORAL_WINDOW_SECONDS+" seconds");
        }

        return true;
    }

    private boolean isValidFields(Transaction transaction){

        return transaction.getTimestamp()!=null && transaction.getAmount()!=null;
    }

    private boolean isInTheTemporalWindow(Transaction transaction){
    	
    	return TransactionUtils.isInTheTemporalWindow(transaction, TEMPORAL_WINDOW_SECONDS);

    }

    private boolean isInTheFuture(Transaction transaction){
    	
    	return TransactionUtils.isInTheFuture(transaction);
         
    }

}
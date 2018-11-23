package com.n26.utils;

import java.time.Instant;

import com.n26.models.Transaction;

public class TransactionUtils {

	private TransactionUtils() {
	    throw new IllegalStateException("Utility class");
	  }
	
	 public static  boolean isInTheTemporalWindow(Transaction transaction, int temporalWindow){
 
		 return transaction.getTimestamp().plusSeconds(temporalWindow).toInstant().isAfter(Instant.now());
		 
	    }
	
	 public static boolean isInTheFuture(Transaction transaction){
		 
		 return transaction.getTimestamp().toInstant().isBefore(Instant.now());
 
	    }
	 
}

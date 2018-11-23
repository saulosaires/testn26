package com.n26.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

import com.n26.models.Transaction;

public class TransactionUtils {

	private TransactionUtils() {
	    throw new IllegalStateException("Utility class");
	  }
	
	 public static  boolean isInTheTemporalWindow(Transaction transaction, int temporalWindow){
 
		 return transaction.getTimestamp().plusSeconds(temporalWindow).toInstant().isAfter(Instant.now());
		 
	       // return ChronoUnit.SECONDS.between(transaction.getTimestamp().toInstant(),Instant.now())< temporalWindow;
	    }
	
	 public static boolean isInTheFuture(Transaction transaction,String zoneId){
		 
		 return transaction.getTimestamp().toInstant().isBefore(Instant.now());
 
	    }
	 
}

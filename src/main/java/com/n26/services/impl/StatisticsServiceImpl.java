package com.n26.services.impl;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.n26.models.Statistics;
import com.n26.models.Transaction;
import com.n26.repositories.TransactionRepository;
import com.n26.services.StatisticsService;
import com.n26.utils.TransactionUtils;

@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Value("${temporal_window}")
    public  int TEMPORAL_WINDOW_SECONDS;
	
	@Value("${roundingMode}")
	int roundingMode;
	
	@Value("${scale}")
	int scale;
	
    @Autowired
    private TransactionRepository transactionRepository;

 
    @Override
    public Statistics getStatistics() {
    	
    	DoubleSummaryStatistics statistics =transactionRepository.findAll().stream()
    															 .filter(t-> isInTheTemporalWindow(t))
    															 .map(Transaction::getAmount)
    															 .mapToDouble(BigDecimal::doubleValue)
    															 .summaryStatistics();
    	
    	
    	return new Statistics(
    						  getValueBigDecimal(statistics.getSum()),
    						  getValueBigDecimal(statistics.getAverage()),
    						  getValueBigDecimal(statistics.getMax()),
    						  getValueBigDecimal(statistics.getMin()),
    						  statistics.getCount()
    						  );
    }
    
    
    private boolean isInTheTemporalWindow(Transaction transaction){
    	
    	boolean b= TransactionUtils.isInTheTemporalWindow(transaction, TEMPORAL_WINDOW_SECONDS);
    	
    	if(!b) {
    		System.out.println(transaction.getTimestamp()+">>>>"+transaction.getAmount());
    	}

    	return b;
    }
    
    
    private BigDecimal getValueBigDecimal(Double value) {
    	
		if (value == Double.NEGATIVE_INFINITY || value == Double.POSITIVE_INFINITY || value == Double.NaN) {
			return BigDecimal.valueOf(0).setScale(scale, roundingMode);
		} else {
			return BigDecimal.valueOf(value).setScale(scale, roundingMode);
		}
	}
}

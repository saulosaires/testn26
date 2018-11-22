package com.n26.services.impl;

import java.util.DoubleSummaryStatistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.n26.models.Statistics;
import com.n26.repositories.TransactionRepository;
import com.n26.services.StatisticsService;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private TransactionRepository transactionRepository;

 
    @Override
    public Statistics getStatistics() {
    	
    	
    	return null;
    }
    
    
}

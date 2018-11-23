package com.n26.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.models.Statistics;
import com.n26.services.StatisticsService;

@RestController
@RequestMapping("statistics")
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	
	@GetMapping
	@ResponseBody
	public Statistics get() {

		return statisticsService.getStatistics();
		
	}

}

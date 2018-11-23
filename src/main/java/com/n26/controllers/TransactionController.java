package com.n26.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.models.Transaction;
import com.n26.services.TransactionService;



@RestController
@RequestMapping("transactions")
public class TransactionController {
 	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping
	@ResponseBody
	public ResponseEntity save(@RequestBody Transaction transaction) {
		
		transactionService.addTransaction(transaction);
		
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	@DeleteMapping
	public ResponseEntity delete() {
		
		transactionService.deleteAll();
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		
	}
}

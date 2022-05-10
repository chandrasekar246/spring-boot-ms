package com.github.chandrasekar246.banking.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.banking.entity.TransactionHistory;
import com.github.chandrasekar246.banking.service.TransactionHistoryService;

@RestController
@RequestMapping("/transaction")
public class TransactionHistoryController {

	@Autowired
	private TransactionHistoryService transactionHistoryService;

	@GetMapping
	public List<TransactionHistory> findAll() {
		return transactionHistoryService.findAll();
	}

	@GetMapping("/{id}")
	public TransactionHistory findById(@PathVariable int id) {
		return transactionHistoryService.findById(id);
	}

	@GetMapping("/range")
	public List<TransactionHistory> findByTransactionTimeBetween(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime fromDateTime,
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") LocalDateTime toDateTime) {
		return transactionHistoryService.findByTransactionTimeBetween(fromDateTime, toDateTime);
	}

}

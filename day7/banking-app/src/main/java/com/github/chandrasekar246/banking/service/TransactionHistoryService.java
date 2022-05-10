package com.github.chandrasekar246.banking.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.TransactionHistory;
import com.github.chandrasekar246.banking.exception.DateRangeMismatchException;
import com.github.chandrasekar246.banking.exception.InvalidTransactionIdException;
import com.github.chandrasekar246.banking.repository.TransactionHistoryRepository;

@Service
public class TransactionHistoryService {

	@Autowired
	private TransactionHistoryRepository transactionHistoryRepository;

	public List<TransactionHistory> findAll() {
		return (List<TransactionHistory>) transactionHistoryRepository.findAll();
	}

	public TransactionHistory findById(int id) {
		return transactionHistoryRepository.findById(id)
				.orElseThrow(() -> new InvalidTransactionIdException("Unknown transaction ID: " + id));
	}

	public TransactionHistory add(TransactionHistory transactionHistory) {
		return transactionHistoryRepository.save(transactionHistory);
	}

	public List<TransactionHistory> findByTransactionTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime) {
		if(fromDateTime.isAfter(toDateTime)) {
			throw new DateRangeMismatchException("fromDateTime cannot be after toDateTime");
		}
		
		return transactionHistoryRepository.findByTransactionTimeBetween(fromDateTime, toDateTime);
	}
}

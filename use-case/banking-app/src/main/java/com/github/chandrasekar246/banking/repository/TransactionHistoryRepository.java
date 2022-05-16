package com.github.chandrasekar246.banking.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.banking.entity.TransactionHistory;

@Repository
public interface TransactionHistoryRepository extends CrudRepository<TransactionHistory, Integer> {
	
	List<TransactionHistory> findByTransactionTimeBetween(LocalDateTime fromDateTime, LocalDateTime toDateTime);
}

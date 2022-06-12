package com.github.chandrasekar246.hungerbox.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TransactionHistory {

	private int id;

	private String fromAccountNumber;

	private String toAccountNumber;

	private double amount;

	private LocalDateTime transactionTime;
}

package com.github.chandrasekar246.banking.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class TransactionHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "from_account_number")
	private String fromAccountNumber;

	@Column(name = "to_account_number")
	private String toAccountNumber;

	private double amount;

	@Column(name = "transaction_time")
	@CreationTimestamp
	private LocalDateTime transactionTime;
}

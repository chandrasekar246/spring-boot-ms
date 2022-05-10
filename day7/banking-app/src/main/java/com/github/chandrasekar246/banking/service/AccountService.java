package com.github.chandrasekar246.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.Account;
import com.github.chandrasekar246.banking.exception.InvalidAccountIdException;
import com.github.chandrasekar246.banking.exception.InvalidAccountNumberException;
import com.github.chandrasekar246.banking.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	private AccountRepository accountRepository;

	public List<Account> findAll() {
		return (List<Account>) accountRepository.findAll();
	}

	public Account findById(int id) {
		return accountRepository.findById(id)
				.orElseThrow(() -> new InvalidAccountIdException("Unknown account ID: " + id));
	}

	public Account findByAccountNumber(String accountNumber) {
		return accountRepository.findByAccountNumber(accountNumber)
				.orElseThrow(() -> new InvalidAccountNumberException("Unknown account number: " + accountNumber));
	}

	public Account add(Account account) {
		return accountRepository.save(account);
	}

	public double getAccountBalance(String accountNumber) {
		return findByAccountNumber(accountNumber).getAmount();
	}

	public Account updateAmount(String accountNumber, double amount) {

		Account account = findByAccountNumber(accountNumber);

		account.setAmount(amount);

		return accountRepository.save(account);
	}

}

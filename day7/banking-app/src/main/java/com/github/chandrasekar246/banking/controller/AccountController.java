package com.github.chandrasekar246.banking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.banking.entity.Account;
import com.github.chandrasekar246.banking.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<Account> findAll() {
		return accountService.findAll();
	}

	@GetMapping("/{id}")
	public Account findById(@PathVariable int id) {
		return accountService.findById(id);
	}
}

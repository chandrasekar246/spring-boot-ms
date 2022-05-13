package com.github.chandrasekar246.banking.controller;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.banking.entity.Account;
import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.model.CustomerDTO;
import com.github.chandrasekar246.banking.service.AccountService;
import com.github.chandrasekar246.banking.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private ModelMapper modelMapper;
	
	private Random random = new SecureRandom(); 

	@GetMapping
	public List<Customer> findAll() {
		return customerService.findAll();
	}

	@GetMapping("/{id}")
	public Customer findById(@PathVariable int id) {
		return customerService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Account> add(@Valid @RequestBody CustomerDTO customerDTO) {

		var customer = modelMapper.map(customerDTO, Customer.class);

		customer = customerService.add(customer);

		var account = accountService.add(new Account(0, String.format("%06d", random.nextInt(999999)), 1000, customer));

		return new ResponseEntity<>(account, HttpStatus.CREATED);
	}

}

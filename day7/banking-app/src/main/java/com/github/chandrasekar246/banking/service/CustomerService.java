package com.github.chandrasekar246.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.exception.InvalidCustomerIdException;
import com.github.chandrasekar246.banking.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer findById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new InvalidCustomerIdException("Unknown customer ID: " + id));
	}

	public Customer add(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer, int id) {
		if (id == customer.getId()) {
			return customerRepository.save(customer);
		} else {
			throw new InvalidCustomerIdException("Unknown customer ID: " + id);
		}
	}

	public String deleteById(int id) {
		customerRepository.deleteById(id);

		return new StringBuilder("Customer record with ID: ").append(id).append(" is deleted!").toString();
	}

	public String deleteAll() {
		customerRepository.deleteAll();

		return "All customer records has been deleted!";
	}

}

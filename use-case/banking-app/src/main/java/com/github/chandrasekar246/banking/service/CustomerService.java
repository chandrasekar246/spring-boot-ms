package com.github.chandrasekar246.banking.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.exception.InvalidCustomerIdException;
import com.github.chandrasekar246.banking.repository.CustomerRepository;

@Service (value = "customerService")
public class CustomerService implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private BCryptPasswordEncoder bcryptEncoder;

	public List<Customer> findAll() {
		return (List<Customer>) customerRepository.findAll();
	}

	public Customer findById(int id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new InvalidCustomerIdException("Unknown customer ID: " + id));
	}

	public Customer add(Customer customer) {
		customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
		return customerRepository.save(customer);
	}

	public Customer update(Customer customer, int id) {
		if (id == customer.getId()) {
			customer.setPassword(bcryptEncoder.encode(customer.getPassword()));
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

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Customer> optionalCustomer = customerRepository.findByUsername(username);
		if (optionalCustomer.isEmpty()) {
			throw new UsernameNotFoundException("User not found! Username: " + username);
		}

		Customer customer = optionalCustomer.get();

		return new User(customer.getUsername(), customer.getPassword(), Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN")));
	}

}

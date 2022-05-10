package com.github.chandrasekar246.banking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.banking.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Integer> {
	
	Optional<Account> findByAccountNumber(String accountNumber);
}

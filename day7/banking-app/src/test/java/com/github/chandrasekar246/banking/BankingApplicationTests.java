package com.github.chandrasekar246.banking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.chandrasekar246.banking.controller.CustomerController;

@SpringBootTest
class BankingApplicationTests {
	
	@Autowired
	private CustomerController employeeController;

	@Test
	void contextLoads() {
		
		assertThat(employeeController).isNotNull();
	}

}

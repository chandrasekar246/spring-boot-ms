package com.github.chandrasekar246.ems;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.chandrasekar246.ems.controller.EmployeeController;

@SpringBootTest
class EMSApplicationTests {
	
	@Autowired
	private EmployeeController employeeController;

	@Test
	void contextLoads() {
		
		assertThat(employeeController).isNotNull();
	}

}


package com.github.chandrasekar246.spring.sample.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = { "com.github.chandrasekar246.spring.sample.aop" })
@EnableAspectJAutoProxy
public class DIConfiguration {

	@Autowired
	private Employee employee;

	@Bean
	public EmployeeService employeeService() {
		EmployeeService employeeService = new EmployeeService();
		employeeService.setEmployee(employee);
		return employeeService;
	}
}


package com.github.chandrasekar246.spring.sample.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);

		EmployeeService employeeService = context.getBean("employeeService", EmployeeService.class);

		employeeService.getEmployee().setName("Chandra");

		System.out.println(employeeService.getEmployee().getName());

		employeeService.getEmployee().throwException();

		context.close();
	}
}

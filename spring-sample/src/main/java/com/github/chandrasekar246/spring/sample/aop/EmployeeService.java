
package com.github.chandrasekar246.spring.sample.aop;

import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeService {

	@Autowired
	private Employee employee;
	
	public Employee getEmployee(){
		return this.employee;
	}
	
	public void setEmployee(Employee e){
		this.employee=e;
	}
}

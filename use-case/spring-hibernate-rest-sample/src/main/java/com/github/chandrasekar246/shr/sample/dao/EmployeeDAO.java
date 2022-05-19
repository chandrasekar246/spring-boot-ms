package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;

import com.github.chandrasekar246.shr.sample.entity.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee employee);
	
	public void updateEmployee(Employee employee);
	
	public Employee getEmployeeById(int id);
	
	public void removeEmployee(int id);
	
	public List<Employee> listEmployees();

}
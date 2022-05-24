package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;

import com.github.chandrasekar246.shr.sample.entity.Employee2;

public interface Employee2DAO {
	
	public void addEmployee(Employee2 employee2);
	
	public void updateEmployee(Employee2 employee2);
	
	public Employee2 getEmployeeById(int id);
	
	public void removeEmployee(int id);
	
	public List<Employee2> listEmployees();

}
package com.github.chandrasekar246.shr.sample.service;

import java.util.List;

import com.github.chandrasekar246.shr.sample.entity.Employee;

public interface EmployeeService {

	public void addEmployee(Employee employee);

	public void updateEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public void removeEmployee(int id);

	public List<Employee> listEmployees();

}
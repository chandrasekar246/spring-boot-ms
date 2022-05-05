package com.github.chandrasekar246.helloworld.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.github.chandrasekar246.helloworld.model.Department;
import com.github.chandrasekar246.helloworld.model.Employee;

@Service
public class EmployeeService {

	private Set<Employee> employees = new HashSet<>(Arrays.asList(new Employee(1, "Alan", 5, Department.BFSI),
			new Employee(2, "Bala", 3, Department.ERS), new Employee(3, "Chandra", 10, Department.HEALTHCARE)));

	public Set<Employee> findAllEmployees() {
		return employees;
	}

	public Employee findEmployeeById(int id) {
			return employees.stream().filter(e -> (e.getId() == id)).findFirst().get();
	}

	public void addEmployee(Employee employee) {
		employees.add(employee);
	}

	public void deleteEmployeeById(int id) {
		employees.removeIf(e -> (e.getId() == id));
	}
}

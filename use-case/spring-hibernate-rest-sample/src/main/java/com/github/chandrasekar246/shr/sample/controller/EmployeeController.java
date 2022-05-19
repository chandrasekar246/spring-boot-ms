package com.github.chandrasekar246.shr.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.shr.sample.entity.Employee;
import com.github.chandrasekar246.shr.sample.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

}

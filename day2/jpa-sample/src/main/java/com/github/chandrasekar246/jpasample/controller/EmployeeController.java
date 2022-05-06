package com.github.chandrasekar246.jpasample.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.jpasample.entity.Employee;
import com.github.chandrasekar246.jpasample.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping
	public List<Employee> findAllEmployees() {
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/sort/{columnName}")
	public List<Employee> findAllEmployeesWithSort(@PathVariable String columnName) {
		return employeeService.findAllEmployeesWithSort(columnName);
	}
	
	@GetMapping("/page/{size}")
	public Page<Employee> findAllEmployeesWithPage(@PathVariable Integer size) {
		return employeeService.findAllEmployeesWithPage(size);
	}
	
	@GetMapping("/id/{id}")
	public Optional<Employee> findEmployeeById(@PathVariable int id) {
		return employeeService.findEmployeeById(id);
	}
	
	@GetMapping("/name/{name}")
	public List<Employee> findEmployeeByName(@PathVariable String name) {
		return employeeService.findEmployeeByName(name);
	}
	
	@GetMapping("/search/name/{name}")
	public List<Employee> findEmployeeByNamePattern(@PathVariable String name) {
		return employeeService.findEmployeeByNamePattern(name);
	}
	
	@PostMapping
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		
		return new ResponseEntity<>(HttpStatus.GONE);
	}

}

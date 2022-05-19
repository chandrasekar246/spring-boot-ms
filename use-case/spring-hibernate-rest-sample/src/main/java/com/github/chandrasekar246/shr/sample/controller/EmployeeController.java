package com.github.chandrasekar246.shr.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.shr.sample.entity.Employee;
import com.github.chandrasekar246.shr.sample.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> listEmployees() {
		return employeeService.listEmployees();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee employee) {
		employeeService.updateEmployee(employee);
	}

	@DeleteMapping(path = "/{id}")
	public void removeEmployee(@PathVariable int id) {
		employeeService.removeEmployee(id);
	}

}

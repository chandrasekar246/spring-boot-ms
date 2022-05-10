package com.github.chandrasekar246.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.ems.entity.Employee;
import com.github.chandrasekar246.ems.model.EmployeeDTO;
import com.github.chandrasekar246.ems.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Employee> findAll() {
		return employeeService.findAll();
	}

	@GetMapping("/sort/{columnName}")
	public List<Employee> findAllWithSort(@PathVariable String columnName) {
		return employeeService.findAllWithSort(columnName);
	}

	@GetMapping("/page/{size}")
	public Page<Employee> findAllWithPage(@PathVariable Integer size) {
		return employeeService.findAllWithPage(size);
	}

	@GetMapping("/{id}")
	public Employee findById(@PathVariable int id) {
		return employeeService.findById(id);
	}

	@GetMapping("/name/{name}")
	public List<Employee> findByName(@PathVariable String name) {
		return employeeService.findByFirstName(name);
	}

	@GetMapping("/pattern/name/{name}")
	public List<Employee> findByNamePattern(@PathVariable String name) {
		return employeeService.findByFirstNamePattern(name);
	}

	@PostMapping
	public ResponseEntity<Employee> add(@Valid @RequestBody EmployeeDTO employeeDto) {

		Employee employee = modelMapper.map(employeeDto, Employee.class);

		employee = employeeService.add(employee);

		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@Valid @RequestBody EmployeeDTO employeeDto, @PathVariable int id) {

		Employee employee = modelMapper.map(employeeDto, Employee.class);

		employee = employeeService.update(employee, id);

		return new ResponseEntity<Employee>(employee, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		return employeeService.deleteById(id);
	}

	@DeleteMapping
	public String deleteAll() {
		return employeeService.deleteAll();
	}
}

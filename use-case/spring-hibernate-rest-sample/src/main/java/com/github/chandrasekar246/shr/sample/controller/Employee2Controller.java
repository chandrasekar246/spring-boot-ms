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

import com.github.chandrasekar246.shr.sample.entity.Address;
import com.github.chandrasekar246.shr.sample.entity.Employee2;
import com.github.chandrasekar246.shr.sample.service.AddressService;
import com.github.chandrasekar246.shr.sample.service.Employee2Service;

@RestController
@RequestMapping("/employees/v2")
public class Employee2Controller {

	@Autowired
	private Employee2Service employee2Service;

	@Autowired
	private AddressService addressService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> addEmployee(@RequestBody Employee2 employee2) {
		employee2Service.addEmployee(employee2);

		Address address = new Address(null, employee2.getAddress().getAddressLine1(),
				employee2.getAddress().getAddressLine2(), employee2.getAddress().getPincode(), employee2);

		addressService.addAddress(address);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee2> listEmployees() {
		return employee2Service.listEmployees();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Employee2 getEmployeeById(@PathVariable int id) {
		return employee2Service.getEmployeeById(id);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateEmployee(@RequestBody Employee2 employee2) {
		employee2Service.updateEmployee(employee2);
	}

	@DeleteMapping(path = "/{id}")
	public void removeEmployee(@PathVariable int id) {
		employee2Service.removeEmployee(id);
	}

}

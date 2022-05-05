package com.github.chandrasekar246.jpasample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.jpasample.entity.Employee;
import com.github.chandrasekar246.jpasample.repository.EmployeeCrudRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeCrudRepository crudRepository;


	public List<Employee> findAllEmployees() {
		return (List<Employee>) crudRepository.findAll();
	}

}

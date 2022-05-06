package com.github.chandrasekar246.jpasample.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.jpasample.entity.Employee;
import com.github.chandrasekar246.jpasample.repository.EmployeeCrudRepository;
import com.github.chandrasekar246.jpasample.repository.EmployeePageRepository;

@Service
public class EmployeeService {
	
	private EmployeeCrudRepository crudRepository;
	
	private EmployeePageRepository pageRepository;
	
	public EmployeeService(EmployeeCrudRepository crudRepository, EmployeePageRepository pageRepository) {
		this.crudRepository = crudRepository;
		this.pageRepository = pageRepository;
	}
	
	public List<Employee> findAllEmployees() {
		return (List<Employee>) crudRepository.findAll();
	}
	
	public List<Employee> findAllEmployeesSort() {
		return (List<Employee>) crudRepository.findAll();
	}

	public Optional<Employee> findEmployeeById(int id) {
		return crudRepository.findById(id);
	}

	public void addEmployee(Employee employee) {
		crudRepository.save(employee);
	}

	public void deleteEmployeeById(int id) {
		crudRepository.deleteById(id);
	}

	public List<Employee> findEmployeeByName(String name) {
		return crudRepository.findByName(name);
	}
	
	public List<Employee> findEmployeeByNamePattern(String name) {
		return crudRepository.findByNameContains(name);
	}

	public List<Employee> findAllEmployeesWithSort(String columnName) {
		return (List<Employee>) pageRepository.findAll(Sort.by(columnName));
	}
	
	public Page<Employee> findAllEmployeesWithPage(Integer page) {
		return (Page<Employee>) pageRepository.findAll(Pageable.ofSize(page));
	}

}

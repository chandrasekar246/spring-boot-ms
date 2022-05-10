package com.github.chandrasekar246.ems.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.ems.entity.Employee;
import com.github.chandrasekar246.ems.exception.InvalidDepartmentException;
import com.github.chandrasekar246.ems.exception.InvalidEmployeeIDException;
import com.github.chandrasekar246.ems.repository.EmployeeCrudRepository;
import com.github.chandrasekar246.ems.repository.EmployeePageRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeCrudRepository crudRepository;

	@Autowired
	private EmployeePageRepository pageRepository;

	private static final String[] VALID_DEPATMENTS = { "BFSI", "RTL", "HC" };

	public List<Employee> findAll() {
		return (List<Employee>) crudRepository.findAll();
	}

	public Employee findById(int id) {
		return crudRepository.findById(id)
				.orElseThrow(() -> new InvalidEmployeeIDException("Unknown employee ID: " + id));
	}

	public List<Employee> findByFirstName(String name) {
		return crudRepository.findByFirstName(name);
	}

	public List<Employee> findByFirstNamePattern(String name) {
		return crudRepository.findByFirstNameContains(name);
	}
	
	public List<Employee> findByLastNamePattern(String name) {
		return crudRepository.findByLastNameLike(name);
	}

	public Employee add(Employee employee) {

		long count = Arrays.asList(VALID_DEPATMENTS).stream().filter(e -> e.equalsIgnoreCase(employee.getDepartment()))
				.count();

		if (count <= 0) {
			throw new InvalidDepartmentException("Unknown department: " + employee.getDepartment());
		}

		return crudRepository.save(employee);
	}

	public Employee update(Employee employee, int id) {
		if (id == employee.getId()) {
			return crudRepository.save(employee);
		} else {
			throw new InvalidEmployeeIDException("Unknown employee ID: " + id);
		}
	}

	public String deleteById(int id) {
		crudRepository.deleteById(id);

		return new StringBuilder("Employee record with ID: ").append(id).append(" is deleted!").toString();
	}

	public String deleteAll() {
		crudRepository.deleteAll();

		return "All employee records has been deleted!";
	}

	public List<Employee> findAllWithSort(String columnName) {
		return (List<Employee>) pageRepository.findAll(Sort.by(columnName));
	}

	public Page<Employee> findAllWithPage(Integer page) {
		return (Page<Employee>) pageRepository.findAll(Pageable.ofSize(page));
	}
}

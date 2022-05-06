package com.github.chandrasekar246.jpasample.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.jpasample.entity.Employee;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findByName(String name);
	
	List<Employee> findByNameContains(String name);
}

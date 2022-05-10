package com.github.chandrasekar246.ems.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.ems.entity.Employee;

@Repository
public interface EmployeePageRepository extends PagingAndSortingRepository<Employee, Integer> {
	
}

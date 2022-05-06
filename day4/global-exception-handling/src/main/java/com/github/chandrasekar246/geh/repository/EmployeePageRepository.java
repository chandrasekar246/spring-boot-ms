package com.github.chandrasekar246.geh.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.geh.entity.Employee;

@Repository
public interface EmployeePageRepository extends PagingAndSortingRepository<Employee, Integer> {
	
}

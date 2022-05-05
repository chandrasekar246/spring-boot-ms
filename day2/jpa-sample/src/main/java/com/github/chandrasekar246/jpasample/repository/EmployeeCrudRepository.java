package com.github.chandrasekar246.jpasample.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.jpasample.entity.Employee;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {

}

package com.github.chandrasekar246.ems.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.ems.entity.Employee;

@Repository
public interface EmployeeCrudRepository extends CrudRepository<Employee, Integer> {
	List<Employee> findByFirstName(String name);
	
	List<Employee> findByFirstNameContains(String name);
	
	@Query("SELECT e FROM Employee e WHERE e.lastName LIKE %:name%")
	List<Employee> findByLastNameLike(@Param("name")  String name);
}

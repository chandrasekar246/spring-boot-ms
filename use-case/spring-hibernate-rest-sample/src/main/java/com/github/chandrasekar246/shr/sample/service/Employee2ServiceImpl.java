package com.github.chandrasekar246.shr.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.shr.sample.dao.Employee2DAO;
import com.github.chandrasekar246.shr.sample.entity.Employee2;

@Service
public class Employee2ServiceImpl implements Employee2Service {

	@Autowired
	private Employee2DAO employee2DAO;

	@Override
	public void addEmployee(Employee2 employee2) {
		employee2DAO.addEmployee(employee2);
	}

	@Override
	public void updateEmployee(Employee2 employee2) {
		employee2DAO.updateEmployee(employee2);
	}

	@Override
	public List<Employee2> listEmployees() {
		return this.employee2DAO.listEmployees();
	}

	@Override
	public Employee2 getEmployeeById(int id) {
		return employee2DAO.getEmployeeById(id);
	}

	@Override
	public void removeEmployee(int id) {
		employee2DAO.removeEmployee(id);
	}

}

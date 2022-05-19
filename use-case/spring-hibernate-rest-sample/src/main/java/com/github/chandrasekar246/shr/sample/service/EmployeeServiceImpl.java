package com.github.chandrasekar246.shr.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.shr.sample.dao.EmployeeDAO;
import com.github.chandrasekar246.shr.sample.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void addEmployee(Employee employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		return this.employeeDAO.listEmployees();
	}

	@Override
	public Employee getEmployeeById(int id) {
		return employeeDAO.getEmployeeById(id);
	}

	@Override
	public void removeEmployee(int id) {
		employeeDAO.removeEmployee(id);
	}

}

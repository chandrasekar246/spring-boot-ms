package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.shr.sample.entity.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();

		session.persist(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();

		session.merge(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery("from Employee", Employee.class).list();
	}

	@Override
	public Employee getEmployeeById(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Employee.class, Integer.valueOf(id));
	}

	@Override
	public void removeEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();

		Employee employee = session.get(Employee.class, Integer.valueOf(id));

		if (Objects.nonNull(employee)) {
			session.remove(employee);
		}
	}

}

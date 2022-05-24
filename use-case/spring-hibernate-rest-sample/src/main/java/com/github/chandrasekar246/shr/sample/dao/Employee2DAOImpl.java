package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.shr.sample.entity.Employee2;

@Repository
@Transactional
public class Employee2DAOImpl implements Employee2DAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addEmployee(Employee2 employee2) {
		Session session = sessionFactory.getCurrentSession();

		session.persist(employee2);
	}

	@Override
	public void updateEmployee(Employee2 employee2) {
		Session session = sessionFactory.getCurrentSession();

		session.merge(employee2);
	}

	@Override
	public List<Employee2> listEmployees() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery("from EnhancedEmployee", Employee2.class).list();
	}

	@Override
	public Employee2 getEmployeeById(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Employee2.class, Integer.valueOf(id));
	}

	@Override
	public void removeEmployee(int id) {
		Session session = sessionFactory.getCurrentSession();

		Employee2 employee2 = session.get(Employee2.class, Integer.valueOf(id));

		if (Objects.nonNull(employee2)) {
			session.remove(employee2);
		}
	}

}

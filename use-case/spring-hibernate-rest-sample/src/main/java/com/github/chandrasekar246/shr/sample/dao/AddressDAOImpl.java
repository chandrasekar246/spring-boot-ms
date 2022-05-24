package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.shr.sample.entity.Address;

@Repository
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();

		session.persist(address);
	}

	@Override
	public void updateAddress(Address address) {
		Session session = sessionFactory.getCurrentSession();

		session.merge(address);
	}

	@Override
	public List<Address> listAddress() {
		Session session = sessionFactory.getCurrentSession();

		return session.createQuery("from Address", Address.class).list();
	}

	@Override
	public Address getAddressById(int id) {
		Session session = sessionFactory.getCurrentSession();

		return session.get(Address.class, Integer.valueOf(id));
	}

	@Override
	public void removeAddress(int id) {
		Session session = sessionFactory.getCurrentSession();

		Address address = session.get(Address.class, Integer.valueOf(id));

		if (Objects.nonNull(address)) {
			session.remove(address);
		}
	}

}

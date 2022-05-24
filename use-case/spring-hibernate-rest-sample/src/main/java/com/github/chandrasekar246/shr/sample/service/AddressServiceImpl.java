package com.github.chandrasekar246.shr.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.shr.sample.dao.AddressDAO;
import com.github.chandrasekar246.shr.sample.entity.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressDAO addressDAO;

	@Override
	public void addAddress(Address address) {
		addressDAO.addAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		addressDAO.updateAddress(address);
	}

	@Override
	public Address getAddressById(int id) {
		return addressDAO.getAddressById(id);
	}

	@Override
	public void removeAddress(int id) {
		addressDAO.removeAddress(id);
	}

	@Override
	public List<Address> listAddress() {
		return addressDAO.listAddress();
	}
}
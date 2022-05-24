package com.github.chandrasekar246.shr.sample.dao;

import java.util.List;

import com.github.chandrasekar246.shr.sample.entity.Address;

public interface AddressDAO {

	public void addAddress(Address address);

	public void updateAddress(Address address);

	public Address getAddressById(int id);

	public void removeAddress(int id);

	public List<Address> listAddress();

}
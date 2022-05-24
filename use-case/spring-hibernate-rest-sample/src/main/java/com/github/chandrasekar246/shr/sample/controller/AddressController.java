package com.github.chandrasekar246.shr.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.shr.sample.entity.Address;
import com.github.chandrasekar246.shr.sample.service.AddressService;

@RestController
@RequestMapping("/addresss")
public class AddressController {

	@Autowired
	private AddressService addressService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HttpStatus> addAddress(@RequestBody Address address) {
		addressService.addAddress(address);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Address> listAddress() {
		return addressService.listAddress();
	}

	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Address getAddressById(@PathVariable int id) {
		return addressService.getAddressById(id);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public void updateAddress(@RequestBody Address address) {
		addressService.updateAddress(address);
	}

	@DeleteMapping(path = "/{id}")
	public void removeAddress(@PathVariable int id) {
		addressService.removeAddress(id);
	}

}

package com.github.chandrasekar246.banking.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.banking.entity.Beneficiary;
import com.github.chandrasekar246.banking.model.BeneficiaryDTO;
import com.github.chandrasekar246.banking.service.BeneficiaryService;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

	@Autowired
	private BeneficiaryService beneficiaryService;

	@Autowired
	private ModelMapper modelMapper;

	@GetMapping
	public List<Beneficiary> findAll() {
		return beneficiaryService.findAll();
	}

	@GetMapping("/{id}")
	public Beneficiary findById(@PathVariable int id) {
		return beneficiaryService.findById(id);
	}

	@PostMapping
	public ResponseEntity<Beneficiary> add(@Valid @RequestBody BeneficiaryDTO beneficiaryDTO) {

		var beneficiary = modelMapper.map(beneficiaryDTO, Beneficiary.class);

		beneficiary = beneficiaryService.add(beneficiary);

		return new ResponseEntity<>(beneficiary, HttpStatus.CREATED);
	}

}

package com.github.chandrasekar246.banking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.Beneficiary;
import com.github.chandrasekar246.banking.exception.BeneficiaryNotRegisteredException;
import com.github.chandrasekar246.banking.exception.InvalidBeneficiaryIdException;
import com.github.chandrasekar246.banking.repository.BeneficiaryRepository;

@Service
public class BeneficiaryService {

	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	@Autowired
	private AccountService accountService;

	public List<Beneficiary> findAll() {
		return (List<Beneficiary>) beneficiaryRepository.findAll();
	}

	public Beneficiary findById(int id) {
		return beneficiaryRepository.findById(id)
				.orElseThrow(() -> new InvalidBeneficiaryIdException("Unknown beneficiary ID: " + id));
	}

	public Beneficiary add(Beneficiary beneficiary) {

		accountService.findByAccountNumber(beneficiary.getOwnerAccountNumber());

		accountService.findByAccountNumber(beneficiary.getBeneficiaryAccountNumber());

		return beneficiaryRepository.save(beneficiary);
	}

	public Beneficiary findByOwnerAccountNumberAndBeneficiaryAccountNumber(String ownerAccountNumber,
			String beneficiaryAccountNumber) {
		return beneficiaryRepository
				.findByOwnerAccountNumberAndBeneficiaryAccountNumber(ownerAccountNumber, beneficiaryAccountNumber)
				.orElseThrow(
						() -> new BeneficiaryNotRegisteredException("Beneficiary not registered. Owner AccountNumber: "
								+ ownerAccountNumber + ", Beneficiary AccountNumber: " + beneficiaryAccountNumber));
	}

}

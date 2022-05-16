package com.github.chandrasekar246.banking.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.banking.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends CrudRepository<Beneficiary, Integer> {

	Optional<Beneficiary> findByOwnerAccountNumberAndBeneficiaryAccountNumber(String ownerAccountNumber,
			String beneficiaryAccountNumber);
}

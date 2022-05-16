package com.github.chandrasekar246.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.banking.entity.TransactionHistory;
import com.github.chandrasekar246.banking.exception.InsufficientBalanceException;
import com.github.chandrasekar246.banking.model.AmountTransferDTO;

@Service
public class AmountTransferService {

	@Autowired
	private TransactionHistoryService transactionHistoryService;

	@Autowired
	private AccountService accountService;

	@Autowired
	private BeneficiaryService beneficiaryService;

	public TransactionHistory transfer(AmountTransferDTO amountTransferDTO) {
		beneficiaryService.findByOwnerAccountNumberAndBeneficiaryAccountNumber(
				amountTransferDTO.getOwnerAccountNumber(), amountTransferDTO.getBeneficiaryAccountNumber());

		double availableAmountWithOwner = accountService.getAccountBalance(amountTransferDTO.getOwnerAccountNumber());

		if (availableAmountWithOwner < amountTransferDTO.getAmount()) {
			throw new InsufficientBalanceException("Insufficient balance! Available amount: " + availableAmountWithOwner
					+ ", Transfer amount: " + amountTransferDTO.getAmount());
		}

		accountService.updateAmount(amountTransferDTO.getOwnerAccountNumber(),
				availableAmountWithOwner - amountTransferDTO.getAmount());

		double availableAmountWithBeneficiary = accountService
				.getAccountBalance(amountTransferDTO.getBeneficiaryAccountNumber());

		accountService.updateAmount(amountTransferDTO.getBeneficiaryAccountNumber(),
				availableAmountWithBeneficiary + amountTransferDTO.getAmount());

		return transactionHistoryService.add(new TransactionHistory(0, amountTransferDTO.getOwnerAccountNumber(),
				amountTransferDTO.getBeneficiaryAccountNumber(), amountTransferDTO.getAmount(), null));
	}

}

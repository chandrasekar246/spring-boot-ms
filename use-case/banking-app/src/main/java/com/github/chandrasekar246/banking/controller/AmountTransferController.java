package com.github.chandrasekar246.banking.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.banking.entity.TransactionHistory;
import com.github.chandrasekar246.banking.model.AmountTransferDTO;
import com.github.chandrasekar246.banking.service.AmountTransferService;

@RestController
@RequestMapping("/transfer")
public class AmountTransferController {

	@Autowired
	private AmountTransferService amountTransferService;

	@PostMapping
	public TransactionHistory transfer(@Valid @RequestBody AmountTransferDTO amountTransferDTO) {
		return amountTransferService.transfer(amountTransferDTO);
	}
}

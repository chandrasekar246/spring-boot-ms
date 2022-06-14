package com.github.chandrasekar246.hungerbox.service;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.github.chandrasekar246.hungerbox.model.AmountTransfer;
import com.github.chandrasekar246.hungerbox.model.TransactionHistory;

@FeignClient(name = "http://BANKING-APP/banking-app/transfer")
public interface BankingServiceClient {
	
	@PostMapping
	public TransactionHistory transfer(@Valid @RequestBody AmountTransfer amountTransfer);
}

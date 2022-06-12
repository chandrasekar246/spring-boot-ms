package com.github.chandrasekar246.hungerbox.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class AmountTransfer {

	private String ownerAccountNumber;

	private String beneficiaryAccountNumber;
	
	private double amount;
}

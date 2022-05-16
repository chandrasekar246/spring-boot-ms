package com.github.chandrasekar246.banking.model;

import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class BeneficiaryDTO {

	private int id;

	@Pattern(regexp = "[0-9]{6}", message = "Account number should be 6 digits!")
	private String ownerAccountNumber;

	@Pattern(regexp = "[0-9]{6}", message = "Account number should be 6 digits!")
	private String beneficiaryAccountNumber;
}

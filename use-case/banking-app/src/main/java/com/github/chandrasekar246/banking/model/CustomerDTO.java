package com.github.chandrasekar246.banking.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class CustomerDTO {

	private int id;

	@NotBlank
	@Size(min = 3, max = 30)
	private String name;

	@NotBlank
	@Size(min = 10, max = 50)
	private String address;

	private String company;

	@Pattern(regexp = "^[A-Z]{1}-[0-9]{7}$", message = "Passport number format is invalid! Valid ex. A-1234567")
	private String passport;

	@NotBlank
	@Email
	private String email;

	@Pattern(regexp = "^[6-9]\\d{9}$", message = "Mobile number format is invalid! Valid ex. 9876543210")
	private String mobile;

	@Pattern(regexp = "^[a-z0-9]{6,12}$", message = "username format is invalid! Allowed: Small-case alphabets, numerics with 6 to 12 chars Valid ex. chandra123")
	private String username;

	private String password;
}

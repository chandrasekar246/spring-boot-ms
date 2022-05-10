package com.github.chandrasekar246.ems.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class EmployeeDTO {

	private int id;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String firstName;
	
	@NotBlank
	@Size(min = 3, max = 30)
	private String lastName;
	
	@Positive
	private int experience;
	
	@NotBlank
	private String department;
	
	@NotBlank
	@Email
	private String email;

	@Past
	private LocalDate dateOfBirth;
	
	@Min(value = 10000)
	@Max(value = 100000)
	private double salary;

}

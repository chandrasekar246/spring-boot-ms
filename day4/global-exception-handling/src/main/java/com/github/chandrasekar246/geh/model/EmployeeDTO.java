package com.github.chandrasekar246.geh.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PastOrPresent;
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
	
	@Size(min = 3, max = 30)
	private String name;
	
	@Min(value = 3)
	@Max(value = 60)
	private int experience;
	
	@NotNull
	private String department;
	
	@Email
	private String email;

	@Past
	private Date dateOfBirth;
	
	@PastOrPresent
	private Date dateOfJoining;
	
	@FutureOrPresent
	private Date nextReviewDate;
	
	@Positive
	private double salary;

}

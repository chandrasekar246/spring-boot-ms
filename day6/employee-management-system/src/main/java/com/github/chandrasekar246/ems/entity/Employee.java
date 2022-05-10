package com.github.chandrasekar246.ems.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "f_name")
	private String firstName;

	@Column(name = "l_name")
	private String lastName;

	private int experience;

	private String department;

	private String email;

	@Column(name = "dob")
	private LocalDate dateOfBirth;

	private double salary;
}

package com.github.chandrasekar246.geh.entity;

import java.util.Date;

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

	private String name;

	@Column(name = "exp")
	private int experience;

	private String department;

	private String email;

	private Date dateOfBirth;

	private Date dateOfJoining;

	private Date nextReviewDate;

	private double salary;

}

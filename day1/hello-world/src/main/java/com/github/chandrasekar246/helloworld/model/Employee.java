package com.github.chandrasekar246.helloworld.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Employee {

	@EqualsAndHashCode.Include
	private int id;
	private String name;
	private int experience;
	private Department department;

}

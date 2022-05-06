package com.github.chandrasekar246.geh.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Employee {

	private int id;
	
	@Size(min = 3, max = 30)
	private String name;
	
	@Min(value = 3)
	@Max(value = 60)
	private int experience;
	
	
	private String department;

}

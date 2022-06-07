package com.github.chandrasekar246.java8.demo.uc3;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

	private String rollNumber;
	private String name;
	private List<Course> courseEnrolled;
	private Map<String, Double> score;
}

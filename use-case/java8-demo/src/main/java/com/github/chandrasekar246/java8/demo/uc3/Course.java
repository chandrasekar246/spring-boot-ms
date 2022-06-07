package com.github.chandrasekar246.java8.demo.uc3;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Course {

	private String id;
	private String title;
	private LocalDate startDate;
	private LocalDate endDate;
}

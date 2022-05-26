package com.github.chandrasekar246.feign.usersvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class Book {

	private Integer id;

	private String title;

	private String isbn;
	
	private boolean available;
}

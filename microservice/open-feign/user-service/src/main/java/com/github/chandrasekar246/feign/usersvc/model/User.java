package com.github.chandrasekar246.feign.usersvc.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.EqualsAndHashCode.Exclude;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class User {

	@Exclude
	private Integer id;

	@Exclude
	private String name;

	private String email;
	
	private List<Book> booksTaken;
}

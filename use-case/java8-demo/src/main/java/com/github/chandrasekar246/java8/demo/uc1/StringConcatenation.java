package com.github.chandrasekar246.java8.demo.uc1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringConcatenation {
	
	public static void main(String[] args) {
		
		List<String> planetList = Arrays.asList("Mercury", "Venus", "Earth");
		
		String planets = planetList.stream().collect(Collectors.joining(", ", "Planets: ", ""));
		
		System.out.println(planets);
	}

}

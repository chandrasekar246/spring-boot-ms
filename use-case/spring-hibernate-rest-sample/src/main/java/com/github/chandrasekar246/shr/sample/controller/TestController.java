package com.github.chandrasekar246.shr.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.shr.sample.config.AppPropertiesConfiguration;

@RestController
@RequestMapping("/")
public class TestController {
	
	@Autowired
	private AppPropertiesConfiguration appPropertiesConfiguration;

	@GetMapping
	public String test() {
		return appPropertiesConfiguration.getTestString();
	}

}

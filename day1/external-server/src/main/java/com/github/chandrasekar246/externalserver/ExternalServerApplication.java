package com.github.chandrasekar246.externalserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExternalServerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ExternalServerApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ExternalServerApplication.class);
	}
	
}

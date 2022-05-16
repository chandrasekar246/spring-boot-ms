package com.github.chandrasekar246.banking;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.github.chandrasekar246.banking.config.JwtAuthenticationFilter;

@SpringBootApplication
public class BankingApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BankingApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("********** Application started... **********");
		
		SpringApplication.run(BankingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public JwtAuthenticationFilter authenticationTokenFilterBean() {
		return new JwtAuthenticationFilter();
	}
}

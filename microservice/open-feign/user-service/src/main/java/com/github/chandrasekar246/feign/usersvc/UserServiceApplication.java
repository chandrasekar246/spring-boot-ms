package com.github.chandrasekar246.feign.usersvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class UserServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("********** Application started... **********");
		
		SpringApplication.run(UserServiceApplication.class, args);
	}

}

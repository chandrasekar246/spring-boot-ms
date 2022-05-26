package com.github.chandrasekar246.feign.booksvc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookServiceApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceApplication.class);

	public static void main(String[] args) {
		
		LOGGER.info("********** Application started... **********");
		
		SpringApplication.run(BookServiceApplication.class, args);
	}

}

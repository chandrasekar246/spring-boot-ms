package com.github.chandrasekar246.geh;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GehSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GehSampleApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}

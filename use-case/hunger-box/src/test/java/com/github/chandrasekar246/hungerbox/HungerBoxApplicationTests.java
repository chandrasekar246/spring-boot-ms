package com.github.chandrasekar246.hungerbox;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.chandrasekar246.hungerbox.controller.OrderController;

@SpringBootTest
class HungerBoxApplicationTests {
	
	@Autowired
	private OrderController controller;

	@Test
	void contextLoads() {
		
		assertThat(controller).isNotNull();
	}

}

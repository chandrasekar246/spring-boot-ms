package com.github.chandrasekar246.hungerbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.hungerbox.HungerBoxApplication;
import com.github.chandrasekar246.hungerbox.model.FoodMenu;
import com.github.chandrasekar246.hungerbox.service.FoodMenuServiceClient;

@RestController
@RequestMapping("/item")
public class ItemSearchController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HungerBoxApplication.class);

	@Autowired
	private FoodMenuServiceClient foodMenuServiceClient;

	@GetMapping
	public List<FoodMenu> findAll() {
		LOGGER.debug("Getting all the food menu items from spring-batch-demo...");
		
		return foodMenuServiceClient.findAll();
	}

	@GetMapping("/search/{itemPattern}")
	public List<FoodMenu> findById(@PathVariable String itemPattern) {
		LOGGER.debug("Getting the matched food menu items from spring-batch-demo...");
		
		return foodMenuServiceClient.findByItemLike(itemPattern);
	}
}

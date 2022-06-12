package com.github.chandrasekar246.hungerbox.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.hungerbox.HungerBoxApplication;
import com.github.chandrasekar246.hungerbox.entity.OrderEntity;
import com.github.chandrasekar246.hungerbox.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	private static final Logger LOGGER = LoggerFactory.getLogger(HungerBoxApplication.class);

	@Autowired
	private OrderService service;

	@GetMapping
	public List<OrderEntity> findAll() {
		LOGGER.debug("Getting all the orders...");

		List<OrderEntity> entities = service.findAll();

		LOGGER.debug("List of order from database: {}", entities);

		return entities;
	}

	@GetMapping("{id}")
	public OrderEntity findById(@PathVariable Long id) {
		LOGGER.debug("Getting order details for Order ID : {}", id);

		OrderEntity entity = service.findById(id);

		LOGGER.debug("Order details : {}", entity);

		return entity;
	}

	@PostMapping
	public OrderEntity save(@RequestBody OrderEntity entity) {
		LOGGER.debug("Saving order with details: {}", entity);

		OrderEntity result = service.save(entity);

		LOGGER.debug("Order details : {}", result);

		return result;
	}
}

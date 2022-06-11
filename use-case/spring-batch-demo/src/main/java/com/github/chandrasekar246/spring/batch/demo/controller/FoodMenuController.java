package com.github.chandrasekar246.spring.batch.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;
import com.github.chandrasekar246.spring.batch.demo.service.FoodMenuService;

@RestController
@RequestMapping("/food-menu")
public class FoodMenuController {

	@Autowired
	private FoodMenuService service;

	@GetMapping
	public List<FoodMenu> findAll() {
		return service.findAll();
	}
	
	@GetMapping("/search/{itemPattern}")
	public List<FoodMenu> findByItemLike(@PathVariable String itemPattern) {
		return service.findByItemContaining(itemPattern);
	}
}
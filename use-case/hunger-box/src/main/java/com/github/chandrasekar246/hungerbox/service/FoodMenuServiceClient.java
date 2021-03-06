package com.github.chandrasekar246.hungerbox.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.github.chandrasekar246.hungerbox.model.FoodMenu;

@FeignClient(name = "http://FOOD-MENU/food-menu/")
public interface FoodMenuServiceClient {
	
	@GetMapping
	public List<FoodMenu> findAll();
	
	@GetMapping("/{item}")
	public FoodMenu findByItem(@PathVariable String item);
	
	@GetMapping("/search/{itemPattern}")
	public List<FoodMenu> findByItemLike(@PathVariable String itemPattern);
}

package com.github.chandrasekar246.spring.batch.demo.batch;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;
import com.github.chandrasekar246.spring.batch.demo.repository.FoodMenuRepository;

@Component
public class Processor implements ItemProcessor<FoodMenu, FoodMenu> {

	@Autowired
	private FoodMenuRepository repository;

	@Override
	public FoodMenu process(FoodMenu menu) throws Exception {
		menu.setCreatedDateTime(LocalDateTime.now());
		menu.setUpdatedDateTime(LocalDateTime.now());
		
		Optional<FoodMenu> optionalMenu = repository.findByItem(menu.getItem());
		
		if (optionalMenu.isPresent()) {
			FoodMenu updatedFoodMenu = optionalMenu.get();
			
			updatedFoodMenu.setUpdatedDateTime(LocalDateTime.now());
			updatedFoodMenu.setPrice(menu.getPrice());
			
			menu = updatedFoodMenu;
		}
		
		return menu;
	}

}

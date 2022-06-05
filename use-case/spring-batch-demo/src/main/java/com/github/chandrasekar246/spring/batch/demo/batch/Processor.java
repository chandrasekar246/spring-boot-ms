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
		Optional<FoodMenu> optionalMenu = repository.findByItem(menu.getItem());
		menu.setUpdatedDateTime(LocalDateTime.now());
		if (!optionalMenu.isPresent()) {
			menu.setCreatedDateTime(LocalDateTime.now());
		}
		return menu;
	}

}

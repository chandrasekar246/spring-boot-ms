package com.github.chandrasekar246.spring.batch.demo.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;
import com.github.chandrasekar246.spring.batch.demo.repository.FoodMenuRepository;


@Component
public class Writer implements ItemWriter<FoodMenu>{
	
	@Autowired
	private FoodMenuRepository repository;

	@Override
	@Transactional
	public void write(List<? extends FoodMenu> menus) throws Exception {
		repository.saveAll(menus);
		Thread.sleep(5000);
	}
	
}

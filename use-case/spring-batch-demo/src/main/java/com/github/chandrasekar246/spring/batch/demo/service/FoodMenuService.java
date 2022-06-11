package com.github.chandrasekar246.spring.batch.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;
import com.github.chandrasekar246.spring.batch.demo.repository.FoodMenuRepository;

@Service
public class FoodMenuService {

	@Autowired
	private FoodMenuRepository repository;
	
	public List<FoodMenu> findAll() {
		return repository.findAll();
	}
	
	public List<FoodMenu> findByItemContaining(String itemPattern) {
		return repository.findByItemContaining(itemPattern);
	}
}

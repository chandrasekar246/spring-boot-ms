package com.github.chandrasekar246.hungerbox.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.hungerbox.entity.OrderEntity;
import com.github.chandrasekar246.hungerbox.exception.InvalidOrderIdException;
import com.github.chandrasekar246.hungerbox.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<OrderEntity> findAll() {
		return (List<OrderEntity>) repository.findAll();
	}

	public OrderEntity findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new InvalidOrderIdException("Unknown account ID: " + id));
	}

	public OrderEntity save(OrderEntity entity) {
		return repository.save(entity);
	}
	
}

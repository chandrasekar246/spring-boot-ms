package com.github.chandrasekar246.hungerbox.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.hungerbox.entity.OrderItemMappingEntity;

@Repository
public interface OrderItemMappingRepository extends CrudRepository<OrderItemMappingEntity, String> {
	
}

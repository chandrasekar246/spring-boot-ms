package com.github.chandrasekar246.spring.batch.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;


public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {

	Optional<FoodMenu> findByItem(String item);
}

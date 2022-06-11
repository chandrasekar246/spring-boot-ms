package com.github.chandrasekar246.spring.batch.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.chandrasekar246.spring.batch.demo.entity.FoodMenu;

@Repository
public interface FoodMenuRepository extends JpaRepository<FoodMenu, Long> {

	Optional<FoodMenu> findByItem(String item);

	List<FoodMenu> findByItemContaining(String itemPattern);
}

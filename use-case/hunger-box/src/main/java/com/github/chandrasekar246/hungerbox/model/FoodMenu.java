package com.github.chandrasekar246.hungerbox.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class FoodMenu {

	private Long id;

	private String item;

	private String description;

	private Double price;

	private LocalDateTime createdDateTime;

	private LocalDateTime updatedDateTime;
}

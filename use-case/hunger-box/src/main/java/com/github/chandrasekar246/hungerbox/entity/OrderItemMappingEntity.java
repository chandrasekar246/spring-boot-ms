package com.github.chandrasekar246.hungerbox.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "order_item_mapping")
public class OrderItemMappingEntity {

	@Id
	@Column(name = "item_name")
	private String itemName;

	private Integer quantity;
}

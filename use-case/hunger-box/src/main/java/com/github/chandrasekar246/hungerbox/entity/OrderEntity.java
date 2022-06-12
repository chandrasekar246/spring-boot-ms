package com.github.chandrasekar246.hungerbox.entity;

import java.time.LocalDateTime;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Table(name = "my_order")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "order_item_mapping", joinColumns = {
			@JoinColumn(name = "order_id", referencedColumnName = "id") })
	@MapKeyColumn(name = "item_name")
	@Column(name = "quantity")
	private Map<String, Integer> itemQuantityMap;

	private Double amount;

	@CreationTimestamp
	private LocalDateTime createdDateTime;
	
	private String accountNumber;

	private Boolean paymentStatus;
}

package com.github.chandrasekar246.hungerbox.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderRequest {

	private Map<String, Integer> itemQuantityMap;

	private String accountNumber;
}

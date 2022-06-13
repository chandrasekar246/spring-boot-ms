package com.github.chandrasekar246.hungerbox.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.chandrasekar246.hungerbox.entity.OrderEntity;
import com.github.chandrasekar246.hungerbox.exception.InvalidOrderIdException;
import com.github.chandrasekar246.hungerbox.model.AmountTransfer;
import com.github.chandrasekar246.hungerbox.model.OrderRequest;
import com.github.chandrasekar246.hungerbox.repository.OrderRepository;

@Service
public class OrderService {

	@Value("${hungerBox.accountNumber}")
	private String hungerBoxAccountNumber;

	@Autowired
	private OrderRepository repository;

	@Autowired
	private BankingServiceClient bankingServiceClient;
	
	@Autowired
	private FoodMenuServiceClient foodMenuServiceClient;

	public List<OrderEntity> findAll() {
		return (List<OrderEntity>) repository.findAll();
	}

	public OrderEntity findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new InvalidOrderIdException("Unknown account ID: " + id));
	}

	public OrderEntity checkout(OrderRequest orderRequest) {

		double amount = calculateAmount(orderRequest.getItemQuantityMap());

		AmountTransfer amountTransfer = new AmountTransfer(orderRequest.getAccountNumber(), hungerBoxAccountNumber,
				amount);

		bankingServiceClient.transfer(amountTransfer);

		return repository.save(new OrderEntity(null, orderRequest.getItemQuantityMap(), amount, null,
				orderRequest.getAccountNumber(), true));
	}

	private double calculateAmount(Map<String, Integer> itemQuantityMap) {
		return itemQuantityMap.entrySet().stream().filter(entry -> entry.getValue() > 0)
				.mapToDouble(Map.Entry::getValue).sum();
	}

}

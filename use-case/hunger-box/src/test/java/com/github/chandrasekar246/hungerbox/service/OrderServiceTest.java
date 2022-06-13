package com.github.chandrasekar246.hungerbox.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.chandrasekar246.hungerbox.entity.OrderEntity;
import com.github.chandrasekar246.hungerbox.exception.InvalidOrderIdException;
import com.github.chandrasekar246.hungerbox.model.FoodMenu;
import com.github.chandrasekar246.hungerbox.model.OrderRequest;
import com.github.chandrasekar246.hungerbox.model.TransactionHistory;
import com.github.chandrasekar246.hungerbox.repository.OrderRepository;

@SpringBootTest(classes = OrderService.class)
class OrderServiceTest {

	@Value("${hungerBox.accountNumber}")
	private String hungerBoxAccountNumber;

	@Autowired
	private OrderService service;

	@MockBean
	private OrderRepository repository;

	@MockBean
	private BankingServiceClient bankingServiceClient;

	@MockBean
	private FoodMenuServiceClient foodMenuServiceClient;

	@Test
	void findByAllTest() throws Exception {

		List<OrderEntity> expectedOrderEntity = Arrays
				.asList(new OrderEntity((long) 1, getItemQuantityMap(), 100.0, LocalDateTime.now(), "123456", true));

		Mockito.when(repository.findAll()).thenReturn(expectedOrderEntity);

		List<OrderEntity> actualOrderEntity = service.findAll();

		assertEquals(expectedOrderEntity, actualOrderEntity);
	}

	@Test
	void findByIdTest() throws Exception {

		long id = 1;

		OrderEntity expectedOrderEntity = new OrderEntity(id, getItemQuantityMap(), 100.0, LocalDateTime.now(),
				"123456", true);

		Mockito.when(repository.findById(id)).thenReturn(Optional.of(expectedOrderEntity));

		OrderEntity actualOrderEntity = service.findById(id);

		assertEquals(expectedOrderEntity, actualOrderEntity);
	}

	@Test
	void findByIdNegativeTest() {

		long id = 1;

		Mockito.when(repository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(InvalidOrderIdException.class, () -> {
			service.findById(id);
		});

		String expectedMessage = "Unknown order ID: " + id;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	@Test
	void checkoutTest() throws Exception {

		long id = 1;

		OrderRequest orderRequest = new OrderRequest(getItemQuantityMap(), "123456");

		OrderEntity expectedOrderEntity = new OrderEntity(id, getItemQuantityMap(), 100.0, LocalDateTime.now(),
				"123456", true);

		Mockito.when(repository.save(any())).thenReturn(expectedOrderEntity);

		Mockito.when(foodMenuServiceClient.findByItem("idli")).thenReturn(
				new FoodMenu((long) 1, "idli", "idli with sambar", 40.0, LocalDateTime.now(), LocalDateTime.now()));
		
		Mockito.when(foodMenuServiceClient.findByItem("dosa")).thenReturn(
				new FoodMenu((long) 2, "dosa", "dosa with sambar", 60.0, LocalDateTime.now(), LocalDateTime.now()));

		Mockito.when(bankingServiceClient.transfer(any())).thenReturn(
				new TransactionHistory(1, "123456", hungerBoxAccountNumber, 100.0, LocalDateTime.now()));

		OrderEntity actualOrderEntity = service.checkout(orderRequest);

		assertEquals(expectedOrderEntity, actualOrderEntity);
	}

	private Map<String, Integer> getItemQuantityMap() {
		Map<String, Integer> itemQuantityMap = new HashMap<>();
		itemQuantityMap.put("idli", 1);
		itemQuantityMap.put("dosa", 1);
		return itemQuantityMap;
	}
}

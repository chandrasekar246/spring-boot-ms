package com.github.chandrasekar246.hungerbox.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandrasekar246.hungerbox.entity.OrderEntity;
import com.github.chandrasekar246.hungerbox.model.OrderRequest;
import com.github.chandrasekar246.hungerbox.service.OrderService;

@WebMvcTest(controllers = OrderController.class)
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OrderService service;

	private static ObjectMapper mapper;

	@BeforeAll
	public static void init() {
		mapper = new ObjectMapper();
	}

	@Test
	void findAllTest() throws Exception {

		List<OrderEntity> orderEntity = Arrays.asList(
				new OrderEntity((long) 1, getItemQuantityMap(), 100.0, LocalDateTime.now(), "123456", true),
				new OrderEntity((long) 2, getItemQuantityMap(), 100.0, LocalDateTime.now(), "654321", true));

		Mockito.when(service.findAll()).thenReturn(orderEntity);

		mockMvc.perform(get("/order")).andExpect(status().isOk())
				.andExpect(jsonPath("$.length()", Matchers.equalTo(2)));
	}

	@Test
	void findByIdTest() throws Exception {

		long id = 1;

		OrderEntity orderEntity = new OrderEntity(id, getItemQuantityMap(), 100.0, LocalDateTime.now(), "123456", true);

		Mockito.when(service.findById(id)).thenReturn(orderEntity);

		mockMvc.perform(get("/order/" + id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.amount", Matchers.equalTo(100.0)));
	}

	@Test
	void postTest() throws Exception {

		long id = 1;

		OrderRequest orderRequest = new OrderRequest(getItemQuantityMap(), "123456");

		OrderEntity orderEntity = new OrderEntity(id, getItemQuantityMap(), 100.0, LocalDateTime.now(), "123456", true);

		Mockito.when(service.checkout(ArgumentMatchers.any())).thenReturn(orderEntity);

		String jsonRequest = mapper.writeValueAsString(orderRequest);

		mockMvc.perform(post("/order/checkout").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.amount", Matchers.equalTo(100.0)));
	}

	private Map<String, Integer> getItemQuantityMap() {
		Map<String, Integer> itemQuantityMap = new HashMap<>();
		itemQuantityMap.put("idli", 1);
		itemQuantityMap.put("dosa", 1);
		return itemQuantityMap;
	}
}

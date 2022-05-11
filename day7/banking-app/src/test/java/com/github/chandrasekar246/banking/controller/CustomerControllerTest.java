package com.github.chandrasekar246.banking.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.github.chandrasekar246.banking.entity.Account;
import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.service.AccountService;
import com.github.chandrasekar246.banking.service.CustomerService;

@WebMvcTest(controllers = CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;
	
	@MockBean
	private AccountService accountService;

	private static ObjectMapper mapper;

	@BeforeAll
	public static void init() {
		mapper = new ObjectMapper();
	}

	@Test
	public void findByIdTest() throws Exception {

		int id = 1;

		Customer customer = createCustomer(id);

		Mockito.when(customerService.findById(id)).thenReturn(customer);

		mockMvc.perform(get("/customer/" + id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.equalTo(id)));
	}

	@Test
	public void postTest() throws Exception {

		int id = 2;

		Customer customer = createCustomer(id);
		
		Mockito.when(accountService.add(ArgumentMatchers.any())).thenReturn(new Account(id, "123456", 1000, customer));

		Mockito.when(customerService.add(ArgumentMatchers.any())).thenReturn(customer);

		String jsonRequest = mapper.writeValueAsString(customer);

		mockMvc.perform(post("/customer/").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", Matchers.equalTo(id)));
	}

	private Customer createCustomer(int id) {
		return new Customer(id, "Anand", "3, Vivekandar Street", "HCL", "A-1234567", "abc@xyz.com", "9876543210", null);
	}
}

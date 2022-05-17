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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandrasekar246.banking.config.JwtAuthenticationEntryPoint;
import com.github.chandrasekar246.banking.entity.Account;
import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.service.AccountService;
import com.github.chandrasekar246.banking.service.CustomerService;
import com.github.chandrasekar246.banking.util.JwtTokenUtil;

@WebMvcTest(controllers = CustomerController.class)
class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CustomerService customerService;

	@MockBean
	private AccountService accountService;
	
	@MockBean
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	private static ObjectMapper mapper;

	@BeforeAll
	public static void init() {
		mapper = new ObjectMapper();
	}

	@Test
    @WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
	void findByIdTest() throws Exception {

		int id = 1;

		Customer customer = createCustomer(id);

		Mockito.when(customerService.findById(id)).thenReturn(customer);

		mockMvc.perform(get("/customer/" + id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.equalTo(id)));
	}

	@Test
	@WithMockUser(username = "admin", roles = {"USER", "ADMIN"})
	void postTest() throws Exception {

		int id = 2;

		Customer customer = createCustomer(id);

		Mockito.when(accountService.add(ArgumentMatchers.any())).thenReturn(new Account(id, "123456", 1000, customer));

		Mockito.when(customerService.add(ArgumentMatchers.any())).thenReturn(customer);

		String jsonRequest = mapper.writeValueAsString(customer);

		mockMvc.perform(post("/customer/register").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.amount", Matchers.equalTo(1000.0)));
	}

	private Customer createCustomer(int id) {
		return new Customer(id, "Anand", "3, Vivekandar Street", "HCL", "A-1234567", "abc@xyz.com", "9876543210",
				"chandra123", "chandra123", null);
	}
}

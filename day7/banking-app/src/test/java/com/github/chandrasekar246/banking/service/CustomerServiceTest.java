package com.github.chandrasekar246.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.chandrasekar246.banking.entity.Customer;
import com.github.chandrasekar246.banking.exception.InvalidCustomerIdException;
import com.github.chandrasekar246.banking.repository.CustomerRepository;

@SpringBootTest(classes = CustomerService.class)
public class CustomerServiceTest {
	@Autowired
	private CustomerService customerService;

	@MockBean
	private CustomerRepository customerRepository;

	@Test
	public void findByIdTest() throws Exception {

		int id = 1;

		Customer expectedCustomer = createCustomer(id);

		Mockito.when(customerRepository.findById(id)).thenReturn(Optional.of(expectedCustomer));

		Customer actualCustomer = customerService.findById(id);

		assertEquals(expectedCustomer, actualCustomer);
	}

	@Test
	public void findByIdNegativeTest() {

		int id = 1;

		Mockito.when(customerRepository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(InvalidCustomerIdException.class, () -> {
			customerService.findById(id);
		});

		String expectedMessage = "Unknown customer ID: " + id;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
	}

	private Customer createCustomer(int id) {
		return new Customer(id, "Anand", "3, Vivekandar Street", "HCL", "A-1234567", "abc@xyz.com", "9876543210", null);
	}
}

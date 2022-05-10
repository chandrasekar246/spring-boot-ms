package com.github.chandrasekar246.ems.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

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
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.chandrasekar246.ems.entity.Employee;
import com.github.chandrasekar246.ems.service.EmployeeService;

@WebMvcTest
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private EmployeeService employeeService;

	private static ObjectMapper mapper;

	@BeforeAll
	public static void init() {
		mapper = new ObjectMapper();
		mapper.findAndRegisterModules();
	}

	@Test
	public void findByIdTest() throws Exception {

		int id = 1;

		Employee employee = getEmployee(id);

		Mockito.when(employeeService.findById(id)).thenReturn(employee);

		mockMvc.perform(get("/employees/" + id)).andExpect(status().isOk())
				.andExpect(jsonPath("$.id", Matchers.equalTo(id)));
	}

	@Test
	public void postTest() throws Exception {

		int id = 2;

		Employee employee = getEmployee(id);

		Mockito.when(employeeService.add(ArgumentMatchers.any())).thenReturn(employee);

		String jsonRequest = mapper.writeValueAsString(employee);

		mockMvc.perform(post("/employees/").contentType(MediaType.APPLICATION_JSON).content(jsonRequest)
				.accept(MediaType.APPLICATION_JSON)).andExpect(status().isCreated())
				.andExpect(jsonPath("$.id", Matchers.equalTo(id)));
	}

	@Test
	public void deleteByIdTest() throws Exception {

		int id = 1;

		String expectedResponse = new StringBuilder("Employee record with ID: ").append(id).append(" is deleted!")
				.toString();

		Mockito.when(employeeService.deleteById(1)).thenReturn(expectedResponse);

		MvcResult requestResult = mockMvc.perform(delete("/employees/" + id)).andExpect(status().isOk()).andReturn();

		String actualResponse = requestResult.getResponse().getContentAsString();

		assertEquals(expectedResponse, actualResponse);
	}

	private Employee getEmployee(int id) {
		Employee employee = new Employee();

		employee.setId(id);
		employee.setFirstName("Anand");
		employee.setLastName("Raj");
		employee.setDepartment("BFSI");
		employee.setEmail("abc@xyz.com");
		employee.setExperience(10);
		employee.setDateOfBirth(LocalDate.parse("2020-02-20"));
		employee.setSalary(20000);

		return employee;
	}
}

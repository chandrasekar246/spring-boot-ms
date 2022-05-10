package com.github.chandrasekar246.ems.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.github.chandrasekar246.ems.entity.Employee;
import com.github.chandrasekar246.ems.exception.InvalidEmployeeIDException;
import com.github.chandrasekar246.ems.repository.EmployeeCrudRepository;
import com.github.chandrasekar246.ems.repository.EmployeePageRepository;

@SpringBootTest(classes = EmployeeService.class)
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	@MockBean
	private EmployeeCrudRepository crudRepository;

	@MockBean
	private EmployeePageRepository pageRepository;

	@Test
	public void findByIdTest() throws Exception {

		int id = 1;

		Employee expectedEmployee = getEmployee(id);

		Mockito.when(crudRepository.findById(id)).thenReturn(Optional.of(expectedEmployee));

		Employee actualEmployee = employeeService.findById(id);

		assertEquals(expectedEmployee, actualEmployee);
	}

	@Test
	public void findByIdNegativeTest() {

		int id = 1;

		Mockito.when(crudRepository.findById(id)).thenReturn(Optional.empty());

		Exception exception = assertThrows(InvalidEmployeeIDException.class, () -> {
			employeeService.findById(id);
		});

		String expectedMessage = "Unknown employee ID: " + id;
		String actualMessage = exception.getMessage();

		assertEquals(expectedMessage, actualMessage);
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

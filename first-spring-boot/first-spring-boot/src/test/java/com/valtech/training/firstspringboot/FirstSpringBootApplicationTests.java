package com.valtech.training.firstspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.firstspringboot.components.EmployeeDAO;
import com.valtech.training.firstspringboot.components.HelloWorld;
import com.valtech.training.firstspringboot.components.SimpleInterest;
import com.valtech.training.firstspringboot.entities.Order;
import com.valtech.training.firstspringboot.service.OrderService;

@SpringBootTest
class FirstSpringBootApplicationTests {

	@Autowired
	private HelloWorld helloWorld;
	
	@Autowired
	private EmployeeDAO employeeDAO;
		
	@Autowired
	private OrderService orderService;
	
	
	@Autowired
	private SimpleInterest simpleinterest;
	
	@Test
	void testSI() {
		simpleinterest.computInterest(20000, 3, 3);
	}
	
	
	@Test
	void testOrders() {
		Order o=orderService.createOrder(new Order("Macbook Pro M3",25,"Fpr the entire team",LocalDate.of(2023, 11, 8)));
		assertEquals(4, o.getId());
		assertTrue(orderService.getAllOrders().size()>0);
	}
	
	@Test
	void testEmployeeDAO() {
	assertEquals(2, employeeDAO.count());
	//System.out.println(employeeDAO.getAllEmployees().size());
	assertEquals(2, employeeDAO.getAllEmployees().size());
//	
	}
	
	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}

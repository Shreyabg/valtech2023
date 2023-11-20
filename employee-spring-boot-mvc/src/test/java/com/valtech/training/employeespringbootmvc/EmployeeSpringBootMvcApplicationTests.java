package com.valtech.training.employeespringbootmvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.valtech.training.employeespringbootmvc.components.HelloWorld;



@SpringBootTest
class EmployeeSpringBootMvcApplicationTests {
	@Autowired
	private HelloWorld helloWorld;
	@Test
	void contextLoads() {
		assertNotNull(helloWorld);
		assertEquals("Hello Spring Boot", helloWorld.hello());
	}

}

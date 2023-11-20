package com.valtech.training.employeespringbootmvc.components;

import org.springframework.stereotype.Component;

@Component
public class HelloWorld {
public String hello() {
	return "Hello Spring Boot";
}
}

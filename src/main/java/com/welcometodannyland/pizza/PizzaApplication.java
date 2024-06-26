package com.welcometodannyland.pizza;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@ComponentScan("com.welcometodannyland.pizza.model")
public class PizzaApplication {

	private static final Logger logger = LoggerFactory.getLogger(PizzaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}
}

package com.spring.workshop.carsspringbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.spring.workshop.carsspringbootdemo", "com.spring.workshop.carsspringbootdemo.auth"})
public class CarsSpringbootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarsSpringbootDemoApplication.class, args);
	}

}


package com.srikanth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Spring Boot Admin Server!";
	}
	
	@GetMapping("/sayHello")
	public String hello() {
		return "Hello from Microservice 1";
	}

}

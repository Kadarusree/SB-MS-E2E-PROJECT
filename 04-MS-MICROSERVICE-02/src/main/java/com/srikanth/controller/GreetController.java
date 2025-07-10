package com.srikanth.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello from " + appName + "!";
	}

}

package com.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.feign.MS2FeignClient;

@RestController
@RequestMapping("/ms1")
public class HomeController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	
	@Autowired
	MS2FeignClient ms2FeignClient;
	
	@GetMapping("/")
	public String ms1Home() {
		return "Microservice 1 is running! Application Name: " + appName;
	}
	
	@GetMapping("/welcome")
	public String home() {
		return "Welcome to the Spring Boot Admin Server!";
	}
	
	@GetMapping("/getMicroservice2Info")
	public String hello() {
		return "Hello from " + appName + "!" + ms2FeignClient.getMicroService2Inforamtion();
	}

}

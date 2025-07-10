package com.srikanth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.srikanth.feign.WelcomeAPI;
import com.srikanth.responseentity.ApiResponse;

@RestController
public class GreetController {
	
	@Value("${spring.application.name}")
	private String appName;
	
	@Autowired
	Environment environment;
	
	@Autowired
	private WelcomeAPI welcomeAPI;
	
	@GetMapping("/")
	public String home() {
		return "Welcome to the Spring Boot Application: App is running on port: " + environment.getProperty("server.port");
	}
	
	@GetMapping("/greet")
	public ResponseEntity<ApiResponse<String>> greet() {
		String port = "MS 2 Port Info :::: "+environment.getProperty("server.port");
		
		String microService1Info = welcomeAPI.getMicroService1Inforamtion();
		
		ApiResponse<String> apiResponse = new ApiResponse<>(microService1Info, port, true);
		ResponseEntity<ApiResponse<String>> response = ResponseEntity.ok(apiResponse);
		return response;
	}
	
	@GetMapping("/getMicroservice2Info")
	public ResponseEntity<ApiResponse<String>> getMicroservice2Info() {
		String port = "MS 2 Port Info :::: " + environment.getProperty("server.port");
		ApiResponse<String> apiResponse = new ApiResponse<>(port, HttpStatus.OK.getReasonPhrase(), true);
		ResponseEntity<ApiResponse<String>> response = ResponseEntity.ok(apiResponse);
		return response;
	}

}

package com.srikanth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("03-MS-MICROSERVICE-01")
public interface WelcomeAPI {
	
	@GetMapping("/sayHello")
	public String getMicroService1Inforamtion();

}

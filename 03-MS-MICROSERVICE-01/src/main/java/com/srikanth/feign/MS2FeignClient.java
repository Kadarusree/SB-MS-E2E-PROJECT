package com.srikanth.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("04-MS-MICROSERVICE-02")
public interface MS2FeignClient {
	
	@GetMapping("/ms2/getMicroservice2Info")
	public String getMicroService2Inforamtion();

}

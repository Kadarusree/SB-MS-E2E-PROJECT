package com.srikanth.filters;

import java.util.List;
import java.util.Set;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;


@Component
public class RequestFilter implements GlobalFilter {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		// TODO Auto-generated method stub
		
		System.out.println("RequestFilter: Filtering request...");
		
		HttpHeaders headers = exchange.getRequest().getHeaders();
		Set<String> keySet = headers.keySet();
		
		if(keySet.contains("Secret")) {
			List<String> secret = headers.get("Secret");
			String sec = secret.stream().findFirst().orElse(null);
			if(sec != null && sec.equals("ADCB1234")) {
				System.out.println("Secret header is present and valid.");
			} else {
				throw new RuntimeException("Invalid secret header value");
			}
		}
		else {
			throw new RuntimeException("Secret header is missing");
		}
		return chain.filter(exchange);
	}

}

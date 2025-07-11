package com.srikanth.entity;

import org.springframework.data.redis.core.RedisHash;

import lombok.Data;

@Data
@RedisHash("student")
public class Student {
	
	private int id;
	private String name;
	private String email;

}

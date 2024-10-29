package com.centroxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringBootAerospikeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAerospikeClientApplication.class, args);
		
	}

}

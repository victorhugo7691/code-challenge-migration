package com.dummyjson_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DummyjsonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DummyjsonClientApplication.class, args);
	}

}

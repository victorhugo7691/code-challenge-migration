package com.dummyjson_client.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class RestTemplateConfigTest {

	private final ApplicationContext applicationContext;

	public RestTemplateConfigTest(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Test
	public void beanRestTemplateComSucesso() {
		RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);
		assertNotNull(restTemplate, "O bean RestTemplate deve ser configurado e injetado corretamente!");
	}
}

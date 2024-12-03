package com.dummyjson_client.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class HealthControllerTest {

	@InjectMocks
	private HealthController healthController;

	@BeforeEach
	void setUp() {
		this.healthController = new HealthController();
	}

	@Test
	void testGetHealthStatus() {
		// Chama o método do controlador
		ResponseEntity<String> response = this.healthController.getHealthStatus();

		// Valida o status HTTP e o corpo da resposta
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals("O servidor está funcionando corretamente", response.getBody());
	}
}

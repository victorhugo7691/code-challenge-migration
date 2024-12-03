package com.dummyjson_client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/health")
public class HealthController {

	@GetMapping
	public ResponseEntity<String> getHealthStatus() {
		return ResponseEntity.ok("O servidor está funcionando corretamente");
	}

}

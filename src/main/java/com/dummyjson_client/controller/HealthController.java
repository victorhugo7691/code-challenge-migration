package com.dummyjson_client.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Classe desenvolvida com o objetivo de monitorar/obter o status do servidor da aplicação
@RestController
@RequestMapping("api/health")
public class HealthController {

	/*Através dessa funcionalidade é possível ver a mensagem que informa o bom funcionamento da aplicação, 
	*caso esteja funcionando corretamente */
	@GetMapping
	public ResponseEntity<String> getHealthStatus() { 
		return ResponseEntity.ok("O servidor está funcionando corretamente");
	}

}

package com.dummyjson_client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Exceção customizada para atender às falhas de consultas de produtos
@ResponseStatus(HttpStatus.NO_CONTENT)
public class DadosNaoEncontradosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DadosNaoEncontradosException(String message) {
		super(message);
	}

}

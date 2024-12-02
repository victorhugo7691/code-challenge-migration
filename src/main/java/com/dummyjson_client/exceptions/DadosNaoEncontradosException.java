package com.dummyjson_client.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class DadosNaoEncontradosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DadosNaoEncontradosException(String message) {
		super(message);
	}

}

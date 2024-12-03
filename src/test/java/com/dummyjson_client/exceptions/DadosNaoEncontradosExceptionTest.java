package com.dummyjson_client.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class DadosNaoEncontradosExceptionTest {

	@Test
	void exceptionMessage() {
		// Mensagem
		String message = "Dados não encontrados";

		// Cria uma exception
		DadosNaoEncontradosException exception = new DadosNaoEncontradosException(message);

		// Realiza a validacao
		assertEquals(message, exception.getMessage(), "A mensagem da exceção não corresponde.");
	}

	@Test
	void exceptionHttpStatus() {
		// cria a exception
		DadosNaoEncontradosException exception = new DadosNaoEncontradosException("Dados não encontrados");

		// Realiza as verificacoes
		ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);

		assertNotNull(responseStatus, "A exceção não possui a anotação @ResponseStatus.");
		assertEquals(HttpStatus.NO_CONTENT, responseStatus.value(), "O status HTTP da exceção não é NO_CONTENT.");
	}

}

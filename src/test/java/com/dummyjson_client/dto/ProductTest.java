package com.dummyjson_client.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.Test;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ProductTest {

	private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();

	private final Validator validator = factory.getValidator();

	@Test
	public void testGetAndSetter() {
		// Configura e cria o objeto com os dados
		Long expectId = 1L;
		String expectedTitle = "A dummy title";
		String expectedDescription = "A dummy description";
		Double expectedPrice = 2.1;

		Product product1 = new Product(expectId, expectedTitle, expectedDescription, expectedPrice);

		// Realiza as validacoes
		assertEquals(expectId, product1.id());
		assertEquals(expectedTitle, product1.title());
		assertEquals(expectedDescription, product1.description());
		assertEquals(expectedPrice, product1.price());
	}

	@Test
	void validProduct() {
		// Configura e cria o objeto com os dados
		Product validProduct = new Product(1L, "Laptop", "High-end laptop", 2999.99);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(validProduct);

		// Realiza as validacoes
		assertTrue(violations.isEmpty(), "Não deve haver violações de validação para um produto válido.");
	}

	@Test
	void productWithNullId() {
		// Configura e cria o objeto com os dados
		Product invalidProduct = new Product(null, "Laptop", "High-end laptop", 2999.99);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(invalidProduct);

		// Realiza as validacoes
		assertFalse(violations.isEmpty(), "Deve haver uma violação de validação para o campo 'id'.");
		assertEquals("O id não foi localizado, é necessário para prosseguir!",
				violations.iterator().next().getMessage());
	}

	@Test
	void productWithMaxId() {
		// Configura e cria o objeto com os dados
		Product invalidProduct = new Product(1000L, "Laptop", "High-end laptop", 2999.99);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(invalidProduct);

		// Realiza as validacoes
		assertFalse(violations.isEmpty(), "Deve haver uma violação de validação para o campo 'id' acima do máximo.");
	}

	@Test
	void productWithBlankTitle() {
		// Configura e cria o objeto com os dados
		Product invalidProduct = new Product(1L, "", "High-end laptop", 2999.99);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(invalidProduct);

		// Realiza as validacoes
		assertFalse(violations.isEmpty(), "Deve haver uma violação de validação para o campo 'title' em branco.");
		assertEquals("Informe o título!", violations.iterator().next().getMessage());
	}

	@Test
	void productWithBlankDescription() {
		// Configura e cria o objeto com os dados
		Product invalidProduct = new Product(1L, "Laptop", "", 2999.99);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(invalidProduct);

		// Realiza as validacoes
		assertFalse(violations.isEmpty(), "Deve haver uma violação de validação para o campo 'description' em branco.");
		assertEquals("Informe a descrição do produto!", violations.iterator().next().getMessage());
	}

	@Test
	void poductWithNullPrice() {
		// Configura e cria o objeto com os dados
		Product invalidProduct = new Product(1L, "Laptop", "High-end laptop", null);

		Set<ConstraintViolation<Product>> violations = this.validator.validate(invalidProduct);

		// Realiza as validacoes
		assertFalse(violations.isEmpty(), "Deve haver uma violação de validação para o campo 'price' nulo.");
		assertEquals("O preço deve ser informado!", violations.iterator().next().getMessage());
	}
}

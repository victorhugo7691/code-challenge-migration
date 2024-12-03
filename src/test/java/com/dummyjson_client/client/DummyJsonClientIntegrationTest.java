package com.dummyjson_client.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.utils.ProductListResponse;

@SpringBootTest
public class DummyJsonClientIntegrationTest {

	@Autowired
	private IDummyJsonClient dummyJsonClient;

	@Test
	public void testGetProducts() {
		// Chama o método da interface Feign Client
		ProductListResponse response = this.dummyJsonClient.getProducts();

		// Verifique se a resposta não é nula
		assertNotNull(response);

		// Verifique se a resposta contém produtos (simulação de conteúdo)
		assertTrue(response.getProducts().size() > 0);
	}

	@Test
	public void testGetProductById() {
		// Chama o método da interface Feign Client
		Product product = this.dummyJsonClient.getProductById(1L);

		// Verifique se o produto não é nulo
		assertNotNull(product);

		// Verifique se o produto tem o ID esperado
		assertEquals(Long.valueOf(1), product.id());
	}

}

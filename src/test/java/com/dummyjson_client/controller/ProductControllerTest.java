package com.dummyjson_client.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.service.interfaces.IProductService;
import com.dummyjson_client.utils.TestFixture;

@SpringBootTest
public class ProductControllerTest {

	@Mock
	private IProductService productService;

	@InjectMocks
	private ProductController productController;

	@Test
	public void testGetAllProducts() {
		// Criação dos produto e configuração
		List<Product> products = TestFixture.createProductList();

		when(this.productService.getAllProducts()).thenReturn(products);

		// Execução da função
		ResponseEntity<List<Product>> result = this.productController.getAllProducts();

		// Verificações
		assertEquals(2, result.getBody().size());
		assertEquals("Product 1", result.getBody().get(0).title());
	}

	@Test
	void getProductByIdSuccess() {
		// Criação do id, do produto e configuração
		Long id = 1L;
		Product product = TestFixture.createProduct(id);

		when(this.productService.getProductById(id)).thenReturn(product);

		// Execução da funcionalidade
		ResponseEntity<Product> result = this.productController.getProductById(id);

		// Verificações
		assertNotNull(result.getBody());
		assertEquals(result.getStatusCode(), HttpStatus.OK);
		assertEquals("Titulo padrao", result.getBody().title());
	}
}

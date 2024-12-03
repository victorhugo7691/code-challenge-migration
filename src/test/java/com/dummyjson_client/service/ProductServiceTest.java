package com.dummyjson_client.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.dummyjson_client.client.IDummyJsonClient;
import com.dummyjson_client.dto.Product;
import com.dummyjson_client.exceptions.DadosNaoEncontradosException;
import com.dummyjson_client.utils.ProductListResponse;
import com.dummyjson_client.utils.TestFixture;

public class ProductServiceTest {

	@Mock
	private IDummyJsonClient dummyJsonClient;

	@InjectMocks
	private ProductService productService;

	@BeforeEach
	void setUp() {
		this.dummyJsonClient = mock(IDummyJsonClient.class);
		this.productService = new ProductService(this.dummyJsonClient);
	}

	@Test
	void getAllProductsSuccess() {
		// Configura e instacia os objetos
		List<Product> products = TestFixture.createProductList();
		ProductListResponse listProducts = new ProductListResponse();
		listProducts.setProducts(products);

		// Configura o resultado ao chamar a funcao
		when(this.dummyJsonClient.getProducts()).thenReturn(listProducts);

		// Faz a chamada a funcao
		List<Product> response = this.productService.getAllProducts();

		// Verificações
		assertNotNull(response);
	}

	@Test
	void getAllProductsFailed() {
		// Configura para o lancamento da exception
		when(this.dummyJsonClient.getProducts())
				.thenThrow(new DadosNaoEncontradosException("Não foi possível identificar os produtos!"));

		// Trata a exception
		DadosNaoEncontradosException exception = assertThrows(DadosNaoEncontradosException.class, () -> {
			this.productService.getAllProducts();
		});

		assertEquals("Não foi possível identificar os produtos!", exception.getMessage());
		verify(this.dummyJsonClient, times(1)).getProducts();
	}

	@Test
	public void testGetProductById() {
		// Configra os dados inicias
		Long id = 1L;
		Product product = TestFixture.createProduct(id);

		when(this.dummyJsonClient.getProductById(id)).thenReturn(product);

		// Faz a chamada a funcao
		Product result = this.productService.getProductById(1L);

		// Verificacoes
		assertEquals("Titulo padrao", result.title());
	}

}

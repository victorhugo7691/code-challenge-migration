package com.dummyjson_client.utils;

import java.util.List;

import com.dummyjson_client.dto.Product;

public class TestFixture {

	public static Product createProduct(Long id) {
		return new Product(id, "Titulo padrao", "Descricao do produto", Double.valueOf("200"));
	}

	public static List<Product> createProductList() {
		Product product1 = new Product(1L, "Product 1", "Descricao 1", Double.valueOf("200"));
		Product product2 = new Product(2L, "Product 2", "Descricao 2", Double.valueOf("300"));

		return List.of(product1, product2);
	}
}

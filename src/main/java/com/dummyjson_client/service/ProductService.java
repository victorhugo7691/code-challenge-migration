package com.dummyjson_client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dummyjson_client.client.DummyjsonClient;
import com.dummyjson_client.dto.Product;
import com.dummyjson_client.exceptions.DadosNaoEncontradosException;
import com.dummyjson_client.service.interfaces.IProductService;
import com.dummyjson_client.utils.ProductListResponse;

@Service
public class ProductService implements IProductService {

	private DummyjsonClient dummyjsonClient;

	public ProductService(DummyjsonClient dummyjsonClient) {
		this.dummyjsonClient = dummyjsonClient;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();

		try {
			ProductListResponse todosOsProdutos = this.dummyjsonClient.getProducts();

			if (todosOsProdutos != null) {
				products = todosOsProdutos.getProducts();
			}

		} catch (DadosNaoEncontradosException exception) {
			throw new DadosNaoEncontradosException("Não foi possível identificar os produtos! " + exception);
		}

		return products;
	}

	@Override
	public Product getProductById(Long id) {
		try {
			return this.dummyjsonClient.getProductById(id);
		} catch (DadosNaoEncontradosException exception) {
			throw new DadosNaoEncontradosException(
					"Não foi possível identificar o produto com id: " + id + " " + exception);
		}
	}
}

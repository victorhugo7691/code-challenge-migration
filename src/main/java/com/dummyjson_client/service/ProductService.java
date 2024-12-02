package com.dummyjson_client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.exceptions.DadosNaoEncontradosException;
import com.dummyjson_client.service.interfaces.IProductService;
import com.dummyjson_client.utils.Constantes;
import com.dummyjson_client.utils.ProductListResponse;

@Service
public class ProductService implements IProductService {

	private RestTemplate restTemplate;

	public ProductService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<>();

		try {
			ProductListResponse todosOsProdutos = this.restTemplate.getForObject(Constantes.BASE_URL,
					ProductListResponse.class);

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
		String urlById = Constantes.BASE_URL + "/" + id;

		return this.restTemplate.getForObject(urlById, Product.class);
	}
}

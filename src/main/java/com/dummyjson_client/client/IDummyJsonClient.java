package com.dummyjson_client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.utils.ProductListResponse;

/**
 * Esta Interface de cliente Feign tem comno objetivo se comunicação através da url que é informada via parâmetro de variável de ambiente.
 * 
 * Esta interface define os métodos para interagir com os produtos, permitindo
 * consultar informações sobre produtos
 * O Feign Client facilita a integração com a API externa de forma declarativa.
 * 
 * A URL do serviço é configurada por meio de propriedades no arquivo `application.properties`.
 * 
**/
@FeignClient(name = "dummyjson-client", url = "${url-dummyjson}")
public interface IDummyJsonClient {

	@GetMapping(value = "/products") // Lista todos os produtos disponíveis
	public ProductListResponse getProducts();
	
	@GetMapping(value = "/products/{id}") // Busca o produto por id
	public Product getProductById(@PathVariable Long id);
}

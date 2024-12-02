package com.dummyjson_client.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.utils.ProductListResponse;

@FeignClient(name = "dummyjson-client", url = "https://dummyjson.com")
public interface DummyjsonClient {

	@GetMapping(value = "/products")
	public ProductListResponse getProducts();
	
	@GetMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable Long id);
}

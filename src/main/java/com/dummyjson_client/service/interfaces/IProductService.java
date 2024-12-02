package com.dummyjson_client.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dummyjson_client.dto.Product;

@Service
public interface IProductService {

	public List<Product> getAllProducts();
	
	public Product getProductById(Long id);

}

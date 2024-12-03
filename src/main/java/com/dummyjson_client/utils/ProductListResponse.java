package com.dummyjson_client.utils;

import java.util.List;

import com.dummyjson_client.dto.Product;

// Esta classe foi desenvolvida para apoiar a serialização dos produtos consultados 
public class ProductListResponse {

	private List<Product> products;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}

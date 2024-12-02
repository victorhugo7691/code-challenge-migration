package com.dummyjson_client.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dummyjson_client.dto.Product;
import com.dummyjson_client.service.interfaces.IProductService;

import jakarta.validation.constraints.NotNull;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private IProductService productService;

	public ProductController(IProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() {
		List<Product> products = this.productService.getAllProducts();

		if (products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(products);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable @NotNull Long id) {
		Product product = this.productService.getProductById(id);

		if (product == null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.ok(product);
	}

}

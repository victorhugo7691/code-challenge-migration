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

// A controller disponibiliza os end-points que poderão ser utilizados para consultar todos os produtos e produtos por id
@RestController
@RequestMapping("/api/products")
public class ProductController {

	private IProductService productService;

	public ProductController(IProductService productService) { // Através do construtor é possível atribuir o valor,
																// concluíndo assim a injeção de dependência da service
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<Product>> getAllProducts() { // A funcionalidade lista todos os produtos, caso existam
		List<Product> products = this.productService.getAllProducts();

		if (products.isEmpty()) {
			return ResponseEntity.noContent().build(); // Retorna em caso de não existir uma lista de produtos
		}

		return ResponseEntity.ok(products); // Retorna os produtos
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable @NotNull Long id) { // A funcionalidade apresenta um
																					// único produto, caso ele exista
		Product product = this.productService.getProductById(id);

		if (product == null) {
			return ResponseEntity.noContent().build(); // Retorna em caso de não existir o produto com o id informado
		}

		return ResponseEntity.ok(product); // Retorna o produto
	}

}

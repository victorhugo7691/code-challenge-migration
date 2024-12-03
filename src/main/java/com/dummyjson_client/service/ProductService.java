package com.dummyjson_client.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dummyjson_client.client.IDummyJsonClient;
import com.dummyjson_client.dto.Product;
import com.dummyjson_client.exceptions.DadosNaoEncontradosException;
import com.dummyjson_client.service.interfaces.IProductService;
import com.dummyjson_client.utils.ProductListResponse;

/*Essa é a service, é onde está sendo tratados os produtos que são lidos
* As regras, e algumas verificações são realizadas aqui
* Exceções também são tratadas, com o objetivo de apresentar mensagens que indicam falhas
*/
@Service
public class ProductService implements IProductService {

	private IDummyJsonClient dummyJsonClient;

	// Através do construtor é possível atribuir o valor, concluíndo assim a injeção
	// de dependência de IDummyjsonClient
	public ProductService(IDummyJsonClient dummyjsonClient) {
		this.dummyJsonClient = dummyjsonClient;
	}

	@Override
	public List<Product> getAllProducts() { // Funcionalidade que busca todos os produtos
		List<Product> products = new ArrayList<>();

		try { // Tentativa de obter os produtos
			ProductListResponse todosOsProdutos = this.dummyJsonClient.getProducts(); // É realizada uma chamada à
																						// função que lista os produtos
																						// em dummyJsonClient

			if (todosOsProdutos != null) { // Verifica se há produtos, havendo eles são atribuídos à lista products
				products = todosOsProdutos.getProducts();
			}

		} catch (DadosNaoEncontradosException exception) { // Ao falhar nas atividades anteriores a exceção é lançada
			throw new DadosNaoEncontradosException("Não foi possível identificar os produtos!");
		}

		return products;
	}

	@Override
	public Product getProductById(Long id) { // Funcionalidade que permite consultar produto por id
		try { // Tentativa de acesso ao produto por id
			return this.dummyJsonClient.getProductById(id);
		} catch (DadosNaoEncontradosException exception) { // Ao falhar, havendo algum problema de acesso, é realizado o
															// lançamento da exceção
			throw new DadosNaoEncontradosException(
					"Não foi possível identificar o produto com id: " + id + " " + exception);
		}
	}
}

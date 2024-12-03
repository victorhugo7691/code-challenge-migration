package com.dummyjson_client.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * Representa um produto no sistema com informações básicas como ID, título,
 * descrição e preço.
 * 
 * Esta classe é um exemplo de uma Record, que é uma estrutura de dados imutável
 * projetada para armazenar um conjunto de dados relacionados com um número fixo
 * de campos.
 * 
 * A record Product é usada para representar um produto e é composta pelos
 * campos: - id: O identificador único do produto - title: O título do produto.
 * - description: descrição do produto. - price: preço do produto.
 */
public record Product(
		@NotNull(message = "O id não foi localizado, é necessário para prosseguir!") @Min(0L) @Max(999L) Long id,
		@NotBlank(message = "Informe o título!") String title,
		@NotBlank(message = "Informe a descrição do produto!") String description,
		@NotNull(message = "O preço deve ser informado!") Double price) {
}

//Algumas anotações foram realizadas nos campos, elas servem para realizar a validação da entrada, como exemplo a anotação @NotNull irá validar se o campo não está vazio.
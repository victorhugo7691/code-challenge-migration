package com.dummyjson_client.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record Product(
		@NotNull(message = "O id não foi localizado, é necessário para prosseguir!") @Min(0L) @Max(999L) Long id,
		@NotBlank(message = "Informe o título!") String title,
		@NotBlank(message = "Informe a descrição do produto!") String description,
		@NotNull(message = "O preço deve ser informado!") Double price) {
}

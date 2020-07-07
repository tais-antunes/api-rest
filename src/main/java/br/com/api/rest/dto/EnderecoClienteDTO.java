package br.com.api.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EnderecoClienteDTO {

	private String localidade;
	private String estado;
}

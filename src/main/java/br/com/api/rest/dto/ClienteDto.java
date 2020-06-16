package br.com.api.rest.dto;

import br.com.api.rest.model.Cidade;
import br.com.api.rest.model.Cliente;
import lombok.Getter;

@Getter
public class ClienteDto {
	
	private String nomeCompleto;
	private int idade;
	private Cidade cidade;

	public ClienteDto(Cliente cliente) {
		this.nomeCompleto = cliente.getNomeCompleto();
		this.idade = cliente.getIdade();
		this.cidade = cliente.getCidade();
	}
	
}

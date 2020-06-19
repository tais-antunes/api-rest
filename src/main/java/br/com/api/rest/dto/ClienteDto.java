package br.com.api.rest.dto;

import java.util.Date;

import br.com.api.rest.model.Cliente;
import br.com.api.rest.model.Sexo;
import lombok.Getter;

@Getter
public class ClienteDto {
	
	private String nomeCompleto;
	private Sexo sexo;
	private Date dataNascimento;
	private int idade;
	
	public ClienteDto(Cliente cliente) {
		this.nomeCompleto = cliente.getNomeCompleto();
		this.sexo = cliente.getSexo();
		this.dataNascimento = cliente.getDataNascimento();
		this.idade = cliente.getIdade();
		
	}
	
	
}

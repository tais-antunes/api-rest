package br.com.api.rest.dto;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
	
	
	public static List<ClienteDto> converterCliente(List<Cliente> cliente) {
		return cliente.stream().map(ClienteDto::new).collect(Collectors.toList());
	}
	
}

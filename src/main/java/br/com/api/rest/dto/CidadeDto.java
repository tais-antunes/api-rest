package br.com.api.rest.dto;

import br.com.api.rest.model.Cidade;
import br.com.api.rest.model.Estados;
import lombok.Getter;

@Getter
public class CidadeDto {
	private String nome;
	private Estados estado;
	
	
	public CidadeDto(Cidade cidade) {
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
	}
}

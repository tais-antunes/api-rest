package br.com.api.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.api.rest.entity.Cidade;
import br.com.api.rest.entity.Estados;
import lombok.Getter;

@Getter
public class CidadeDto {
	private String nome;
	private Estados estado;
	
	
	public CidadeDto(Cidade cidade) {
		this.nome = cidade.getNome();
		this.estado = cidade.getEstado();
	}


	public static List<CidadeDto> lista(List<Cidade> cidade){
		return cidade.stream().map(CidadeDto::new).collect(Collectors.toList());
	}

}

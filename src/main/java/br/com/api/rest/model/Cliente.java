package br.com.api.rest.model;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Cliente {
	
	private Long id;
	private String nomeCompleto;
	private String sexo;
	private Date dataNascimento;
	private int idade;
	private Cidade cidade;
	
}

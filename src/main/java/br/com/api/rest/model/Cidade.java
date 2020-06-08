package br.com.api.rest.model;

import javax.persistence.Entity;

import lombok.Data;

@Entity
@Data
public class Cidade {
	
	private Long id;
	private String nome;
	private String estado;
	
}

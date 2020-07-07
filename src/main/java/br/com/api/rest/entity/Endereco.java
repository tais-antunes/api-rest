package br.com.api.rest.entity;

import lombok.Data;

@Data
public class Endereco {
	
	private String cep;
	private String localidade;
	private String uf;
}
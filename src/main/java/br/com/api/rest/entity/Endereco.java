package br.com.api.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Entity
@Data
@Table(name = "endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@NotEmpty
	@Column(name = "cep", nullable = false)
	private String cep;
	
	
	@NotEmpty
	@Column(name = "longraduro", nullable = false)
	private String longraduro;
	
	
	@NotEmpty
	@Column(name = "complemento", nullable = false)
	private String complemento;
	
	@NotEmpty
	@Column(name = "bairro", nullable = false)
	private String bairro;
	
	
	@NotEmpty
	@Column(name = "localidade", nullable = false)
	private String localidade;
	
	
	@NotEmpty
	@Column(name = "uf", nullable = false)
	private String uf;
	
	@NotEmpty
	@Column(name = "unidade", nullable = false)
	private String unidade;
	
	
	@NotEmpty
	@Column(name = "ibge", nullable = false)
	private String ibge;
	
	
	@NotEmpty
	@Column(name = "gia", nullable = false)
	private String gia;
	
	
}

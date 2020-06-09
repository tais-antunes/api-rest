package br.com.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Campo 'Nome Completo' obrigatório")
	@Column(name = "nome_completo")
	private String nomeCompleto;
	
	@NotNull(message = "Campo 'Sexo' obrigatório")
	@Column(name = "sexo")
	private String sexo;
	
	@NotNull(message = "Campo 'Data Nascimento' obrigatório")
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	@NotNull(message = "Campo 'Idade' obrigatório")
	private int idade;
	
	@NotNull(message = "Campo 'Cidade' obrigatório")
	private Cidade cidade;
	
}

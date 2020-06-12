package br.com.api.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Data
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@NotNull @NotEmpty
	@Column(name = "nome_completo", nullable = false)
	private String nomeCompleto;
	
	
	@NotNull @NotEmpty
	@Enumerated(EnumType.STRING)
	@Column(name = "sexo", nullable = false, length = 1)
	private Sexo sexo;


	@NotNull @NotEmpty
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "data_nascimento", nullable = false)
	private Date dataNascimento;
	
	
	@NotNull @NotEmpty
	@Column(name = "idade", nullable = false)
	private int idade;
	
	
	@NotNull @NotEmpty
	@ManyToOne
	@JoinColumn(name = "cidade_id")
	private Cidade cidade;
	
}

package br.com.api.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cidade")
@NoArgsConstructor
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	
	@NotNull @NotEmpty
	@Column(name = "nome_cidade", nullable = false)
	private String nome;
	
	
	@NotNull @NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "estado", nullable = false, length = 2)
	private Estados estado = Estados.RS;
	
}

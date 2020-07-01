package br.com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.rest.entity.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

	
}

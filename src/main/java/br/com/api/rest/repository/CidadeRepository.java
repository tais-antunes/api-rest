package br.com.api.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.rest.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {


}

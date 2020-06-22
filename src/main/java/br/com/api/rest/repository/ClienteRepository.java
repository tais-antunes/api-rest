package br.com.api.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.api.rest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findByNomeCompleto(String nomeCliente);

}

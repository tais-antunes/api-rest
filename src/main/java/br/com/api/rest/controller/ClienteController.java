package br.com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.model.Cliente;
import br.com.api.rest.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	

	@GetMapping
	public List<Cliente> listaCliente() {
		return clienteRepository.findAll();
	}
	
	
	@PostMapping
	public Cliente cadastrarCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
}	
	









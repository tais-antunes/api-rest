package br.com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.dto.ClienteDto;
import br.com.api.rest.model.Cliente;
import br.com.api.rest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDto> listaCliente(String nomeCliente) {
		return clienteService.listaCliente(nomeCliente);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteDto> listaClienteId(@PathVariable Long id) {
		return clienteService.listarCidadeId(id);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody @Valid Cliente cliente) {
		clienteService.cadastrarCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
		clienteService.atualizarCliente(cliente, id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id) {
		clienteService.deletarCliente(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
}	
	

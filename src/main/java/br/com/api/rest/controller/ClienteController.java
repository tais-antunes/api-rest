package br.com.api.rest.controller;

import java.util.List;
import java.util.Optional;

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
import br.com.api.rest.repository.ClienteRepository;
import br.com.api.rest.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;

	@GetMapping
	public List<ClienteDto> listaCliente(String nomeCliente) {
		if(nomeCliente == null) {
			List<Cliente> cliente = clienteRepository.findAll();
			return ClienteDto.converterCliente(cliente);
		} else {
			List<Cliente> cliente = clienteRepository.findByNomeCompleto(nomeCliente);
			return ClienteDto.converterCliente(cliente);
		}
	}
	
	
	@GetMapping("/{id}")
	public Cliente listarClienteId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}
	
	
	@PostMapping
	public Cliente cadastrarCliente(@RequestBody @Valid Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody Cliente cliente, @PathVariable Long id){
		clienteService.atualizarCliente(cliente, id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	

	@DeleteMapping("/{id}")
	public void deletarCliente(@PathVariable Long id) {
		clienteRepository.deleteById(id);
	}
}	
	









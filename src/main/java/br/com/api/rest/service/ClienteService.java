package br.com.api.rest.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.rest.model.Cliente;
import br.com.api.rest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	public ResponseEntity<Cliente> atualizarCliente(@RequestBody @Valid Cliente cliente, Long id){
		Optional<Cliente> atualizarCliente = clienteRepository.findById(id);
		
		if(!atualizarCliente.isPresent()){
			return ResponseEntity.ok().build();
		}
		cliente.setId(id);
		clienteRepository.save(cliente);
		
		return ResponseEntity.noContent().build();
	}
	
	

}

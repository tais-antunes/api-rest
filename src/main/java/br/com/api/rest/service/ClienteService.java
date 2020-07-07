package br.com.api.rest.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.rest.client.ViaCEPClient;
import br.com.api.rest.dto.ClienteDto;
import br.com.api.rest.dto.EnderecoClienteDTO;
import br.com.api.rest.entity.Cliente;
import br.com.api.rest.repository.ClienteRepository;

@Service
public class ClienteService {
	
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ViaCEPClient viaCEPClient;
	
	
	@Autowired
	public ClienteService(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	
	
	public List<ClienteDto> listaCliente(String nomeCliente) {
		if(nomeCliente == null) {
			List<Cliente> cliente = clienteRepository.findAll();
			return ClienteDto.converterCliente(cliente);
		} else {
			List<Cliente> cliente = clienteRepository.findByNomeCompleto(nomeCliente);
			return ClienteDto.converterCliente(cliente);
		}
	}
	
	public ResponseEntity<ClienteDto> listarCidadeId(@PathVariable Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.isPresent()) {
			return ResponseEntity.ok(new ClienteDto(cliente.get()));
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
//	public Cliente cadastrarCliente(Cliente cliente) {
//		return clienteRepository.save(cliente);
//	}
	
	
	public Cliente cadastrarcep(@RequestBody @Valid Cliente cliente) {
		
		EnderecoClienteDTO endereco = viaCEPClient.buscacep(cliente.getCidade());
		
		Cliente cli = new Cliente();
		endereco.setLocalidade(endereco.getLocalidade());
		endereco.setEstado(endereco.getEstado());
		cli.setCidade(cli.getCidade());
		
		return clienteRepository.save(cliente, cli);
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
	
	public ResponseEntity<Cliente> deletarCliente(@PathVariable Long id){
		Optional<Cliente> deletarCliente = clienteRepository.findById(id);
		if(deletarCliente.isPresent()) {
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}




}

package br.com.api.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.entity.Endereco;
import br.com.api.rest.service.ViaCEPService;

@RestController
@RequestMapping("ws/ceps")
public class EnderecoController {

	@Autowired
	private ViaCEPService viaCepService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("{cep}/json")
	public Endereco getCep(@PathVariable String cep){
		return viaCepService.getCep(cep);
		
	}
	
}

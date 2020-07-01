package br.com.api.rest.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.api.rest.entity.Endereco;

@FeignClient(url = "viacep.com.br/", name = "cepService")
public interface ViaCEPService {
	
	@GetMapping("ws/{cep}/json")
	Endereco getCep(@PathVariable("cep") String cep);


}

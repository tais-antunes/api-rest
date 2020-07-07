package br.com.api.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.api.rest.dto.EnderecoClienteDTO;
import br.com.api.rest.entity.Cidade;

@FeignClient(url = "viacep.com.br/ws/{cep}/json", name = "cepService")
public interface ViaCEPClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar", consumes = "application/json")
	EnderecoClienteDTO buscacep(@PathVariable("cep") String cep, Cidade cidade);

	EnderecoClienteDTO buscacep(Cidade cidade);


}

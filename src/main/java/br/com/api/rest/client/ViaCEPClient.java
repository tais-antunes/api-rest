package br.com.api.rest.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.api.rest.dto.EnderecoClienteDTO;

@FeignClient(url = "viacep.com.br/ws/", name = "cepService")
public interface ViaCEPClient {
	
	@RequestMapping(method = RequestMethod.POST, value = "/cadastrar/{cep}", consumes = "application/json")
	public ResponseEntity<EnderecoClienteDTO> buscacep(@RequestParam(value="cep", required=false) String cep);

}

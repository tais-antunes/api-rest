package br.com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.rest.model.Cidade;
import br.com.api.rest.repository.CidadeRepository;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired 
	private CidadeRepository cidadeRepository;
	
	@GetMapping
	public List<Cidade> listaCidade() {
		return cidadeRepository.findAll();
	}
	
	@PostMapping
	public Cidade cadastrarCidade(@RequestBody @Valid Cidade cidade ) {
		return cidadeRepository.save(cidade);
	}
	
	
}

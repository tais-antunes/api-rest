package br.com.api.rest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
//	@PutMapping("/{id}")
//	public ResponseEntity<Cidade> atualizarCidade(@RequestBody @Valid attCidade att, @PathVariable Long id) {
//		Optional<Cidade> optional = cidadeRepository.findById(id);
//		
//		if(optional.isPresent()) {
//			return ResponseEntity.ok().build();
//		}
//	}
//	
	
	@DeleteMapping("/{id}")
	public void deletarCidade(@PathVariable long id) {
		cidadeRepository.deleteById(id);
	}
}

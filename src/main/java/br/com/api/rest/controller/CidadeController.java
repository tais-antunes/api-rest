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

import br.com.api.rest.dto.CidadeDto;
import br.com.api.rest.entity.Cidade;
import br.com.api.rest.service.CidadeService;

@RestController
@RequestMapping("/cidade")
public class CidadeController {
	
	@Autowired
	private CidadeService cidadeService;
	
	
	@GetMapping
	public List<CidadeDto> listarCidade(String nomeCidade) {
		return cidadeService.listaCidade(nomeCidade);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CidadeDto> listaCidadeId(@PathVariable Long id) {
		return cidadeService.listarCidadeId(id);
		
	}
	
	@PostMapping
	public ResponseEntity<CidadeDto> cadastrarCidade(@RequestBody @Valid Cidade cidadeDto) {
		cidadeService.cadastrar(cidadeDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cidade> atualizarCidade(@RequestBody Cidade cidade, @PathVariable Long id) {
		cidadeService.atualizar(cidade, id);
		return ResponseEntity.status(HttpStatus.OK).build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Cidade> deletarCidade(@PathVariable long id) {
		cidadeService.deletar(id);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	
}

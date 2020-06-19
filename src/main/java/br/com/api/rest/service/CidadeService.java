package br.com.api.rest.service;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.api.rest.dto.CidadeDto;
import br.com.api.rest.model.Cidade;
import br.com.api.rest.repository.CidadeRepository;

@Service
public class CidadeService {
	
	private CidadeRepository cidadeRepository;
	
	@Autowired
	public CidadeService(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	public ResponseEntity<Cidade> listarCidadeId(Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if(cidade.isPresent()) {
			 ResponseEntity.ok(new CidadeDto(cidade.get()));
		}
		
		return ResponseEntity.noContent().build();
	}
	
	
	public Cidade cadastrar(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}
	
	
	public ResponseEntity<Cidade> atualizar(@RequestBody @Valid  Cidade cidade, Long id) {
		Optional<Cidade> atualizarCidade = cidadeRepository.findById(id);
		if(!atualizarCidade.isPresent()) {
			return ResponseEntity.ok().build();
		}
		cidade.setId(id);
		cidadeRepository.save(cidade);

		return ResponseEntity.noContent().build();
	}
	
	
	public ResponseEntity<Cidade> deletar(@PathVariable Long id){
		Optional<Cidade> deletarCidade = cidadeRepository.findById(id);
		if(deletarCidade.isPresent()) {
			cidadeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}

package br.com.api.rest.service;

import java.util.List;
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
	
	
	public List<CidadeDto> listaCidade(String nomeCidade) {
		if(nomeCidade == null) {
			List<Cidade> cidades = cidadeRepository.findAll();
			return CidadeDto.lista(cidades);
		} else {
			List<Cidade> cidades = cidadeRepository.findByNome(nomeCidade);
			return CidadeDto.lista(cidades);
		}
		
	}
	
	public ResponseEntity<CidadeDto> listarCidadeId(@PathVariable Long id) {
		Optional<Cidade> cidade = cidadeRepository.findById(id);
		if(cidade.isPresent()) {
			return ResponseEntity.ok(new CidadeDto(cidade.get()));
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

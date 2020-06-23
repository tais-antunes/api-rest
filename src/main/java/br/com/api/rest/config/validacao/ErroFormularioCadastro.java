package br.com.api.rest.config.validacao;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ErroFormularioCadastro {
	
	private String campo;
	private String erro;
}

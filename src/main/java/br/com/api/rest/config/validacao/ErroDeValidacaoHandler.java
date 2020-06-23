package br.com.api.rest.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErroDeValidacaoHandler {
	
	@Autowired
	private MessageSource  menssageSource; //classe spring para pegar mensagens de erro

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioCadastro> handle(MethodArgumentNotValidException exception) {
		
		List<ErroFormularioCadastro> erroForm = new ArrayList<>();
		
		List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
		
		fieldErrors.forEach(e -> {
			
			String mensagemErro = menssageSource.getMessage(e, LocaleContextHolder.getLocale());
			
			ErroFormularioCadastro erro = new ErroFormularioCadastro(e.getField(), mensagemErro);
			
			erroForm.add(erro);
		});
		
		return erroForm; 
		
	}
}

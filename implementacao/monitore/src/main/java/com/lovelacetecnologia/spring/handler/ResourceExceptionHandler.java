package com.lovelacetecnologia.spring.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lovelacetecnologia.spring.entity.DetalhesErro;
import com.lovelacetecnologia.spring.services.exceptions.UsuarioJaCadastradoNoSistemaException;
import com.lovelacetecnologia.spring.services.exceptions.UsuarioNaoEncontradoException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(UsuarioNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException(UsuarioNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Usuário não podê ser encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}


	@ExceptionHandler(UsuarioJaCadastradoNoSistemaException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioJaCadastradoNoSistemaException(
			UsuarioJaCadastradoNoSistemaException e, HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Usuário já cadastrado");
		erro.setStatus(409);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/duplicao-usuario/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

}

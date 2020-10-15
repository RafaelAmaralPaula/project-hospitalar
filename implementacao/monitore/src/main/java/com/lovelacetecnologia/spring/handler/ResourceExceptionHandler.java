package com.lovelacetecnologia.spring.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.lovelacetecnologia.spring.entity.DetalhesErro;
import com.lovelacetecnologia.spring.services.exceptions.EspecialidadeExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.EspecialidadeNaoEncontradoException;
import com.lovelacetecnologia.spring.services.exceptions.MedicamentoExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.MedicamentoNaoEncontradoException;
import com.lovelacetecnologia.spring.services.exceptions.MedicoExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.MedicoNaoEncontradoException;
import com.lovelacetecnologia.spring.services.exceptions.PacienteExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.PacienteNaoEncontradoException;
import com.lovelacetecnologia.spring.services.exceptions.UsuarioExistenteException;
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

	@ExceptionHandler(UsuarioExistenteException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioExistenteException(UsuarioExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Usuário já cadastrado");
		erro.setStatus(409);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(EspecialidadeNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioNaoEncontradoException(EspecialidadeNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Usuário não podê ser encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(EspecialidadeExistenteException.class)
	public ResponseEntity<DetalhesErro> handleUsuarioJaCadastradoNoSistemaException(EspecialidadeExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Usuário já cadastrado");
		erro.setStatus(409);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(PacienteNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handlePacienteNaoEncontradoException(PacienteNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Paciente não podê ser encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(PacienteExistenteException.class)
	public ResponseEntity<DetalhesErro> handlePacienteExistenteException(PacienteExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Paciente já cadastrado");
		erro.setStatus(409);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(MedicoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleMedicoNaoEncontradoException(MedicoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Médico não podê ser encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(MedicoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleMedicoExistenteException(MedicoExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Médico já cadastrado");
		erro.setStatus(409);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/409");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(MedicamentoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleMedicamentoExistenteException(MedicamentoExistenteException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Médicamento não podê ser encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(MedicamentoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleMedicamentoNaoEncontratoException(MedicamentoNaoEncontradoException e,
			HttpServletRequest request) {

		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Médicamento não encontrado");
		erro.setStatus(404);
		erro.setMensagemDesenvolvedor("http://monitoreaplications/erros/404");
		erro.setTimestamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

}

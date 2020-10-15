package com.lovelacetecnologia.spring.services.exceptions;

public class PacienteNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PacienteNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public PacienteNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

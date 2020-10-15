package com.lovelacetecnologia.spring.services.exceptions;

public class EspecialidadeNaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -9017868989533776402L;

	public EspecialidadeNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public EspecialidadeNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}

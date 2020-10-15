package com.lovelacetecnologia.spring.services.exceptions;

public class MedicoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MedicoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public MedicoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

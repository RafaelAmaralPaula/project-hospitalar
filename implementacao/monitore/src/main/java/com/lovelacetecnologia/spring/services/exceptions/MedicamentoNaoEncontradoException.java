package com.lovelacetecnologia.spring.services.exceptions;

public class MedicamentoNaoEncontradoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MedicamentoNaoEncontradoException(String mensagem) {
		super(mensagem);
	}

	public MedicamentoNaoEncontradoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

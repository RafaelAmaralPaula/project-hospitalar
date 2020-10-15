package com.lovelacetecnologia.spring.services.exceptions;

public class EspecialidadeExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public EspecialidadeExistenteException(String mensagem) {
		super(mensagem);
	}

	public EspecialidadeExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

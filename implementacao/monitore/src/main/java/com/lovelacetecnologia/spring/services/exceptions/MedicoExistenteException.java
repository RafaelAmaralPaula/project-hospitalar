package com.lovelacetecnologia.spring.services.exceptions;

public class MedicoExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MedicoExistenteException(String mensagem) {
		super(mensagem);
	}

	public MedicoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

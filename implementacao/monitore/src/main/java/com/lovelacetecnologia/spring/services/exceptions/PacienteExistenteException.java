package com.lovelacetecnologia.spring.services.exceptions;

public class PacienteExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PacienteExistenteException(String mensagem) {
		super(mensagem);
	}

	public PacienteExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

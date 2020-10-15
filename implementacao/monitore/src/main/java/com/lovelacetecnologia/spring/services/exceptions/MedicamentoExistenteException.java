package com.lovelacetecnologia.spring.services.exceptions;

public class MedicamentoExistenteException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public MedicamentoExistenteException(String mensagem) {
		super(mensagem);
	}

	public MedicamentoExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

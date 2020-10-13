package com.lovelacetecnologia.spring.services.exceptions;

public class UsuarioJaCadastradoNoSistemaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UsuarioJaCadastradoNoSistemaException(String mensagem) {
		super(mensagem);
	}

	public UsuarioJaCadastradoNoSistemaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}

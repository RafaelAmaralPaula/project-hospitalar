package com.lovelacetecnologia.model;

public class Paciente extends Pessoa {
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}

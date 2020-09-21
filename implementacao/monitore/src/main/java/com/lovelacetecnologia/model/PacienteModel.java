package com.lovelacetecnologia.model;

public class PacienteModel extends PessoaModel {
	private boolean ativo;

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}

package com.lovelacetecnologia.model;

public class Medico extends Pessoa {

	private Especialidade especialidade;
	private boolean ativo;

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade  especialidade) {
		this.especialidade = especialidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}

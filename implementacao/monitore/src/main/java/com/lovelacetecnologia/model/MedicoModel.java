package com.lovelacetecnologia.model;

public class MedicoModel extends PessoaModel {

	private EspecialidadeModel especialidade;
	private boolean ativo;

	public EspecialidadeModel getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(EspecialidadeModel  especialidade) {
		this.especialidade = especialidade;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	

}

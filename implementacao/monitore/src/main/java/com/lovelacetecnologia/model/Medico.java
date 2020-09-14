package com.lovelacetecnologia.model;

public class Medico extends Pessoa {

	private String especialidade;
	private StatusHospital status;

	public Medico() {
	}

	public Medico(String especialidade, StatusHospital status) {
		super();
		this.especialidade = especialidade;
		this.status = status;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public StatusHospital getStatus() {
		return status;
	}

	public void setStatus(StatusHospital status) {
		this.status = status;
	}

}

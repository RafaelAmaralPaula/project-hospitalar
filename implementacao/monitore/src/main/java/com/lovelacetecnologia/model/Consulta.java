package com.lovelacetecnologia.model;

import java.time.LocalDateTime;

public class Consulta {

	private Long codigo;
	private Medico medico;
	private Paciente paciente;
	private LocalDateTime dataEHora;

	public Consulta() {
	}

	public Consulta(Long codigo, Medico medico, Paciente paciente, LocalDateTime dataEHora) {
		this.codigo = codigo;
		this.medico = medico;
		this.paciente = paciente;
		this.dataEHora = dataEHora;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public LocalDateTime getDataEHora() {
		return dataEHora;
	}

	public void setDataEHora(LocalDateTime dataEHora) {
		this.dataEHora = dataEHora;
	}

}

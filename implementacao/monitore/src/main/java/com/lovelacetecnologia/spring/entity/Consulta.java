package com.lovelacetecnologia.spring.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "medico_codigo", nullable = false)
	private Medico medico;

	@ManyToOne
	@JoinColumn(name = "paciente_codigo", nullable = false)
	private Paciente paciente;

	@Column(name = "data_hora", nullable = false)
	private LocalDateTime dataHora;

	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "consulta_medicamento", nullable = false)
	private List<ConsultaMedicamento> itens;

	public Consulta() {
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
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

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataEHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public List<ConsultaMedicamento> getConsultaMedicamento() {
		return itens;
	}

	public void setConsultaMedicamento(List<ConsultaMedicamento> consultaMedicamento) {
		this.itens = consultaMedicamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Consulta other = (Consulta) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

package com.lovelacetecnologia.spring.entity;

import java.util.ArrayList;
import java.util.Date;
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

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "tb_consulta")
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "id_medico", nullable = false)
	private Medico medico;

	@JsonInclude(Include.NON_NULL)
	@ManyToOne
	@JoinColumn(name = "id_paciente", nullable = false)
	private Paciente paciente;

	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "dt_hora", nullable = false)
	private Date dataHora;

	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "consulta")
	private List<ConsultaMedicamento> medicamentos = new ArrayList<ConsultaMedicamento>();

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

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataEHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public List<ConsultaMedicamento> getMedicamentos() {
		return medicamentos;
	}
	
	public void addMedicamento(Medicamento medicamento) {
		ConsultaMedicamento item = new ConsultaMedicamento();
		item.setMedicamento(medicamento);
		item.setPeriodicidade(medicamento.getPeriodidicidade());
		item.setConsulta(this);
		
		medicamentos.add(item);
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

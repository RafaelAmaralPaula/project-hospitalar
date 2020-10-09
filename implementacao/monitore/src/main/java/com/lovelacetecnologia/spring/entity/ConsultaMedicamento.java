package com.lovelacetecnologia.spring.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_consulta_medicamento")
public class ConsultaMedicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@ManyToOne
	@JoinColumn(name = "medicamento_codigo", nullable = false)
	private Medicamento medicamento;

	@Column(name = "quantidade_medicamento_receitado", nullable = false)
	private Integer quantidadeMedicamentoReceitado;

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Medicamento getMedicamento() {
		return medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Integer getQuantidadeMedicamentoReceitado() {
		return quantidadeMedicamentoReceitado;
	}

	public void setQuantidadeMedicamentoReceitado(Integer quantidadeMedicamentoReceitado) {
		this.quantidadeMedicamentoReceitado = quantidadeMedicamentoReceitado;
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
		ConsultaMedicamento other = (ConsultaMedicamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

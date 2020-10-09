package com.lovelacetecnologia.spring.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_medicamento")
public class Medicamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	@Column(length = 70, nullable = false)
	private String nome;

	@Column(nullable = false)
	private Integer dosagem;

	@Column(name = "quantidade_estoque", nullable = false)
	private int quantidadeEstoque;

	@Column(name = "hora_tomar_medicamento")
	private LocalDateTime horaTomarMedicamento;

	public Integer getId() {
		return codigo;
	}

	public void setId(Integer id) {
		this.codigo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getDosagem() {
		return dosagem;
	}

	public void setDosagem(Integer dosagem) {
		this.dosagem = dosagem;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public LocalDateTime getHoraTomarMedicamento() {
		return horaTomarMedicamento;
	}

	public void setHoraTomarMedicamento(LocalDateTime horaTomarMedicamento) {
		this.horaTomarMedicamento = horaTomarMedicamento;
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
		Medicamento other = (Medicamento) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

package com.lovelacetecnologia.repository;

import java.util.List;

import com.lovelacetecnologia.model.Paciente;

public interface IPaciente {
	
	public void incluir(Paciente paciente);
	
	public void alterar(Paciente paciente);
	
	public void excluir(int codigoPaciente);
	
	public List<Paciente> listarTodos();
	
	public Paciente buscarPeloCodigo(int codigoPaciente);
	
}

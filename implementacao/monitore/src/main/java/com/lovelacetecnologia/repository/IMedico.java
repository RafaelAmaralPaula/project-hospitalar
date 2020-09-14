package com.lovelacetecnologia.repository;

import java.util.List;

import com.lovelacetecnologia.model.Medico;

public interface IMedico {
	
	public void criar(Medico medico);
	
	public void alterar(Medico medico);
	
	public void excluir(int codigoMedico);
	
	public List<Medico> listarTodos();
	
	public Medico buscarPeloCodigo(int codigoMedico);
	
}

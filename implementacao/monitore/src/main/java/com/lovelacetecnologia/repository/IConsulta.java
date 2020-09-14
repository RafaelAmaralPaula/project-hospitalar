package com.lovelacetecnologia.repository;

import java.util.List;

import com.lovelacetecnologia.model.Consulta;

public interface IConsulta {
	
	public void criar(Consulta consulta);
	
	public void alterar(Consulta consulta);
	
	public void excluir(int codigoConsulta);
	
	public List<Consulta> listarTodos();
	
	public Consulta buscarPeloCodigo(int codigoConsulta);
	
}

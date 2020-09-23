package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Consulta;
import com.lovelacetecnologia.spring.repository.ConsultaRepository;

@Component
public class ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;
	
	public void salvar(Consulta consulta) {
		consultaRepository.save(consulta);
		
	}
	
	public void alterar(Consulta consulta) {
		Optional<Consulta>consultaEncontrada = consultaRepository.findById(consulta.getCodigo());
		if(consultaEncontrada.isPresent()) {
			Consulta consultaSave = consultaEncontrada.get();
			
			consultaSave.setCodigo(consulta.getCodigo());
			consultaSave.setMedico(consulta.getMedico());
			consultaSave.setPaciente(consulta.getPaciente());
			consultaSave.setDataEHora(consulta.getDataHora());
			
			consultaRepository.save(consultaSave);
			
		}else {
			System.out.println("Consulta não encontrada");
		}

	}
	
	public void deletar(Integer id){
		consultaRepository.deleteById(id);
		
	}
	
	
	public List<Consulta> listarTodasConsultas(){
		return consultaRepository.findAll();
	}
	
	
	public Consulta buscarPeloCodigo(Integer id){
	Optional<Consulta>consultaEncontrada = consultaRepository.findById(id) ;
		return consultaEncontrada.get();
	
	}
	
	
	
}

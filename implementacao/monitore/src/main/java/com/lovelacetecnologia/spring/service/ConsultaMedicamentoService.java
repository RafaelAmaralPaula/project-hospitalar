package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.ConsultaMedicamento;
import com.lovelacetecnologia.spring.repository.ConsultaMedicamentoRepository;

@Component
public class ConsultaMedicamentoService {
	
	@Autowired
	private ConsultaMedicamentoRepository consultaMedicamentoRepository;

	public void salvar(ConsultaMedicamento consultaMedicamento) {
		consultaMedicamentoRepository.save(consultaMedicamento);
	}

	public void alterar(ConsultaMedicamento consultaMedicamento) {
		Optional<ConsultaMedicamento> consultaMedicamentoEncontrada = 
				        consultaMedicamentoRepository.findById(consultaMedicamento.getCodigo());

		if (consultaMedicamentoEncontrada.isPresent()) {
			ConsultaMedicamento consultaMedicamentoAlterar = consultaMedicamentoEncontrada.get();
			consultaMedicamentoAlterar.setMedicamento(consultaMedicamento.getMedicamento());

		} else {
			System.out.println("Especialidade não encontrada !!!");
		}

	}

	public void deletar(Integer id) {
		consultaMedicamentoRepository.deleteById(id);
	}

	public List<ConsultaMedicamento> listarTodasConsultaMedicamentos() {
		return consultaMedicamentoRepository.findAll();
	}

	public ConsultaMedicamento buscarPeloCodigo(Integer id) {
		Optional<ConsultaMedicamento> consultaMedicamentoEncontrada = consultaMedicamentoRepository.findById(id);
		return consultaMedicamentoEncontrada.get();
	}

}

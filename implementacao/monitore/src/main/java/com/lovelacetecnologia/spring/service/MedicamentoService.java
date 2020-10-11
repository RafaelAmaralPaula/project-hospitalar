package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Medicamento;
import com.lovelacetecnologia.spring.repository.MedicamentoRepository;

@Component
public class MedicamentoService {
	
	@Autowired
	private MedicamentoRepository medicamentoRepository;

	public void salvar(Medicamento medicamento) {
		medicamentoRepository.save(medicamento);
	}

	public void alterar(Medicamento medicamento) {
//	//	Optional<Medicamento> medicamentoEncontrado = medicamentoRepository.findById(medicamento.getId());
//
//		if (medicamentoEncontrado.isPresent()) {
//			Medicamento medicamentoAlterar =  medicamentoEncontrado.get();
//			medicamentoAlterar.setNome(medicamento.getNome());
//			medicamentoAlterar.setDosagem(medicamento.getDosagem());
//			//medicamentoAlterar.setHoraTomarMedicamento(medicamento.getHoraTomarMedicamento());
//			//medicamentoAlterar.setQuantidadeEstoque(medicamento.getQuantidadeEstoque());
//			
//			medicamentoRepository.save(medicamentoAlterar);
//
//		} else {
//			System.out.println("Especialidade não encontrada !!!");
//		}

	}

	public void deletar(Integer id) {
		medicamentoRepository.deleteById(id);
	}

	public List<Medicamento> listarTodosMedicamentos() {
		return medicamentoRepository.findAll();
	}

	public Medicamento buscarPeloCodigo(Integer id) {
		Optional<Medicamento> medicamentoEncontrada = medicamentoRepository.findById(id);
		return medicamentoEncontrada.get();
	}


}

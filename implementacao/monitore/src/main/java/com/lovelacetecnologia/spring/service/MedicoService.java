package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.repository.MedicoRepository;

@Component
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;

	public void salvar(Medico medico) {
		medicoRepository.save(medico);

	}

	public void alterar(Medico medico) {
		Optional<Medico> medicoEncontrado = medicoRepository.findById(medico.getCodigo());
		if (medicoEncontrado.isPresent()) {
			Medico medicoAlterar = medicoEncontrado.get();

			medicoAlterar.setNome(medico.getNome());
			medicoAlterar.setEmail(medico.getEmail());
			medicoAlterar.setEndereco(medico.getEmail());
			medicoAlterar.setDataNascimento(medico.getDataNascimento());
			medicoAlterar.setAtivo(medico.isAtivo());
			medicoAlterar.setEspecialidade(medico.getEspecialidade());

			medicoRepository.save(medico);

		} else {
			System.out.println("Paciente não encontrado");
		}

	}

	public void deletar(Integer id) {
		medicoRepository.deleteById(id);

	}

	public List<Medico> listarTodosMedicos() {
		return medicoRepository.findAll();
	}

	public Medico buscarPeloCodigo(Integer id) {
		Optional<Medico> medicoEncontrado = medicoRepository.findById(id);
		return medicoEncontrado.get();

	}

}

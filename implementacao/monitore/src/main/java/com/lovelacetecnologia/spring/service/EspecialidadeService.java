package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.repository.EspecialidadeRepository;

@Component
public class EspecialidadeService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public void salvar(Especialidade especialidade) {
		especialidadeRepository.save(especialidade);
	}

	public void alterar(Especialidade especialidade) {
		Optional<Especialidade> especialidadeEncontrada = especialidadeRepository.findById(especialidade.getCodigo());

		if (especialidadeEncontrada.isPresent()) {

			Especialidade especialidadeAlterar = especialidadeEncontrada.get();
			especialidadeAlterar.setNome(especialidade.getNome());

			especialidadeRepository.save(especialidadeAlterar);

		} else {
			System.out.println("Especialidade não encontrada !!!");
		}

	}

	public void deletar(Integer id) {
		especialidadeRepository.deleteById(id);
	}

	public List<Especialidade> listarTodasEspecialidades() {
		return especialidadeRepository.findAll();
	}

	public Especialidade buscarPeloCodigo(Integer id) {
		Optional<Especialidade> especialidadeEncontrada = especialidadeRepository.findById(id);
		return especialidadeEncontrada.get();
	}

}

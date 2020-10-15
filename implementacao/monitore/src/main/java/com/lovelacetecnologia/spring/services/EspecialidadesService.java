package com.lovelacetecnologia.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.repository.EspecialidadeRepository;
import com.lovelacetecnologia.spring.services.exceptions.EspecialidadeExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.EspecialidadeNaoEncontradoException;

@Service
public class EspecialidadesService {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public List<Especialidade> listar() {
		return especialidadeRepository.findAll();
	}

	public Especialidade salvar(Especialidade especialidade) {
		Especialidade find = especialidadeRepository.findByNome(especialidade.getNome());

		if (find != null) {
			throw new EspecialidadeExistenteException("Especialidade já está cadastrado");
		}

		especialidadeRepository.save(especialidade);
		return especialidade;
	}

	public void deletar(Integer codigo) {
		try {
			especialidadeRepository.findByCodigo(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new EspecialidadeNaoEncontradoException("A Especialidade não podê ser encontrado");
		}

	}

	public Especialidade buscarPeloCodigo(Integer codigo) {
		Especialidade find = especialidadeRepository.findByCodigo(codigo);

		if (find == null) {
			throw new EspecialidadeNaoEncontradoException("A Especialidade não podê ser encontrado");
		}

		return find;
	}
	
	public Especialidade buscarPeloNome(String nome) {
		Especialidade find = especialidadeRepository.findByNome(nome);

		if (find == null) {
			throw new EspecialidadeNaoEncontradoException("A Especialidade não podê ser encontrado");
		}

		return find;
	}

	public void alterar(Especialidade especialidade) {
		Especialidade find = buscarPeloCodigo(especialidade.getCodigo());
		especialidadeRepository.save(find);
	}



}

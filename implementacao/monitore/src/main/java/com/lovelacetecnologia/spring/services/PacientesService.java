package com.lovelacetecnologia.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.repository.PacienteRepository;
import com.lovelacetecnologia.spring.services.exceptions.PacienteExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.PacienteNaoEncontradoException;

@Service
public class PacientesService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}

	public Paciente salvar(Paciente paciente) {
		Paciente find = pacienteRepository.findByCpf(paciente.getCpf());

		if (find != null) {
			throw new PacienteExistenteException("Paciente já existente");
		}

		pacienteRepository.save(paciente);
		return paciente;
	}

	public void deletar(Integer codigo) {
		try {
			pacienteRepository.findByCodigo(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new PacienteNaoEncontradoException("O usuário não podê ser encontrado");
		}

	}

	public Paciente buscarPeloCodigo(Integer codigo) {
		Paciente find = pacienteRepository.findByCodigo(codigo);

		if (find == null) {
			throw new PacienteNaoEncontradoException("Paciente não podê ser encontrado");
		}

		return find;
	}
	
	public Paciente buscarPeloCpf(String cpf) {
		Paciente find = pacienteRepository.findByCpf(cpf);

		if (find == null) {
			throw new PacienteNaoEncontradoException("Paciente não podê ser encontrado");
		}

		return find;
	}


	public void alterar(Paciente paciente) {
		Paciente find  = pacienteRepository.findByCodigo(paciente.getCodigo());
		pacienteRepository.save(find);
	}


}

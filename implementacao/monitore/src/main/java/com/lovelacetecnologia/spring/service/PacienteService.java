package com.lovelacetecnologia.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.repository.PacienteRepository;

@Component
public class PacienteService {
	
	@Autowired
	private PacienteRepository pacienteRepository;

	public void salvar(Paciente paciente) {
		pacienteRepository.save(paciente);

	}

	public void alterar(Paciente paciente) {
		Optional<Paciente> pacienteEncontrada = pacienteRepository.findById(paciente.getCodigo());
		if (pacienteEncontrada.isPresent()) {
			Paciente pacienteAlterado = pacienteEncontrada.get();

			//pacienteAlterado.setCodigo(paciente.getCodigo());
			pacienteAlterado.setNome(paciente.getNome());
			pacienteAlterado.setEmail(paciente.getEmail());
			pacienteAlterado.setEndereco(paciente.getEndereco());
			pacienteAlterado.setDataNascimento(paciente.getDataNascimento());
		
			pacienteRepository.save(pacienteAlterado);
			

		} else {
			System.out.println("Paciente não encontrado");
		}

	}

	public void deletar(Integer id) {
		pacienteRepository.deleteById(id);

	}

	public List<Paciente> listarTodosPacientes() {
		return pacienteRepository.findAll();
	}

	public Paciente buscarPeloCodigo(Integer id) {
		Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(id);
		return pacienteEncontrado.get();

	}

}

package com.lovelacetecnologia.spring.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.repository.PacienteRepository;

@RestController
@RequestMapping("/pacientes")
public class PacientesResources {

	@Autowired
	private PacienteRepository pacienteRepository;

	@GetMapping
	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer codigo) {
		pacienteRepository.deleteById(codigo);
	}

	@PutMapping("/{id}")
	public void alterar(@RequestBody Paciente paciente, @PathVariable("id") Integer codigo) {
		paciente.setCodigo(codigo);
		pacienteRepository.save(paciente);
	}

	@GetMapping("/{id}")
	public Paciente buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		return pacienteRepository.findByCodigo(codigo);
	}

	@GetMapping("/cpf/{cpf}")
	public Paciente buscarPeloCpf(@PathVariable("cpf") String cpf) {
		return pacienteRepository.findByCpf(cpf);
	}
}

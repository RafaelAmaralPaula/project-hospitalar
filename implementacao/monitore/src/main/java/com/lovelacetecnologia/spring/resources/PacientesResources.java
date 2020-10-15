package com.lovelacetecnologia.spring.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.services.PacientesService;

@RestController
@RequestMapping("/pacientes")
public class PacientesResources {

	@Autowired
	private PacientesService pacienteService;

	@GetMapping
	public ResponseEntity<List<Paciente>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(pacienteService.listar());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Paciente paciente) {

		paciente = pacienteService.salvar(paciente);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(paciente.getCodigo())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer codigo) {
		pacienteService.deletar(codigo);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Paciente paciente, @PathVariable("id") Integer codigo) {
		paciente.setCodigo(codigo);
		pacienteService.alterar(paciente);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Paciente> buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		Paciente find = pacienteService.buscarPeloCodigo(codigo);

		return ResponseEntity.status(HttpStatus.OK).body(find);
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<Paciente> buscarPeloCpf(@PathVariable("cpf") String cpf) {
		Paciente find = pacienteService.buscarPeloCpf(cpf);

		return ResponseEntity.status(HttpStatus.OK).body(find);
	}
}

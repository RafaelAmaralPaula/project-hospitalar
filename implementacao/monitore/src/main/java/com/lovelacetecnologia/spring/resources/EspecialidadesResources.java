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

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.services.EspecialidadesService;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadesResources {

	@Autowired
	private EspecialidadesService especialidadesService;

	@GetMapping
	public ResponseEntity<List<Especialidade>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(especialidadesService.listar());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Especialidade especialidade) {
		especialidade = especialidadesService.salvar(especialidade);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(especialidade.getCodigo()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer codigo) {
		especialidadesService.deletar(codigo);

		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Especialidade especialidade, @PathVariable("id") Integer codigo) {
		especialidade.setCodigo(codigo);
		especialidadesService.alterar(especialidade);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Especialidade> buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		Especialidade find = especialidadesService.buscarPeloCodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(find);
	}

	@GetMapping("/nome/{nome}")
	public ResponseEntity<Especialidade> buscarPeloNome(@PathVariable("nome") String nome) {
		Especialidade find = especialidadesService.buscarPeloNome(nome);

		return ResponseEntity.status(HttpStatus.OK).body(find);
	}

}

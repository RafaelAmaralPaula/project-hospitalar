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

import com.lovelacetecnologia.spring.entity.Medicamento;
import com.lovelacetecnologia.spring.services.MedicamentosServices;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosResources {

	@Autowired
	private MedicamentosServices medicamentosService;

	@GetMapping
	public ResponseEntity<List<Medicamento>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(medicamentosService.listar());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Medicamento medicamento) {
		medicamento = medicamentosService.salvar(medicamento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(medicamento.getCodigo())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamento> buscar(@PathVariable("id") Integer codigo) {

		Medicamento find = medicamentosService.buscarPeloCodigo(codigo);

		return ResponseEntity.status(HttpStatus.OK).body(find);
	}

	@GetMapping("/codigobarras/{codigo}")
	public ResponseEntity<Medicamento> buscarCodigoBarras(@PathVariable("codigo") String codigoBarras) {
		Medicamento find = medicamentosService.buscarPeloCodigoBarras(codigoBarras);

		return ResponseEntity.status(HttpStatus.OK).body(find);

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer codigo) {
		medicamentosService.deletar(codigo);
		
		return ResponseEntity.noContent().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Medicamento medicamento, @PathVariable("id") Integer codigo) {
		medicamento.setCodigo(codigo);
		medicamentosService.alterar(medicamento);
		
		return ResponseEntity.noContent().build();
	}
}

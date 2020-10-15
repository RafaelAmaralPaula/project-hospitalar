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

import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.services.MedicosService;
@RestController
@RequestMapping("/medicos")
public class MedicosResources {
	
	@Autowired
	private MedicosService medicosService;
	
	@GetMapping
	public ResponseEntity<List<Medico>> listar(){
		return ResponseEntity.status(HttpStatus.OK).body(medicosService.listar());
	}
	
	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Medico medico) {
		medico = medicosService.salvar(medico);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(medico.getCodigo())
					.toUri();
		
		return ResponseEntity.created(uri).build();
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer codigo) {
		medicosService.deletar(codigo);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Medico medico , @PathVariable("id") Integer codigo) {
		medico.setCodigo(codigo);
		medicosService.alterar(medico);
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		Medico find = medicosService.buscarPeloCodigo(codigo);
		
		return ResponseEntity.status(HttpStatus.OK).body(find);
	}
	
	@GetMapping("/crm/{crm}")
	public ResponseEntity<Medico> buscarPeloCodigo(@PathVariable("crm") String crm) {
		Medico find = medicosService.buscarPeloCrm(crm);
		
		return ResponseEntity.status(HttpStatus.OK).body(find);
	}
	
}

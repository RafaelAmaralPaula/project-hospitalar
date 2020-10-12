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

import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.repository.MedicoRepository;
@RestController
@RequestMapping("/medicos")
public class MedicosResources {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@GetMapping
	public List<Medico> listar(){
		return medicoRepository.findAll();
	}
	
	@PostMapping
	public void salvar(@RequestBody Medico medico) {
		medicoRepository.save(medico);
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer codigo) {
		medicoRepository.deleteById(codigo);
	}
	
	@PutMapping("/{id}")
	public void alterar(@RequestBody Medico medico , @PathVariable("id") Integer codigo) {
		medico.setCodigo(codigo);
		medicoRepository.save(medico);
	}
	
	@GetMapping("/{id}")
	public Medico buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		return medicoRepository.findByCodigo(codigo);
	}
	
	@GetMapping("/crm/{crm}")
	public Medico buscarPeloCodigo(@PathVariable("crm") String crm) {
		return medicoRepository.findByCrm(crm);
	}
	
}

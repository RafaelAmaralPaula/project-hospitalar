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

import com.lovelacetecnologia.spring.entity.Medicamento;
import com.lovelacetecnologia.spring.repository.MedicamentoRepository;

@RestController
@RequestMapping("/medicamentos")
public class MedicamentosResources {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	@GetMapping
	public List<Medicamento> listar() {
		return medicamentoRepository.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody Medicamento medicamento) {
		medicamentoRepository.save(medicamento);
	}

	@GetMapping("/{id}")
	public Medicamento buscar(@PathVariable("id") Integer codigo) {
		return medicamentoRepository.findByCodigo(codigo);
	}
	
	@GetMapping("/codigobarras/{codigo}")
	public Medicamento buscarCodigoBarras(@PathVariable("codigo") String codigoBarras) {
		return medicamentoRepository.findByCodigoBarras(codigoBarras);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id")Integer codigo) {
		medicamentoRepository.deleteById(codigo);
	}
	@PutMapping("/{id}")
	public void alterar(@RequestBody Medicamento medicamento, @PathVariable("id")Integer codigo) {
		medicamento.setCodigo(codigo);
		medicamentoRepository.save(medicamento);
	}
}

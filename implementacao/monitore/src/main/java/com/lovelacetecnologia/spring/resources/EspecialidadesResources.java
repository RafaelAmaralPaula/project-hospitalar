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

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.repository.EspecialidadeRepository;

@RestController
@RequestMapping("/especialidades")
public class EspecialidadesResources {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	@GetMapping
	public List<Especialidade> listar() {
		return especialidadeRepository.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody Especialidade especialidade) {
		especialidadeRepository.save(especialidade);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id")Integer codigo) {
		especialidadeRepository.deleteById(codigo);
	}

	@PutMapping("/{id}")
	public void alterar(@RequestBody Especialidade especialidade, @PathVariable("id") Integer codigo) {
		especialidade.setCodigo(codigo);
		especialidadeRepository.save(especialidade);
	}

	@GetMapping("/{id}")
	public Especialidade buscarPeloCodigo(@PathVariable("id")Integer codigo) {
		return especialidadeRepository.findByCodigo(codigo);
	}

	@GetMapping("/nome/{nome}")
	public Especialidade buscarPeloCodigo(@PathVariable("nome")String nome) {
		return especialidadeRepository.findByNome(nome);
	}
}

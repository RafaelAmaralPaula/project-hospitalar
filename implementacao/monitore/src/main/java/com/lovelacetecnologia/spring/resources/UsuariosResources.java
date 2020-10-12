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

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResources {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody Usuario usuario) {
		usuarioRepository.save(usuario);
	}

	@DeleteMapping("/{id}")
	public void deletar(@PathVariable("id") Integer codigo) {
		usuarioRepository.deleteById(codigo);
	}

	@PutMapping("/{id}")
	public void alterar(@RequestBody Usuario usuario , @PathVariable("id") Integer codigo) {
		usuario.setCodigo(codigo);
		usuarioRepository.save(usuario);
	}
	
	@GetMapping("/{id}")
	public Usuario buscarPeloCodigo(@PathVariable("id")Integer codigo) {
		return usuarioRepository.findByCodigo(codigo);
	}
	
	
	@GetMapping("/user/{user}")
	public Usuario buscarPeloCodigo(@PathVariable("user")String username) {
		return usuarioRepository.findByUsername(username);
	}
	
}

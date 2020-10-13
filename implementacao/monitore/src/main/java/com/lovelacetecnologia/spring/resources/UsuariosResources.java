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

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.services.UsuariosService;

@RestController
@RequestMapping("/usuarios")
public class UsuariosResources {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping
	public ResponseEntity<List<Usuario>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(usuariosService.listar());
	}

	@PostMapping
	public ResponseEntity<Void> salvar(@RequestBody Usuario usuario) {
		usuario = usuariosService.salvar(usuario);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().
				path("/{id}").buildAndExpand(usuario.getCodigo()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer codigo) {
		usuariosService.deletar(codigo);

		return ResponseEntity.noContent().build();

	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> altualizar(@RequestBody Usuario usuario, @PathVariable("id") Integer codigo) {

		usuario.setCodigo(codigo);
		usuariosService.alterar(usuario);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPeloCodigo(@PathVariable("id") Integer codigo) {
		Usuario usuario = usuariosService.buscarPeloCodigo(codigo);
		return ResponseEntity.status(HttpStatus.OK).body(usuario);

	}

//	@GetMapping("/user/{user}")
//	public Usuario buscarPeloCodigo(@PathVariable("user") String username) {
//		return usuarioRepository.findByUsername(username);
//	}

}

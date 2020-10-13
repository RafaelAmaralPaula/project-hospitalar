package com.lovelacetecnologia.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.repository.UsuarioRepository;
import com.lovelacetecnologia.spring.services.exceptions.UsuarioJaCadastradoNoSistemaException;
import com.lovelacetecnologia.spring.services.exceptions.UsuarioNaoEncontradoException;

@Service
public class UsuariosService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> listar() {
		return usuarioRepository.findAll();
	}

	public Usuario salvar(Usuario usuario) {
		Usuario find = usuarioRepository.findByUsername(usuario.getUsername());

		if (find != null) {
			throw new UsuarioJaCadastradoNoSistemaException("Usuário já está cadastrado");
		}

		usuarioRepository.save(usuario);
		return usuario;
	}

	public void deletar(Integer codigo) {
		try {
			usuarioRepository.findByCodigo(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new UsuarioNaoEncontradoException("O usuário não podê ser encontrado");
		}

	}

	public Usuario buscarPeloCodigo(Integer codigo) {
		Usuario usuario = usuarioRepository.findByCodigo(codigo);

		if (usuario == null) {
			throw new UsuarioNaoEncontradoException("Usuário não podê ser encontrado");
		}

		return usuario;
	}

	public void alterar(Usuario usuario) {
		verrificarExistencia(usuario.getCodigo());
		usuarioRepository.save(usuario);
	}

	private void verrificarExistencia(Integer codigo) {
		buscarPeloCodigo(codigo);
	}

}

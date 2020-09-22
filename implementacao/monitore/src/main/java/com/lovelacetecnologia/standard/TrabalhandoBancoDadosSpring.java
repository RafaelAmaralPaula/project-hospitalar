package com.lovelacetecnologia.standard;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.repository.UsuarioRepository;

@Component
public class TrabalhandoBancoDadosSpring {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	public void salvar(Usuario usuario){
		usuarioRepository.save(usuario);
	}
	
	public void alterar(Usuario usuario){
		Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario.getCodigo());
		if(usuarioEncontrado.isPresent()) {
			Usuario userSave = usuarioEncontrado.get();
			
			userSave.setNome(usuario.getNome());
			userSave.setUsername(usuario.getUsername());
			userSave.setSenha(usuario.getSenha());
			userSave.setAtivo(usuario.isAtivo());
			
			usuarioRepository.save(userSave);
			
		}else {
			System.out.println("Usuário não encontrado");
		}
		
	}
	
	public List<Usuario> usuarios(){
		return usuarioRepository.findAll();
	}
	
	public void deletar(Integer codigo) {
		usuarioRepository.deleteById(codigo);
	}
	
	public Usuario buscarPeloCodigo(Integer codigo) {
		Optional<Usuario> userEncontrado = usuarioRepository.findById(codigo);
		return userEncontrado.get();
	}
	
}

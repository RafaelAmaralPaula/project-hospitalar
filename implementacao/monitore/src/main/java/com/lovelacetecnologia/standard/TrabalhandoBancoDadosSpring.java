package com.lovelacetecnologia.standard;

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
	
	
	
}

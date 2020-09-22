package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovelacetecnologia.spring.entity.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
	
}

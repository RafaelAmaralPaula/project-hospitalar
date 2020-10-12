package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Usuario;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
//
//PESQUISAR JPQL
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
	Usuario findByUsername(String username);
	
	
	Usuario findByCodigo(Integer codigo);

	
}

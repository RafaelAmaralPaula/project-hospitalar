package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Usuario;

//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
//
//PESQUISAR JPQL
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	
	Usuario findByUsername(String username);
	
	@Query("SELECT c FROM Usuario c WHERE c.username = :username")
	Usuario buscarPorLogin(@Param("username") String username);
	
}

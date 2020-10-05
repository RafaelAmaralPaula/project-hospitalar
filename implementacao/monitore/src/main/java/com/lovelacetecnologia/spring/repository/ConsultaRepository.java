package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Consulta;

@Repository
public interface ConsultaRepository extends JpaRepository<Consulta, Integer> {
			
}

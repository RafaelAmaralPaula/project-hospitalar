package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovelacetecnologia.spring.entity.Medico;


public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}

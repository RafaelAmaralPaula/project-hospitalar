package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}

package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Especialidade;

@Repository
public interface EspecialidadeRepository extends JpaRepository<Especialidade, Integer> {

}

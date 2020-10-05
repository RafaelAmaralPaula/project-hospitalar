package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}

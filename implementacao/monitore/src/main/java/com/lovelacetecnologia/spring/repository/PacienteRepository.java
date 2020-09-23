package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lovelacetecnologia.spring.entity.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Integer>{

}

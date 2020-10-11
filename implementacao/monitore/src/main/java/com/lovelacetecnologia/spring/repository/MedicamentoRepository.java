package com.lovelacetecnologia.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lovelacetecnologia.spring.entity.Medicamento;

@Repository
public interface MedicamentoRepository extends JpaRepository<Medicamento, Integer>{
	
	Medicamento findByCodigoBarras(String codigoBarras);
	
	Medicamento findByCodigo(Integer id);
	
}

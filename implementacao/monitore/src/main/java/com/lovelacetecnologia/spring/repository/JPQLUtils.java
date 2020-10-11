package com.lovelacetecnologia.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Medicamento;

@Component
public class JPQLUtils {
	@PersistenceContext
	private EntityManager em;
	
	public Medicamento buscarMedicamentoPorCodigoBarras(String codigoBarras) {
		
		return null;
	}
}

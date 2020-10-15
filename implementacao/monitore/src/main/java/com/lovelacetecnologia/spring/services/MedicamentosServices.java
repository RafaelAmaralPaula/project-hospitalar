package com.lovelacetecnologia.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lovelacetecnologia.spring.entity.Medicamento;
import com.lovelacetecnologia.spring.repository.MedicamentoRepository;
import com.lovelacetecnologia.spring.services.exceptions.MedicamentoExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.MedicamentoNaoEncontradoException;

@Service
public class MedicamentosServices {

	@Autowired
	private MedicamentoRepository medicamentoRepository;

	public List<Medicamento> listar() {
		return medicamentoRepository.findAll();
	}

	public Medicamento salvar(Medicamento medicamento) {
		Medicamento find = medicamentoRepository.findByCodigoBarras(medicamento.getCodigoBarras());

		if (find != null) {
			throw new MedicamentoExistenteException("Medicamento já está cadastrado");
		}

		medicamentoRepository.save(medicamento);
		return medicamento;
	}

	public void deletar(Integer codigo) {
		try {
			medicamentoRepository.findByCodigo(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new MedicamentoNaoEncontradoException("O Medicamento não podê ser encontrado");
		}

	}

	public Medicamento buscarPeloCodigo(Integer codigo) {
		Medicamento find = medicamentoRepository.findByCodigo(codigo);

		if (find == null) {
			throw new MedicamentoNaoEncontradoException("O Medicamento não podê ser encontrado");
		}

		return find;
	}

	public Medicamento buscarPeloCodigoBarras(String codigoBarras) {
		Medicamento find = medicamentoRepository.findByCodigoBarras(codigoBarras);

		if (find == null) {
			throw new MedicamentoNaoEncontradoException("O Medicamento não podê ser encontrado");
		}

		return find;
	}
	
	public void alterar(Medicamento medicamento) {
		Medicamento find = buscarPeloCodigo(medicamento.getCodigo());
		medicamentoRepository.save(find);
	}



}

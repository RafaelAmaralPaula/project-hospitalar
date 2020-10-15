package com.lovelacetecnologia.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.repository.MedicoRepository;
import com.lovelacetecnologia.spring.services.exceptions.MedicoExistenteException;
import com.lovelacetecnologia.spring.services.exceptions.MedicoNaoEncontradoException;

@Service
public class MedicosService {

	@Autowired
	private MedicoRepository medicoRepository;

	public List<Medico> listar() {
		return medicoRepository.findAll();
	}

	public Medico salvar(Medico medico) {
		Medico find = medicoRepository.findByCrm(medico.getCrm());
		if (find != null) {
			throw new MedicoExistenteException("Médico já está cadastrado");
		}

		medicoRepository.save(medico);
		return medico;
	}

	public void deletar(Integer codigo) {
		try {
			medicoRepository.findByCodigo(codigo);
		} catch (EmptyResultDataAccessException e) {
			throw new MedicoNaoEncontradoException("O Médico não podê ser encontrado");
		}

	}

	public Medico buscarPeloCodigo(Integer codigo) {
		Medico find = medicoRepository.findByCodigo(codigo);

		if (find == null) {
			throw new MedicoNaoEncontradoException("Médico não podê ser encontrado");
		}

		return find;
	}

	public Medico buscarPeloCrm(String crm) {
		Medico find = medicoRepository.findByCrm(crm);

		if (find == null) {
			throw new MedicoNaoEncontradoException("Médico não podê ser encontrado");
		}

		return find;
	}

	public void alterar(Medico medico) {
		Medico find = buscarPeloCodigo(medico.getCodigo());
		medicoRepository.save(find);
	}

}

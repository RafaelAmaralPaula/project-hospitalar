package com.lovelacetecnologia.spring.aplicacao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.entity.Medico;
import com.lovelacetecnologia.spring.repository.EspecialidadeRepository;
import com.lovelacetecnologia.spring.repository.MedicoRepository;


@Component
public class SpringAplicacaoMedico {

	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private EspecialidadeRepository especialidadeRepository;
	
	public void execute() {
		cadastrarMedico();
		alterar();
		deletar();
		listarTodos();
		buscarPeloCodigo();
		bucarPeloCrm();
	}
	
	
	private void cadastrarMedico() {
		
		Especialidade findEspecialidade = especialidadeRepository.findByCodigo(1);
		
		Medico medico = new Medico();
		medico.setNome("Ricardo");
		medico.setCrm("47383979579");
		medico.setEmail("contato@ricardo.com");
		medico.setEndereco("Rua coronel Nº355 SP-Capital");
		medico.setDataNascimento(Date.valueOf("01/12/2001"));
		medico.setEspecialidade(findEspecialidade);
		
		Medico findMedico = medicoRepository.findByCrm(medico.getCrm());
		
		if(findMedico == null && findEspecialidade != null) {
			medicoRepository.save(medico);
			
			System.out.println("MÉDICO SALVO COM SUCESSO");
			
		}else {
			System.err.println("[ERROR] ao salvar médico pois já existe ...");
		}
	}
	
	private void alterar() {
		
		Especialidade findEspecialidade = especialidadeRepository.findByCodigo(2);
		
		Medico medico = new Medico();
		medico.setCodigo(1);
		medico.setNome("teste");
		medico.setCrm("47383979579");
		medico.setEmail("contato@ricardo.com");
		medico.setEndereco("Rua coronel Nº355 SP-Capital");
		medico.setDataNascimento(Date.valueOf("12/05/1878"));
		medico.setEspecialidade(findEspecialidade);
		
		Medico findMedico = medicoRepository.findByCodigo(medico.getCodigo());
		
		if(findEspecialidade != null && findMedico != null ) {
			
			findMedico.setNome(medico.getNome());
			findMedico.setCrm(medico.getCrm());
			findMedico.setEmail(medico.getEmail());
			findMedico.setEndereco(medico.getEndereco());
			findMedico.setDataNascimento(medico.getDataNascimento());
			findMedico.setEspecialidade(medico.getEspecialidade());

			medicoRepository.save(findMedico);
			System.out.println("MÉDICO ALTERADO COM SUCESSO");
		}else {
			System.err.println("[ERROR] ao alterar médico pois médico ou especialidade não existe...");
		}
		
	}
	
	private void deletar() {
		Medico find = medicoRepository.findByCodigo(1);
		if(find != null) {
			medicoRepository.deleteById(find.getCodigo());
			
			System.out.println("MÉDICO DELETADO COM SUCESSO");
			
		}else {
			System.err.println("[ERROR] ao deletar pois o médico não existe ...");
		}
	}
	private void listarTodos() {
		List<Medico> medicos = medicoRepository.findAll();
		
		if(medicos.isEmpty()) {
			System.out.println("Nada a exibir pois não há médicos cadastrado");
		}else {
			for(Medico medico : medicos) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("**************************MÉDICOS**************************");
				System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
				System.out.println("-----------------------------------------------------------");
				System.out.println("LISTAGEM DE TODOS USUÁRIOS DO SISTEMA : ");
				System.out.println("");
				System.out.println("NOME -> " + medico.getNome());
				System.out.println("CRM -> " + medico.getCrm());
				System.out.println("E-MAIL -> " + medico.getEmail());
				System.out.println("DATA NASCIMENTO -> " + medico.getDataNascimento());
				System.out.println("ESPECIALIDADE-> " + medico.getEspecialidade().getNome());
				System.out.println("ENDEREÇO -> " + medico.getEndereco());
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n\n");

			}
		}
	}
	
	private void buscarPeloCodigo() {
		Medico find = medicoRepository.findByCodigo(56);
		
		if(find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************MÉDICOS**************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO MÉDICOS DO SISTEMA PELO CÓDIGO: ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("CRM -> " + find.getCrm());
			System.out.println("E-MAIL -> " + find.getEmail());
			System.out.println("DATA NASCIMENTO -> " + find.getDataNascimento());
			System.out.println("ESPECIALIDADE-> " + find.getEspecialidade().getNome());
			System.out.println("ENDEREÇO -> " + find.getEndereco());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");

		}else {
			System.out.println("Não existe médico com esse CÓDIGO ");
		}

	}
	
	
	private void bucarPeloCrm() {
	Medico find = medicoRepository.findByCrm("47383979579");		
		if(find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************MÉDICOS**************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO MÉDICOS DO SISTEMA PELO CRM: ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("CRM -> " + find.getCrm());
			System.out.println("E-MAIL -> " + find.getEmail());
			System.out.println("DATA NASCIMENTO -> " + find.getDataNascimento());
			System.out.println("ESPECIALIDADE-> " + find.getEspecialidade().getNome());
			System.out.println("ENDEREÇO -> " + find.getEndereco());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");

		}else {
			System.out.println("Não existe médico com esse CRM ");
		}

	}
}

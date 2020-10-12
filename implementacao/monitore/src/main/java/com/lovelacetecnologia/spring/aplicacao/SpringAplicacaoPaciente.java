package com.lovelacetecnologia.spring.aplicacao;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Paciente;
import com.lovelacetecnologia.spring.repository.PacienteRepository;

@Component
public class SpringAplicacaoPaciente {

	@Autowired
	private PacienteRepository pacienteRepository;

	public void execute() {
		cadastrarPaciente();
//		alterar();
//		deletar();
//		listarTodos();
//		bucasrPeloCodigo();
//		bucasrPeloCpf();
	}

	private void cadastrarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setNome("José da silva");
		paciente.setCpf("146-787-454-07");
		paciente.setEmail("contato@jose.com");
		paciente.setEndereco("Estrada nova espernça Nº 01 - RJ-Valença");
		paciente.setDataNascimento(LocalDate.of(1972, Month.APRIL, 9));

		Paciente find = pacienteRepository.findByCpf(paciente.getCpf());

		if (find == null) {
			pacienteRepository.save(paciente);

			System.out.println("PACIENTE SALVO COM SUCESSO");
		} else {
			// LANÇAR UMA EXCEÇÃO
			System.err.println("[ERROR] ao salvar paciente pois já existe ...");
		}

	}

	private void alterar() {
		Paciente paciente = new Paciente();
		paciente.setCodigo(1);
		paciente.setNome("Pedro Rocha");
		paciente.setCpf("135-787-89-07");
		paciente.setEmail("contato@jose.com");
		paciente.setEndereco("Estrada nova espernça Nº 01 - RJ-Valença");
		paciente.setDataNascimento(LocalDate.of(1972, Month.APRIL, 9));

		Paciente find = pacienteRepository.findByCodigo(paciente.getCodigo());

		if (find != null) {
			find.setNome(paciente.getNome());
			find.setCpf(paciente.getCpf());
			find.setEmail(paciente.getEmail());
			find.setDataNascimento(paciente.getDataNascimento());
			find.setEndereco(paciente.getEndereco());

			pacienteRepository.save(find);

			System.out.println("PACIENTE SALVO COM SUCESSO");

		} else {
			// LANÇAR UMA EXCEÇÃO
			System.err.println("[ERROR] ao salvar paciente pois já existe ...");
		}

	}

	private void deletar() {
		Paciente find = pacienteRepository.findByCodigo(1);

		if (find != null) {
			pacienteRepository.deleteById(find.getCodigo());

			System.out.println("PACIENTE DELETADO COM SUCESSO");

		} else {
			System.err.println("[ERROR] ao deletar pois o paciente não existe ...");
		}

	}

	private void listarTodos() {
		List<Paciente> pacientes = pacienteRepository.findAll();

		if (pacientes.isEmpty()) {
			System.out.println("Nada a exibir pois não há medicamentos cadastrado");
		} else {
			for (Paciente paciente : pacientes) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("**************************PACIENTES************************");
				System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
				System.out.println("-----------------------------------------------------------");
				System.out.println("LISTAGEM DE TODOS PACIENTES: ");
				System.out.println("");
				System.out.println("NOME -> " + paciente.getNome());
				System.out.println("CPF -> " + paciente.getCpf());
				System.out.println("E-MAIL -> " + paciente.getEmail());
				System.out.println("DATA NASCIMENTO -> " + paciente.getDataNascimento());
				System.out.println("ENDEREÇO -> " + paciente.getEndereco());
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n\n");
			}
		}
	}

	private void bucasrPeloCodigo() {
		Paciente find = pacienteRepository.findByCodigo(3);

		if (find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************PACIENTES************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO PACIENTE PELO CÓDIGO : ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("CPF -> " + find.getCpf());
			System.out.println("E-MAIL -> " + find.getEmail());
			System.out.println("DATA NASCIMENTO -> " + find.getDataNascimento());
			System.out.println("ENDEREÇO -> " + find.getEndereco());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");
		} else {
			System.out.println("Não existe paciente com esse CÓDIGO");
		}
	}

	private void bucasrPeloCpf() {

		Paciente find = pacienteRepository.findByCpf("146-787-454-07");

		if (find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************PACIENTES************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO PACIENTE PELO CPF : ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("CPF -> " + find.getCpf());
			System.out.println("E-MAIL -> " + find.getEmail());
			System.out.println("DATA NASCIMENTO -> " + find.getDataNascimento());
			System.out.println("ENDEREÇO -> " + find.getEndereco());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");
		} else {
			System.out.println("Não existe paciente com esse CPF: ");
		}
	}
}

package com.lovelacetecnologia.spring.aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Especialidade;
import com.lovelacetecnologia.spring.repository.EspecialidadeRepository;

@Component
public class SpringAplicacaoEspecialidade {

	@Autowired
	private EspecialidadeRepository especialidadeRepository;

	public void execute() {
		cadastrarEspecialidade();
		alterar();
		deletar();
		listarTodas();
		buscarPeloCodigo();
		buscarPeloUsername();

	}

	private void cadastrarEspecialidade() {
		Especialidade especialidade = new Especialidade();
		especialidade.setNome("Cirurgia Crânio-Maxilo-Facial");

		Especialidade find = especialidadeRepository.findByNome(especialidade.getNome());

		if (find == null) {
			especialidadeRepository.save(especialidade);

			System.out.println("ESPECIALIDADE SALVA COM SUCESSO");
		} else {
			System.err.println("[ERROR] ao salvar usuário pois já existe ...");
		}

	}

	private  void alterar() {
		Especialidade especialidade = new Especialidade();
		especialidade.setCodigo(1);
		especialidade.setNome("Endoscopia respiratória");

		Especialidade find = especialidadeRepository.findByCodigo(especialidade.getCodigo());

		if (find != null) {
			find.setNome(especialidade.getNome());

			especialidadeRepository.save(find);

			System.out.println("ESPECIALIDADE ALTERADA COM SUCESSO");

		} else {
			System.err.println("[ERROR] ao alterar medicamento pois não existe...");
		}

	}

	private  void deletar() {
		Especialidade find = especialidadeRepository.findByCodigo(1);

		if (find != null) {
			especialidadeRepository.deleteById(find.getCodigo());

			System.out.println("MEDICAMENTO DELETADO COM SUCESSO");
		} else {
			System.err.println("[ERROR] ao deletar pois a especialidade não existe ...");
		}
	}

	private void listarTodas() {
		List<Especialidade> especialidades = especialidadeRepository.findAll();

		if (especialidades.isEmpty()) {
			System.out.println("Nada a exibir pois não há especialidades cadastrada");
		} else {
			for (Especialidade especialidade : especialidades) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("************************ESPECIALIDADES*********************");
				System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
				System.out.println("-----------------------------------------------------------");
				System.out.println("LISTAGEM DE TODAS ESPECIALIDADES : ");
				System.out.println("");
				System.out.println(" NOME ESPECIALIDADE -> " + especialidade.getNome());
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n\n");

			}
		}
	}

	private  void buscarPeloCodigo() {
		Especialidade find = especialidadeRepository.findByCodigo(2);
		if (find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("************************ESPECIALIDADES*********************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO ESPECIALIDADES PELO CÓDIGO : ");
			System.out.println("");
			System.out.println(" NOME ESPECIALIDADE -> " + find.getNome());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");
		} else {
			System.out.println("Não existe especialidade com esse CÓDIGO");
		}
	}

	private void buscarPeloUsername() {
		Especialidade find = especialidadeRepository.findByNome("Pneumologia pediátrica");
		
		if (find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("************************ESPECIALIDADES*********************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO ESPECIALIDADES PELO NOME : ");
			System.out.println("");
			System.out.println(" NOME ESPECIALIDADE -> " + find.getNome());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");
		} else {
			System.out.println("Não existe especialidade com esse NOME");
		}

	}
}

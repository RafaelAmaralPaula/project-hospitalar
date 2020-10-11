package com.lovelacetecnologia.spring.aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Medicamento;
import com.lovelacetecnologia.spring.repository.MedicamentoRepository;

@Component
public class SpringAplicacaoMedicamento {

	@Autowired
	private MedicamentoRepository repository;

	public void execute() {
		cadastrarMedicamento();
		alterarMedicamento();
		deletar();
		listarTodos();
		buscarPeloCodigo();
		buscarPeloCodigoBarras();

	}

	private void cadastrarMedicamento() {
		Medicamento med = new Medicamento();
		med.setCodigoBarras("789567890");
		med.setNome("Neosaldina");
		med.setPeriodidicidade("De 20 a 20 horas durante 3 dias");
		med.setQuantidadeEstoque(1900);
		med.setDosagem("20 gotas");

		Medicamento find = repository.findByCodigoBarras(med.getCodigoBarras());
		if (find == null) {
			repository.save(med);

			System.out.println("MEDICAMENTO SALVO COM SUCESSO");
		} else {
			// LANÇAR UMA EXCEÇÃO
			System.err.println("[ERROR] ao salvar medicamento pois já existe ...");

		}
	}

	private void alterarMedicamento() {
		// CRIANDO MEDICAMENTO
		// REFATORAR
		Medicamento med = new Medicamento();
		med.setCodigo(1);
		med.setCodigoBarras("67878");
		med.setNome("Amoxcilina");
		med.setPeriodidicidade("De 40 em 40 horas durante 1 semana");
		med.setQuantidadeEstoque(1000);
		med.setDosagem("1 comprimido por dia");

		Medicamento findMed = repository.findByCodigo(med.getCodigo());

		if (findMed != null) {
			findMed.setCodigo(med.getCodigo());
			findMed.setNome(med.getNome());
			findMed.setCodigoBarras(med.getCodigoBarras());
			findMed.setPeriodidicidade(med.getPeriodidicidade());
			findMed.setQuantidadeEstoque(med.getQuantidadeEstoque());
			findMed.setDosagem(med.getDosagem());

			repository.save(findMed);

			System.out.println("MEDICAMENTO ALTERADO COM SUCESSO");

		} else {
			System.err.println("[ERROR] ao alterar medicamento pois não existe...");
		}

	}

	private void deletar() {
		Medicamento find = repository.findByCodigo(20);

		if (find != null) {
			repository.deleteById(find.getCodigo());

			System.out.println("MEDICAMENTO DELETADO COM SUCESSO");
		} else {
			System.err.println("[ERROR] ao deletar pois o medicamento não existe ...");
		}
	}

	private void listarTodos() {
		List<Medicamento> medicamentos = repository.findAll();
		if (medicamentos.isEmpty()) {
			System.out.println("Nada a exibir pois não há medicamentos cadastrado");
		} else {
			for (Medicamento medicamento : medicamentos) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("**************************MEDICAMENTOS*********************");
				System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
				System.out.println("-----------------------------------------------------------");
				System.out.println("LISTAGEM DE TODOS MEDICAMENTOS : ");
				System.out.println("");
				System.out.println("CÓDIGO DE BARRAS -> " + medicamento.getCodigoBarras());
				System.out.println("NOME MEDICAMENTO -> " + medicamento.getNome());
				System.out.println("PERIODICIDADE -> " + medicamento.getPeriodidicidade());
				System.out.println("QUANTIDADE ESTOQUE -> " + medicamento.getQuantidadeEstoque());
				System.out.println("DOSAGEM -> " + medicamento.getDosagem());
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n\n");

			}
		}
	}

	private void buscarPeloCodigo() {
		Medicamento findMed = repository.findByCodigo(67);

		if (findMed != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************MEDICAMENTOS*********************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("BUSCANDO MEDICAMENTO PELO ID :");
			System.out.println("");
			System.out.println("CÓDIGO DE BARRAS -> " + findMed.getCodigoBarras());
			System.out.println("NOME MEDICAMENTO -> " + findMed.getNome());
			System.out.println("PERIODICIDADE -> " + findMed.getPeriodidicidade());
			System.out.println("QUANTIDADE ESTOQUE -> " + findMed.getQuantidadeEstoque());
			System.out.println("DOSAGEM -> " + findMed.getDosagem());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n");

		} else {
			System.out.println("Não existe medicamento com esse CÓDIGO");
		}
	}

	private void buscarPeloCodigoBarras() {
		Medicamento buscaMedCodigoBarras = repository.findByCodigoBarras("678");
		if (buscaMedCodigoBarras != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************MEDICAMENTOS*********************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("BUSCANDO MEDICAMENTO POR CÓDIGO DE BARRAS:");
			System.out.println("");
			System.out.println("CÓDIGO DE BARRAS -> " + buscaMedCodigoBarras.getCodigoBarras());
			System.out.println("NOME MEDICAMENTO -> " + buscaMedCodigoBarras.getNome());
			System.out.println("PERIODICIDADE -> " + buscaMedCodigoBarras.getPeriodidicidade());
			System.out.println("QUANTIDADE ESTOQUE -> " + buscaMedCodigoBarras.getQuantidadeEstoque());
			System.out.println("DOSAGEM -> " + buscaMedCodigoBarras.getDosagem());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
		} else {
			System.out.println("Não existe medicamento com esse CÓDIGO DE BARRAS");
		}
	}

}

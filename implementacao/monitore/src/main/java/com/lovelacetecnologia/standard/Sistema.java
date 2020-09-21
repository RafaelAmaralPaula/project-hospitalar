package com.lovelacetecnologia.standard;

import java.util.List;

import com.lovelacetecnologia.model.UsuarioModel;
import com.lovelacetecnologia.repository.UsuarioRepository;
import com.lovelacetecnologia.util.ModuloConexao;

public class Sistema {
	public static void inicializar() {
		System.out.println("Testando Aplicação !!!!");
		System.out.println(ModuloConexao.conector());

		UsuarioRepository repository = new UsuarioRepository();
		
		// BUSCA PELO CÓDIGO
		UsuarioModel usuario2 = new UsuarioModel();
		usuario2.setNome("teste");
		usuario2.setUsername("admin");
		usuario2.setSenha("22142");
		//usuario2.setAtivo(true);
		
		repository.criar(usuario2);
		


		UsuarioModel user = new UsuarioModel();
		user.setNome("teste");
		user.setUsername("admin abc");
		user.setSenha("22142");
		//user.setAtivo(true);
		repository.criar(user);
		System.out.println("Criado ! ");

//		
//		// INSERE NOVO USUÁRIO NA BASE DADOS
//		Usuario user = new Usuario();
//		user.setNome("Rafael");
//		user.setUsername("admin");
//		user.setSenha("89214");
//		user.setAtivo(true);
//		
		

		System.out.println("--------------------------------------------");
		System.out.println("\n\n\n\n");

		// ALTERA OS DADOS DE UM USUÁRIO EXISTENTE

//		Usuario userAlterar = new Usuario();
//		userAlterar.setCodigo(10);
//		userAlterar.setNome("João do silva");
//		userAlterar.setUsername("admin");
//		userAlterar.setSenha("124525");
//		userAlterar.setAtivo(false);
//
//		repository.alterar(userAlterar);
//		System.out.println("Alterado com sucesso !");
//
		System.out.println("\n\n\n\n");

		// DELETA USUÁRIOS DA BASE DE DADOS

//		System.out.println("-------------------------------------");
//		repository.excluir(5);
//		System.out.println("Exluído");
//
//		System.out.println("\n\n\n\n");

		// LISTA TODOS

		System.out.println("-------------------------------------");

		List<UsuarioModel> listUser = repository.listarTodos();
		System.out.println("Listando todos...");

		for (UsuarioModel usuario : listUser) {
			System.out.println("Código -> " + usuario.getCodigo());
			System.out.println("Nome -> " + usuario.getNome());
			System.out.println("Username -> " + usuario.getUsername());
			System.out.println("Senha -> " + usuario.getSenha());
			System.out.println("Status -> " + usuario.isAtivo());
			System.out.println("---------------------------------- ");
		}

		System.out.println("\n\n\n\n");

		// BUSCA PELO CÓDIGO

		UsuarioModel usuarioEncontrado = repository.buscarPeloCodigo(1);
		System.out.println("Listando ...");

		if (usuarioEncontrado.getCodigo() != null) {
			System.out.println("Código -> " + usuarioEncontrado.getCodigo());
			System.out.println("Nome -> " + usuarioEncontrado.getNome());
			System.out.println("Senha -> " + usuarioEncontrado.getSenha());
		} else {

			System.out.println("Usuário não encontrado ou não existe informe código novamente !");
		}
	}
}

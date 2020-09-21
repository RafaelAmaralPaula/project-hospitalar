package com.lovelacetecnologia;

import java.sql.SQLException;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lovelacetecnologia.model.Usuario;
import com.lovelacetecnologia.repository.UsuarioRepository;
import com.lovelacetecnologia.util.ModuloConexao;

@SpringBootApplication
public class MonitoreApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(MonitoreApplication.class, args);
		System.out.println("Testando Aplicação !!!!");
		System.out.println(ModuloConexao.conector());

		UsuarioRepository repository = new UsuarioRepository();

		Usuario user = new Usuario();
		user.setNome("teste");
		user.setUsername("admin");
		user.setSenha("22142");
		user.setAtivo(true);
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

		List<Usuario> listUser = repository.listarTodos();
		System.out.println("Listando todos...");

		for (Usuario usuario : listUser) {
			System.out.println("Código -> " + usuario.getCodigo());
			System.out.println("Nome -> " + usuario.getNome());
			System.out.println("Username -> " + usuario.getUsername());
			System.out.println("Senha -> " + usuario.getSenha());
			System.out.println("Status -> " + usuario.isAtivo());
			System.out.println("---------------------------------- ");
		}

		System.out.println("\n\n\n\n");

		// BUSCA PELO CÓDIGO

		Usuario usuarioEncontrado = repository.buscarPeloCodigo(1);
		System.out.println("Listando ...");

		if (usuarioEncontrado.getCodigo() != null) {
			System.out.println("Código -> " + usuarioEncontrado.getCodigo());
			System.out.println("Nome -> " + usuarioEncontrado.getNome());
			System.out.println("Senha -> " + usuarioEncontrado.getSenha());
		} else {

			System.out.println("Usuário não encontrado ou não existe informe código novamente !");
		}

		// BUSCA PELO CÓDIGO
		Usuario usuario2 = new Usuario();
		usuario2.setNome("teste");
		usuario2.setUsername("admin");
		usuario2.setSenha("22142");
		usuario2.setAtivo(true);
		
		repository.criar(usuario2);
		

	}

}

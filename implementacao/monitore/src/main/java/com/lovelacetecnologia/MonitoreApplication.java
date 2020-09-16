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

		
		// INSERE NOVO USUÁRIO NA BASE DADOS
		Usuario user = new Usuario();
		user.setNome("Gleyson Sampaio");
		user.setSenha("89214");
		
		repository.criar(user);
		System.out.println("Criado ! ");
		
		System.out.println("--------------------------------------------");
		System.out.println("\n\n\n\n");
		

		// ALTERA OS DADOS DE UM USUÁRIO EXISTENTE
		
		Usuario userAlterar = new Usuario();
		userAlterar.setCodigo(2);
		userAlterar.setNome("Normandes Junior");
		userAlterar.setSenha("124525");
		
		repository.alterar(userAlterar);
		System.out.println("Alterado com sucesso !");

		System.out.println("\n\n\n\n");
		
		// DELETA USUÁRIOS DA BASE DE DADOS
		
		System.out.println("-------------------------------------");
		repository.excluir(1);
		System.out.println("Exluído");
		
		System.out.println("\n\n\n\n");
		
		
		//LISTA TODOS
				
		System.out.println("-------------------------------------");
		
		List<Usuario> listUser = repository.listarTodos();
		System.out.println("Listando todos...");
		
		for (Usuario usuario : listUser) {
			System.out.println("Código -> " + usuario.getCodigo());
			System.out.println("Nome -> " + usuario.getNome());
			System.out.println("Senha -> " + usuario.getSenha());
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

	}

}

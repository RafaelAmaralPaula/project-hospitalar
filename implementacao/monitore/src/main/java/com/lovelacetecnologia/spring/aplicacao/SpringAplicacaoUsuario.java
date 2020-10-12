package com.lovelacetecnologia.spring.aplicacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.spring.repository.UsuarioRepository;

@Component
public class SpringAplicacaoUsuario {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public void execute() {
		cadastrarUsuario();
		alterar();
		deletar();
		listarTodos();
		buscarPeloCodigo();
		buscarPeloUsername();
	}

	private void cadastrarUsuario() {
		Usuario usuario = new Usuario();
		usuario.setNome("Gleyson");
		usuario.setUsername("dev");
		usuario.setSenha("32155");

		Usuario find = usuarioRepository.findByUsername(usuario.getUsername());

		if (find == null) {
			usuarioRepository.save(usuario);
			
			System.out.println("USUÁRIO SALVO COM SUCESSO");
		} else {
			// LANÇAR EXCEÇÃO
			System.err.println("[ERROR] ao salvar usuário pois já existe ...");
		}

	}

	private void alterar() {
		Usuario usuario = new Usuario();
		usuario.setCodigo(1);
		usuario.setNome("Rafael");
		usuario.setUsername("admin");
		usuario.setSenha("123");
		usuario.setAtivo(false);

		Usuario find = usuarioRepository.findByCodigo(usuario.getCodigo());

		if (find != null) {
			find.setNome(usuario.getNome());
			find.setUsername(usuario.getUsername());
			find.setSenha(usuario.getSenha());
			find.setAtivo(usuario.isAtivo());

			usuarioRepository.save(find);

			System.out.println("USUARIO ALTERADO COM SUCESSO");
		} else {
			System.err.println("[ERROR] ao alterar usuário pois não existe...");
		}

	}

	private void deletar() {
		Usuario find = usuarioRepository.findByCodigo(22);

		if (find != null) {
			usuarioRepository.deleteById(find.getCodigo());
			System.out.println("USUÁRIO DELETADO COM SUCESSO");
		} else {
			System.err.println("[ERROR] ao deletar pois o usuário não existe ...");
		}
	}

	public void listarTodos() {
		List<Usuario> usuarios = usuarioRepository.findAll();

		if (usuarios.isEmpty()) {
			System.out.println("Nada a exibir pois não há usuários cadastrado");
		} else {
			for (Usuario usuario : usuarios) {
				System.out.println("-----------------------------------------------------------");
				System.out.println("**************************USUÁRIO**************************");
				System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
				System.out.println("-----------------------------------------------------------");
				System.out.println("LISTAGEM DE TODOS USUÁRIOS DO SISTEMA : ");
				System.out.println("");
				System.out.println("NOME -> " + usuario.getNome());
				System.out.println("USERNAME -> " + usuario.getUsername());
				System.out.println("STATUS -> " + usuario.isAtivo());
				System.out.println("SENHA -> " + usuario.getSenha());
				System.out.println("-----------------------------------------------------------");
				System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
				System.out.println("-----------------------------------------------------------");
				System.out.println("\n\n\n\n");

			}
		}
	}
	public void buscarPeloCodigo() {
		Usuario find = usuarioRepository.findByCodigo(2);
		
		if(find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************USUÁRIO**************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO USUÁRIOS DO SISTEMA PELO CÓDIGO : ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("USERNAME -> " + find.getUsername());
			System.out.println("STATUS -> " + find.isAtivo());
			System.out.println("SENHA -> " + find.getSenha());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");

			
		}else {
			System.out.println("Não existe usuário com esse CÓDIGO");
		}
	}
	
	public void buscarPeloUsername() {
		Usuario find = usuarioRepository.findByUsername("admin"); 
		
		if(find != null) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("**************************USUÁRIO**************************");
			System.out.println("MONITORE APPLICATION - Sistema Gerenciamento de hospitais");
			System.out.println("-----------------------------------------------------------");
			System.out.println("FILTRANDO USUÁRIOS DO SISTEMA PELO USERNAME: ");
			System.out.println("");
			System.out.println("NOME -> " + find.getNome());
			System.out.println("USERNAME -> " + find.getUsername());
			System.out.println("STATUS -> " + find.isAtivo());
			System.out.println("SENHA -> " + find.getSenha());
			System.out.println("-----------------------------------------------------------");
			System.out.println(" 		BY - DEV Gleyson Sampaio and Rafael Amaral");
			System.out.println("-----------------------------------------------------------");
			System.out.println("\n\n\n\n");

			
		}else {
			System.out.println("Não existe usuário com esse USERNAME ");
		}
	}
}

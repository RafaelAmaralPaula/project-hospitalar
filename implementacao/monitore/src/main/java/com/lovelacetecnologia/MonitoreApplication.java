package com.lovelacetecnologia;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.lovelacetecnologia.spring.entity.Usuario;
import com.lovelacetecnologia.standard.TrabalhandoBancoDadosSpring;

@SpringBootApplication
public class MonitoreApplication {

	public static void main(String[] args){
		ConfigurableApplicationContext run = SpringApplication.run(MonitoreApplication.class, args);
	
		
		TrabalhandoBancoDadosSpring trabalhandoBancoDadosSpring = (TrabalhandoBancoDadosSpring)
						run.getBean("trabalhandoBancoDadosSpring");
		
		
		// INSERIR USUARIO
		//trabalhandoBancoDadosSpring.salvar(new Usuario("Rafael" , "admin" , "123"));
		
		System.out.println("\n\n");
		
		// ALTERAR USUARIO
		//trabalhandoBancoDadosSpring.alterar(new Usuario(1, "Normandes", "dev", "123"));
		
		System.out.println("\n\n");
		
		// LISTAR TODOS USUARIOS
		List<Usuario> listUsuarios = trabalhandoBancoDadosSpring.usuarios();
		
		for (Usuario usuario : listUsuarios) {
			System.out.println("Usuario ID -> " + usuario.getCodigo());
			System.out.println("Nome -> " + usuario.getNome());
			System.out.println("Username -> " + usuario.getUsername() );
			System.out.println("Password -> " + usuario.getSenha() );
			System.out.println("Status -> " + usuario.isAtivo());
			
			System.out.println("\n\n");
			
		}
		
		//DELETAR		
		trabalhandoBancoDadosSpring.deletar(2);
		
		// BUSCAR PELO CODIGO 
		Usuario user = trabalhandoBancoDadosSpring.buscarPeloCodigo(1);
		System.out.println("Nome -> " + user.getNome());
		System.out.println("Username -> " + user.getUsername());
		System.out.println("Password -> " + user.getSenha());
		System.out.println("Ativo -> " + user.isAtivo());
		
		System.out.println("\n\n");
		
	}
	
//	@Bean
//	public ClasseExterna newClassExterna() {
//		return new ClasseExterna();
//	}

}

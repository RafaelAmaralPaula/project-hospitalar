package com.lovelacetecnologia;


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
		
		trabalhandoBancoDadosSpring.salvar(new Usuario("Gleyson " , "admin" , "123"));
	}
	
//	@Bean
//	public ClasseExterna newClassExterna() {
//		return new ClasseExterna();
//	}

}

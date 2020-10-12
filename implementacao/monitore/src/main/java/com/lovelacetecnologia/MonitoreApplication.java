package com.lovelacetecnologia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lovelacetecnologia.spring.aplicacao.SpringAplicacaoEspecialidade;
import com.lovelacetecnologia.spring.aplicacao.SpringAplicacaoMedicamento;
import com.lovelacetecnologia.spring.aplicacao.SpringAplicacaoMedico;
import com.lovelacetecnologia.spring.aplicacao.SpringAplicacaoPaciente;
import com.lovelacetecnologia.spring.aplicacao.SpringAplicacaoUsuario;

@SpringBootApplication
public class MonitoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoreApplication.class, args);

	}

	@Bean
	public CommandLineRunner run(SpringAplicacaoMedicamento beanMedicamento, SpringAplicacaoUsuario beanUsuario,
			SpringAplicacaoEspecialidade beanEspecialidade, SpringAplicacaoPaciente beanPaciente,
			SpringAplicacaoMedico beanMedico) {
		return args -> {
			// beanMedicamento.execute();
			// beanUsuario.execute();
			//beanEspecialidade.execute();
			//beanPaciente.execute();
			//beanMedico.execute();
		};
	}

}

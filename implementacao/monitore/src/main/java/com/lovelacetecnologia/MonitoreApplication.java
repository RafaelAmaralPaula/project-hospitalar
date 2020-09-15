package com.lovelacetecnologia;

import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lovelacetecnologia.util.ConexaoUtil;

@SpringBootApplication
public class MonitoreApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		SpringApplication.run(MonitoreApplication.class, args);
		System.out.println("Testando Aplicação !!!!");
		System.out.println(ConexaoUtil.getInstance().getConnection());
	}

}

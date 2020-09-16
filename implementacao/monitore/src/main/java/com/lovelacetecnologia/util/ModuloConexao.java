package com.lovelacetecnologia.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	private static Connection conexao;

	// metodo responsavel por estabelecer conexão com o banco de dados
	public static Connection conector() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitore",
					  "root", "javalove123");
		} catch (Exception e) {
			return null;// aqui vou melhorar ainda
		}
		return conexao;

	}

}

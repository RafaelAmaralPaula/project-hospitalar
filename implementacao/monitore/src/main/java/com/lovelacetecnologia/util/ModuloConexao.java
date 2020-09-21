package com.lovelacetecnologia.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ModuloConexao {

	private static Connection conexao;
	
	private static void conectar() {
		try {
			if(conexao==null || conexao.isClosed()) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/monitore",
						  "root", "javalove123");
			}else {
				System.out.println("Conexao já esta aberta");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// metodo responsavel por estabelecer conexão com o banco de dados
	public static Connection conector() {
		conectar();
		return conexao;
	}

}

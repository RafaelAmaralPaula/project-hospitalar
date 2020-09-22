package com.lovelacetecnologia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovelacetecnologia.model.UsuarioModel;
import com.lovelacetecnologia.util.ModuloConexao;

public class UsuarioRepository {

	private Connection connection;

	public UsuarioRepository() {
		this.connection = ModuloConexao.conector();
	}

	public void criar(UsuarioModel usuario) {

		try {
			
			boolean usernameExiste = existeUsername(usuario);
			
			if(usernameExiste) {
				System.out.println("Usuário já cadastrado com esse username tente outro");
			}else {
				String sql = ("INSERT INTO usuario(nome,username,senha,ativo)VALUES(?,?,?,?)");
		
                PreparedStatement statement = connection.prepareStatement(sql);               
                                                                                              
                statement.setString(1, usuario.getNome());                                    
			    statement.setString(2, usuario.getUsername());                                
                statement.setString(3, usuario.getSenha());                                   
			    statement.setBoolean(4, usuario.isAtivo());                                   
			                                                                                  
			    statement.execute();                                                          
			                                                                                  

				}                                                                                 

		} catch (SQLException u) {
			throw new RuntimeException();

		}
	}

	public void alterar(UsuarioModel usuario) {

		try {

			String sql = "UPDATE usuario SET nome=?, username=?,senha=?, ativo=?  WHERE codigo=(?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getUsername());
			statement.setString(3, usuario.getSenha());
			statement.setBoolean(4, usuario.isAtivo());
			statement.setInt(5, usuario.getCodigo());

			statement.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException();

		}

	}

	public void excluir(int codigoUsuario) {

		try {

			String sql = "DELETE FROM usuario WHERE codigo = (?)";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, codigoUsuario);

			statement.execute();

		} catch (Exception e) {
			throw new RuntimeException();

		}

	}

	public List<UsuarioModel> listarTodos() {

		List<UsuarioModel> list = new ArrayList<>();

		try {

			String sql = "SELECT * FROM usuario";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				UsuarioModel usuario = new UsuarioModel();

				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setAtivo(rs.getBoolean("ativo"));

				list.add(usuario);

			}

		} catch (Exception e) {
			throw new RuntimeException();
		}

		return list;
	}

	public boolean existeUsername(UsuarioModel usuario) {

		boolean existe = false;

		try {

			String sql = "SELECT username FROM usuario WHERE username = ?";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setString(1, usuario.getUsername());

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				existe=true;
				break;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return existe;
	}

	public UsuarioModel buscarPeloCodigo(int codigoUsuario) {

		UsuarioModel usuario = new UsuarioModel();

		try {
			Connection connection = ModuloConexao.conector();

			String sql = "SELECT * FROM usuario WHERE codigo = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setInt(1, codigoUsuario);

			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("nome"));
				usuario.setUsername(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
			}

		} catch (Exception e) {
			throw new RuntimeException();
		}

		return usuario;

	}

}

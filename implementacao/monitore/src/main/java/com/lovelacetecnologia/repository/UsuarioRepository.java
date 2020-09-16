package com.lovelacetecnologia.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lovelacetecnologia.model.Usuario;
import com.lovelacetecnologia.util.ModuloConexao;

public class UsuarioRepository {


	public void criar(Usuario usuario) {

		try {
			
			Connection connection = ModuloConexao.conector();

			String sql = ("INSERT INTO usuario(username,senha)VALUES(?,?)");

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());

			statement.execute();
			connection.close();

		} catch (SQLException u) {
			throw new RuntimeException();
		}

	}

	public void alterar(Usuario usuario) {

		try {
			
			Connection connection = ModuloConexao.conector();

			String sql = "UPDATE usuario SET username = ? , senha = ? WHERE codigo = ?";

			PreparedStatement statement = connection.prepareStatement(sql);

			statement.setString(1, usuario.getNome());
			statement.setString(2, usuario.getSenha());
			statement.setInt(3, usuario.getCodigo());

			statement.execute();
			connection.close();

		} catch (Exception e) {
			throw new RuntimeException();

		}

	}

	public void excluir(int codigoUsuario) {

		try {
			
			Connection connection = ModuloConexao.conector();

			String sql = "DELETE FROM usuario WHERE codigo = (?)";

			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, codigoUsuario);
			
			statement.execute();
			connection.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException();

		}

	}

	public List<Usuario> listarTodos() {
		
		
		List<Usuario> list = new ArrayList<>();
		
		try {
			Connection connection = ModuloConexao.conector();
			
			String sql = "SELECT * FROM usuario";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			ResultSet rs = statement.executeQuery();
			
			while(rs.next()) {
				
				Usuario usuario = new Usuario();
				
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
				
				list.add(usuario);
				
			}
			
			
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		return list;
	}

	public Usuario buscarPeloCodigo(int codigoUsuario) {
		
		Usuario usuario = new Usuario();
		
		try {
			Connection connection = ModuloConexao.conector();
			
			String sql = "SELECT * FROM usuario WHERE codigo = ?";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			
			statement.setInt(1, codigoUsuario);
			
			ResultSet rs = statement.executeQuery();
					
			if(rs.next()) {
				usuario.setCodigo(rs.getInt("codigo"));
				usuario.setNome(rs.getString("username"));
				usuario.setSenha(rs.getString("senha"));
			}
			
			connection.close();
			
		}catch (Exception e) {
			throw new RuntimeException();
		}
		
		return usuario;
		
	}

}

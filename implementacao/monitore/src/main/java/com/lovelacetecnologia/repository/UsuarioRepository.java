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

	private Connection connection;

	public UsuarioRepository() {
		this.connection = ModuloConexao.conector();
	}

	public void criar(Usuario usuario) {

		try {
			
			boolean usernameExiste = listDeUsername(usuario);
			
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

	public void alterar(Usuario usuario) {

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

	public List<Usuario> listarTodos() {

		List<Usuario> list = new ArrayList<>();

		try {

			String sql = "SELECT * FROM usuario";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {

				Usuario usuario = new Usuario();

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

	public boolean listDeUsername(Usuario usuario) {

		boolean existe = false;

		try {

			String sql = "SELECT username FROM usuario";

			PreparedStatement statement = connection.prepareStatement(sql);

			ResultSet rs = statement.executeQuery();

			while (rs.next()) {
				
				Usuario user = new Usuario();
				
				user.setUsername(rs.getString("username"));
				
				if (user.getUsername().equals(usuario.getUsername())) {
					existe = true;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return existe;
	}

	public Usuario buscarPeloCodigo(int codigoUsuario) {

		Usuario usuario = new Usuario();

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

package com.lovelacetecnologia.model;

public class UsuarioModel extends PessoaModel {

	private String username;
	private String senha;
	private boolean ativo;
	private boolean bloqueado;
	
	public UsuarioModel() {
		ativo=true;
		bloqueado=true;
	}
	
	public boolean isBloqueado() {
		return bloqueado;
	}
	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}

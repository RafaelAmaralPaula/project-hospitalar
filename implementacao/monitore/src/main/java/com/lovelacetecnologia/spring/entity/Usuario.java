package com.lovelacetecnologia.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codigo;

	private String nome;

	private String username;

	private String senha;

	private boolean ativo;

	public Usuario() {
		ativo = true;
	}

	public Usuario(String nome, String username, String senha) {
		this();
		this.nome = nome;
		this.username = username;
		this.senha = senha;
	}
	
	public Usuario(Integer codigo , String nome, String username, String senha) {
		this();
		this.codigo = codigo;
		this.nome = nome;
		this.username = username;
		this.senha = senha;
		
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

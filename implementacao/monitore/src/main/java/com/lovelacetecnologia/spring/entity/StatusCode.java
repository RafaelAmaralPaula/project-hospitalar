package com.lovelacetecnologia.spring.entity;


public enum StatusCode {
	
	RESOURCE_CREATE("Resource Created" , 406);
	
	private String nome;
	
	private Integer status;
	
	private StatusCode(String nome , Integer status) {
		this.nome = nome;
		this.status = status;
	}
	
	public String getNome() {
		return nome;
	}
	
	public Integer getStatus() {
		return status;
	}
}

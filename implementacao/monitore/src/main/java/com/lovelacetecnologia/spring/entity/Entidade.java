package com.lovelacetecnologia.spring.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Entidade {
	@Id
	private Integer id;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}

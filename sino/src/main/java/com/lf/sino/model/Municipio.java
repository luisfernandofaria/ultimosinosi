package com.lf.sino.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "MUNICIPIOS")
public class Municipio extends AbstractEntity<Integer> {

	private Integer codigo;
	private String nome;

	// Por que com enum não funciona?
	// e qual a vantagem de usar enum?
	// @Enumerated(EnumType.STRING)
	private String uf;

	public Municipio() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

}

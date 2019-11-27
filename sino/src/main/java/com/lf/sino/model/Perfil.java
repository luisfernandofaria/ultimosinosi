package com.lf.sino.model;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

@SuppressWarnings("serial")
@Entity
@Table(name = "PERFIS")
public class Perfil extends AbstractEntity<Integer> implements GrantedAuthority {

	private String tipoPerfil;

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	@Override
	public String getAuthority() {
		return tipoPerfil;
	}

	@Override
	public String toString() {
		return "Perfil [tipoPerfil=" + tipoPerfil + "]";
	}

}

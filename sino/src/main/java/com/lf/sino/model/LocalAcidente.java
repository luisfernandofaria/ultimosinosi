package com.lf.sino.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCAISDOSACIDENTES")
public class LocalAcidente extends AbstractEntity<Integer> {

	@Column(nullable = true, length = 60)
	@Pattern(regexp = "^(\\+|-)?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$")
	private String latitude;

	@Pattern(regexp = "^(\\\\+|-)?(?:180(?:(?:\\\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\\\.[0-9]{1,6})?))$")
	private String longitude;

	@Column(nullable = true, length = 60)
	@NotBlank(message = "Endereço não pode ficar vazio!")
	@Size(min = 5, max = 60)
	private String endereco;

	@ManyToOne(cascade = CascadeType.DETACH)
	private Municipio municipio;

	@Column(nullable = true, length = 8)
	@Size(min = 0, max = 8)
	@Pattern(regexp = "^(([0-9]{2}\\.[0-9]{3}-[0-9]{3})|([0-9]{2}[0-9]{3}-[0-9]{3})|([0-9]{8}))$")
	private String cep;

	public LocalAcidente() {
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "LocalAcidente [latitude=" + latitude + ", longitude=" + longitude + ", endereco=" + endereco
				+ ",  +  municipio=" + municipio + ", cep=" + cep + "]";
	}

}

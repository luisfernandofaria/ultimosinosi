package com.lf.sino.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "LOCAISDOSACIDENTES")
public class LocalAcidente extends AbstractEntity<Integer> {

	private String latitude;
	private String longitude;
	private String endereco;

	@OneToMany(mappedBy="")
	@JoinColumn(name = "localAcidente")
	private List<Denuncia> denuncias;

	@ManyToMany
	@JoinTable(name = "LOCAIS_MUNICIPIOS", joinColumns = {
			@JoinColumn(name = "local_acidente_id") }, inverseJoinColumns = {
					@JoinColumn(name = "municipio_acidente_id") })
	private List<Municipio> municipios;

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

	public List<Municipio> getMunicipios() {
		return municipios;
	}

	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Denuncia> getDenuncias() {
		return denuncias;
	}

	public void setDenuncias(List<Denuncia> denuncias) {
		this.denuncias = denuncias;
	}

	@Override
	public String toString() {
		return "LocalAcidente [latitude=" + latitude + ", longitude=" + longitude + ", endereco=" + endereco
				+ ", denuncias=" + denuncias + ", municipios=" + municipios + ", cep=" + cep + "]";
	}



}

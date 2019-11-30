package com.lf.sino.controller.dto;

public class FotoDTO {

	private String nomeArquivo;
	private String contentType;

	public FotoDTO(String nomeArquivo, String contentType) {
		this.nomeArquivo = nomeArquivo;
		this.contentType = contentType;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
}

package com.lf.sino.model;

public enum EnumCategoria {

	VEGETACAO("Vegetação: Desmatamento, corte, supressão"),
	FAUNA("Animais silvestres em cativeiro, comércio irregular, caça"), AR("Fumaça, poeira, fuligem, odor industrial"),
	SOLO("Descarte de redíduos sólidos e liquídos industriais, descarte irregular de entulhos"),
	FOGO("Queima da palha da cana, limpeza de pasto com fogo, queimadas"), AGUA("Descarte de resíduos sólidos na água"),
	OUTROS("outros");

	private final String descricao;

	EnumCategoria(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}

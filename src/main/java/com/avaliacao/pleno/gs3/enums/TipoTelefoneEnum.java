package com.avaliacao.pleno.gs3.enums;

import java.util.Objects;

public enum TipoTelefoneEnum {
	
	RESIDENCIAL(1,"Residencial"),
	COMERCIAL(2,"Comercial"),
	CELULAR(3,"Celular");
	
	private int cod;
	private String descricao;
	
	private TipoTelefoneEnum(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static TipoTelefoneEnum toEnum(Integer cod) {
		
		if(Objects.isNull(cod))
			return null;
		
		for(TipoTelefoneEnum x : TipoTelefoneEnum.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	

}

package com.avaliacao.pleno.gs3.enums;

import java.util.Objects;

public enum Perfil {
	
	ADMIN(1,"ROLE_ADMIN"),
	COMUM(2,"ROLE_COMUM");
	
	private int cod;
	private String descricao;
	
	private Perfil(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(Objects.isNull(cod))
			return null;
		
		for(Perfil x : Perfil.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
	
	

}

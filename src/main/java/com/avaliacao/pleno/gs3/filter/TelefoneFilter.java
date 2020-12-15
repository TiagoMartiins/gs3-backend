package com.avaliacao.pleno.gs3.filter;

import javax.validation.constraints.NotEmpty;

public class TelefoneFilter {
	
	@NotEmpty(message = "Tipo de Telefone Obrigatório")
	private int tipoTelefone;
	
	@NotEmpty(message = "Telefone Obrigatório")
	private Integer numeroTelefone;
	
	@NotEmpty(message = "DDD Obrigatório")
	private int ddd;

	public TelefoneFilter() {
		super();
	}

	public TelefoneFilter(int tipoTelefone, int numeroTelefone, int ddd) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.numeroTelefone = numeroTelefone;
		this.ddd = ddd;
	}

	public int getTipoTelefone() {
		return tipoTelefone;
	}

	public void setTipoTelefone(int tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public Integer getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(Integer numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	
	
	
	

}

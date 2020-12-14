package com.avaliacao.pleno.gs3.dto;

import com.avaliacao.pleno.gs3.enums.TipoTelefoneEnum;

public class TelefoneDTO {
	
	private int tipoTelefone;
	
	private int numeroTelefone;
	
	private int ddd;
	

	public TelefoneDTO() {
		super();
	}

	public TelefoneDTO(int tipoTelefone, int numeroTelefone, int ddd) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.numeroTelefone = numeroTelefone;
		this.ddd = ddd;
	}

	public TipoTelefoneEnum getTipoTelefone() {
		return TipoTelefoneEnum.toEnum(this.tipoTelefone);
	}

	public void setTipoTelefone(int tipoTelefone) {
		this.tipoTelefone = tipoTelefone;
	}

	public int getNumeroTelefone() {
		return numeroTelefone;
	}

	public void setNumeroTelefone(int numeroTelefone) {
		this.numeroTelefone = numeroTelefone;
	}

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}
	
	
	

}

package com.avaliacao.pleno.gs3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



@Entity
public class TelefoneEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTelefone;
	
	private int tipoTelefone;
	
	@Column
	private int numeroTelefone;
	
	@Column
	private int ddd;
	
	

	public TelefoneEntity() {
		super();
	}

	public TelefoneEntity(int tipoTelefone, int numeroTelefone, int ddd) {
		super();
		this.tipoTelefone = tipoTelefone;
		this.numeroTelefone = numeroTelefone;
		this.ddd = ddd;
	}

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public int getTipoTelefone() {
		return tipoTelefone;
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

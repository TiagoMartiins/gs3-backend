package com.avaliacao.pleno.gs3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class EnderecoEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idEndereco;
	
	@Column
	private int cep;
	
	@Column
	private String logradouro;
	
	@Column
	private String bairro;
	
	@Column
	private String cidade;
	
	@Column
	private String uf;
	
	@Column
	private String complemento;
	
	
	public EnderecoEntity() {
		super();
	}
	
	public EnderecoEntity(int cep, String logradouro, String bairro, String cidade, String uf,
			String complemento) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
	}
	
	public int getIdEndereco() {
		return idEndereco;
	}
	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}
	public int getCep() {
		return cep;
	}
	public void setCep(int cep) {
		this.cep = cep;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	
	

}

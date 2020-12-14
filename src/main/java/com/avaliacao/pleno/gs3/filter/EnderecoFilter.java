package com.avaliacao.pleno.gs3.filter;

import javax.validation.constraints.NotEmpty;

public class EnderecoFilter {
	
	@NotEmpty(message = "Cep Obrigatório")
	private int cep;
	
	@NotEmpty(message = "Logradouro Obrigatório")
	private String logradouro;
	
	@NotEmpty(message = "Bairro Obrigatório")
	private String bairro;
	
	@NotEmpty(message = "Cidade Obrigatório")
	private String cidade;

	@NotEmpty(message = "UF Obrigatório")
	private String uf;

	private String complemento;
	

	public EnderecoFilter() {
		super();
	}

	public EnderecoFilter(int cep, String logradouro, String bairro, String cidade, String uf, String complemento) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
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

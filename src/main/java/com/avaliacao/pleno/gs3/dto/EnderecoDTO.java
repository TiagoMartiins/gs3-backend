package com.avaliacao.pleno.gs3.dto;

public class EnderecoDTO {
	
	private Integer cep;
	private String logradouro;
	private String bairro;
	private String cidade;
	private String uf;
	private String complemento;
	
	public EnderecoDTO() {
		super();
	}

	public EnderecoDTO(Integer cep, String logradouro, String bairro, String cidade, String uf, String complemento) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.complemento = complemento;
	}
	
	public Integer getCep() {
		return cep;
	}
	public void setCep(Integer cep) {
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

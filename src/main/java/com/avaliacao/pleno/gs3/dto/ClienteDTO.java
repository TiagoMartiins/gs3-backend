package com.avaliacao.pleno.gs3.dto;

import java.util.List;

public class ClienteDTO {
	
	private int idCliente;
	private String nome;
	private String cpf;
	private EnderecoDTO endereco;
	private List<String> emails;
	private List<TelefoneDTO> telefones;
	
	
	public ClienteDTO() {
		super();
	}

	public ClienteDTO(String nome, String cpf, EnderecoDTO endereco, List<String> emails, List<TelefoneDTO> telefones) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.setEndereco(endereco);
		this.emails = emails;
		this.telefones = telefones;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<TelefoneDTO> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<TelefoneDTO> telefones) {
		this.telefones = telefones;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
	
	
	
	

}

package com.avaliacao.pleno.gs3.filter;

import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ClienteFilter {
	
	private int idCliente;
	
	@NotEmpty(message = "Nome Obrigatório")
	@Size(min = 3,max = 100)
	private String nome;
	
	@NotEmpty(message = "Cpf Obrigatório")
	private String cpf;
	
	@NotNull
	private EnderecoFilter endereco;
	
	@NotNull
	private List<TelefoneFilter> telefones;
	
	@NotNull
	private Set<String> emails;
	
	public ClienteFilter() {
		super();
	}

	public ClienteFilter(String nome, String cpf, EnderecoFilter endereco, List<TelefoneFilter> telefones,
			Set<String> emails) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
		this.emails = emails;
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

	public EnderecoFilter getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoFilter endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneFilter> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneFilter> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	
	
	

}

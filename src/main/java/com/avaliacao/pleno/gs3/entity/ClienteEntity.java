package com.avaliacao.pleno.gs3.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ClienteEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;
	
	@Column(name = "nomeCliente")
	private String nome;
	
	@Column
	private String cpf;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idCliente_fk")
	private EnderecoEntity endereco;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idCliente_fk")
	private List<TelefoneEntity> telefones;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="email", joinColumns = @JoinColumn(name = "idCliente_fk"))
	@Column(name = "email")
	private Set<String> emails;
	

	public ClienteEntity() {
		super();
	}

	public ClienteEntity(String nome, String cpf, EnderecoEntity endereco,
			List<TelefoneEntity> telefones, Set<String> emails) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefones = telefones;
		this.emails = emails;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public List<TelefoneEntity> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<TelefoneEntity> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
	}
	
	
	

}

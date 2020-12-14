package com.avaliacao.pleno.gs3.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.avaliacao.pleno.gs3.enums.Perfil;

@Entity
public class UsuarioEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idUsuario;
	
	@Column
	private String nomeUsuario;
	
	@Column
	private String senhaUsuario;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="perfil", joinColumns = @JoinColumn(name = "idUsuario_fk"))
	@Column(name = "perfil")
	private Set<Integer> perfis = new HashSet<>();
	
	
	public UsuarioEntity() {
		addPerfil(Perfil.COMUM);
	}

	public UsuarioEntity(String nomeUsuario, String senhaUsuario,Set<Integer> perfis) {
		super();
		this.perfis = perfis;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	
	

}

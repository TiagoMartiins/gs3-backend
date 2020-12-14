package com.avaliacao.pleno.gs3.dto;

import java.io.Serializable;

public class UsuarioDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String usuario;
	private String senha;

	public UsuarioDTO() {
		super();
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

}
package com.avaliacao.pleno.gs3.filter;

public class UsuarioFilter {
	
	private String usuario;
	private String senha;
	
	
	public UsuarioFilter() {
		super();
	}

	public UsuarioFilter(String usuario, String senha) {
		super();
		this.usuario = usuario;
		this.senha = senha;
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

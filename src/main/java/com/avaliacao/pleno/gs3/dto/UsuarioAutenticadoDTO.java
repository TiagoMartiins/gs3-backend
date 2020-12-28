package com.avaliacao.pleno.gs3.dto;

public class UsuarioAutenticadoDTO {
	
	private String username;
	private boolean isAdmin;
	
	
	public UsuarioAutenticadoDTO() {
		super();
	}

	public UsuarioAutenticadoDTO(String username, boolean isAdmin) {
		super();
		this.username = username;
		this.isAdmin = isAdmin;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	
	
	
	

}

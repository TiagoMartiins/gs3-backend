package com.avaliacao.pleno.gs3.exception;

public class NegocioException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public NegocioException(String message){
		super(message);
	}
	
	public NegocioException(String message, Object ... parametros) {
		super(String.format(message, parametros));
	}

}

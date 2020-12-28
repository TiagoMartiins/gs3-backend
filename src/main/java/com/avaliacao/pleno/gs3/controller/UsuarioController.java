package com.avaliacao.pleno.gs3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.web.servlet.headers.HeadersSecurityMarker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avaliacao.pleno.gs3.dto.UsuarioAutenticadoDTO;
import com.avaliacao.pleno.gs3.exception.NegocioException;
import com.avaliacao.pleno.gs3.security.UserSS;
import com.avaliacao.pleno.gs3.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UsuarioController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(path = "/test",method = RequestMethod.GET)
	public ResponseEntity<UsuarioAutenticadoDTO> getUserCompleted() throws NegocioException {
		
		UserSS usuario = service.getUserAuthenticated();
		if(usuario != null)
		{
			
			UsuarioAutenticadoDTO userAuthenticated;
			if(service.isAdmin(usuario))
				userAuthenticated = new UsuarioAutenticadoDTO(usuario.getUsername(), true);
			else
				userAuthenticated = new UsuarioAutenticadoDTO(usuario.getUsername(), false);
			return new ResponseEntity<UsuarioAutenticadoDTO>(userAuthenticated,HttpStatus.OK);
			
		}
		
		return new ResponseEntity<UsuarioAutenticadoDTO>(HttpStatus.NOT_FOUND);
	}
	

}

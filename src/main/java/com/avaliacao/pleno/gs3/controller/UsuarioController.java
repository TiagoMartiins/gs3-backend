package com.avaliacao.pleno.gs3.controller;

import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avaliacao.pleno.gs3.dto.ClienteDTO;
import com.avaliacao.pleno.gs3.exception.NegocioException;
import com.avaliacao.pleno.gs3.security.UserSS;
import com.avaliacao.pleno.gs3.service.UserService;

@Controller
@RequestMapping(path = "/user")
public class UsuarioController {
	
	@Autowired
	private UserService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<String> getUser(@RequestParam("token") String token) throws NegocioException {
		
		String usuario = service.getUser(token);
		if(usuario != null)
		return new ResponseEntity<String>(usuario,HttpStatus.OK);
		
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
	}

}

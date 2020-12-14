package com.avaliacao.pleno.gs3.controller;

import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.avaliacao.pleno.gs3.dto.ClienteDTO;
import com.avaliacao.pleno.gs3.entity.ClienteEntity;
import com.avaliacao.pleno.gs3.exception.NegocioException;
import com.avaliacao.pleno.gs3.filter.ClienteFilter;
import com.avaliacao.pleno.gs3.service.ClienteService;

@Controller
@RequestMapping(path = "/cliente")
@Validated
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ClienteEntity>> getClientes() {
		  List<ClienteEntity> clts = service.getAll();
		  
		  if(Objects.nonNull(clts))
			  return new ResponseEntity<List<ClienteEntity>>(clts,HttpStatus.OK);
		  else
			  return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteDTO> createOrUpdate(@RequestBody @Valid ClienteFilter clt) {
		
		ClienteDTO cliente = service.createOrUpdate(clt);
		
		if(Objects.nonNull(cliente))
			return new ResponseEntity<ClienteDTO>(cliente,HttpStatus.OK);
		else
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

	}
	
	@RequestMapping(path = "/get",method = RequestMethod.GET)
	public ResponseEntity<ClienteDTO> getCliente(@RequestParam(name = "id") Integer id) throws NegocioException {
		return new ResponseEntity<ClienteDTO>(service.getClienteById(id),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@RequestParam(name = "id") Integer id) throws NegocioException {
		
		return new ResponseEntity<String>(service.delete(id),HttpStatus.OK);
	}

}

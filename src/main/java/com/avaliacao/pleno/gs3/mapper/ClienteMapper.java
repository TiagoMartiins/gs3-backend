package com.avaliacao.pleno.gs3.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.avaliacao.pleno.gs3.dto.ClienteDTO;
import com.avaliacao.pleno.gs3.entity.ClienteEntity;
import com.avaliacao.pleno.gs3.filter.ClienteFilter;

@Mapper(componentModel = "spring")
public interface ClienteMapper {
	
	@Mapping(ignore = true, target = "telefones")
	@Mapping(ignore= true, target = "endereco.cep")
	ClienteEntity clienteFilterToClienteEntity(ClienteFilter cliente);
	
	ClienteDTO clienteEntityToClienteDTO(ClienteEntity cliente); 

}

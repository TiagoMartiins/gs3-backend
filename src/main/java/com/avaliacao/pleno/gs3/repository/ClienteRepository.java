package com.avaliacao.pleno.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.pleno.gs3.entity.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Integer>{
	
	Optional<ClienteEntity> findNomeAndCpfByIdCliente(Integer id);

}

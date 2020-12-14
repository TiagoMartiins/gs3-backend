package com.avaliacao.pleno.gs3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avaliacao.pleno.gs3.entity.UsuarioEntity;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Integer> {
	
	Optional<UsuarioEntity> findByNomeUsuario(String usuario);

}

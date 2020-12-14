package com.avaliacao.pleno.gs3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.avaliacao.pleno.gs3.entity.UsuarioEntity;
import com.avaliacao.pleno.gs3.repository.UsuarioRepository;
import com.avaliacao.pleno.gs3.security.UserSS;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		
		Optional<UsuarioEntity> user = userRepository.findByNomeUsuario(usuario);
		
		if(!user.isPresent())
			throw new UsernameNotFoundException(usuario);
		
		return new UserSS(user.get().getIdUsuario()
				,user.get().getNomeUsuario()
				,user.get().getSenhaUsuario(),user.get().getPerfis());
	}

}

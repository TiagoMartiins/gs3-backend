package com.avaliacao.pleno.gs3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.avaliacao.pleno.gs3.security.JWTUtil;
import com.avaliacao.pleno.gs3.security.UserSS;

@Service
public class UserService {
	
	@Autowired
	private JWTUtil util;
	
	public String getUser(String token) {
			return getUserAuthenticated().getUsername();
	}

	//Retorna o usuario logado na sessão, se não tiver retorna null
	public static UserSS getUserAuthenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}catch(Exception e) {
			return null;
		}
		
	}
	
	public boolean isAdmin(UserSS user) {
		
		Optional<? extends GrantedAuthority> admin = user.getAuthorities().stream().filter(x -> x.getAuthority().endsWith("ADMIN")).findFirst();
		if(admin.isPresent())
			return true;
		return false;
	}
}

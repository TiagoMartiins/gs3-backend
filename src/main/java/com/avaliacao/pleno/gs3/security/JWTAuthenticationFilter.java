package com.avaliacao.pleno.gs3.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.avaliacao.pleno.gs3.dto.UsuarioDTO;
import com.fasterxml.jackson.databind.ObjectMapper;


//Filtro de autenticação do spring security - Intercepta a requisição de login e trata
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JWTAuthenticationFilter.class);
	
	private AuthenticationManager authenticationManager;
	
	private JWTUtil jwtUtil;
	
	public JWTAuthenticationFilter(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
		this.setAuthenticationFailureHandler(new JWTAuthenticationFailureHandler());
		this.setAuthenticationManager(authenticationManager);
		this.authenticationManager = authenticationManager;
		this.jwtUtil = jwtUtil;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req,
												HttpServletResponse res) throws AuthenticationException{
		
		LOGGER.info("Request info : { }",req.getRequestURI());
		
		try {
			//Primeiro ele tenta extrair os dados do body da requisição para o formato UsuarioDTO
			UsuarioDTO user = new ObjectMapper().readValue(req.getInputStream(), UsuarioDTO.class);
			
			//teste
			
			//Contrato do spring security para fazer a autenticação
			UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(user.getUsuario(), user.getSenha(), new ArrayList<>());
			
			//Ele autentica de acordo com o que foi implementado no UserDetailsService no caso quem implementou essa interface
			// UserDetailsServiceImpl
			//Authentication auth2 = this.getAuthenticationManager().authenticate(authToken);
			Authentication auth = authenticationManager.authenticate(authToken);
			
			return auth;
			
		}catch(IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	//Caso a autenticação seja um sucesso, prossiga com esse metodo, gera o token e guarda no header da requisição
	@Override
	protected void successfulAuthentication(HttpServletRequest req,
											HttpServletResponse res,
											FilterChain chain,
											Authentication auth) throws IOException,ServletException{
		
		String username = ((UserSS) auth.getPrincipal()).getUsername();
		String token = jwtUtil.generateToken(username);
		res.addHeader("Authorization", "Bearer "+ token);
	}
	
	private class JWTAuthenticationFailureHandler implements AuthenticationFailureHandler {
		
	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
            throws IOException, ServletException {
        response.setStatus(401);
        response.setContentType("application/json"); 
        response.getWriter().append(json());
    }
    
    private String json() {
        long date = new Date().getTime();
        return "{\"timestamp\": " + date + ", "
            + "\"status\": 401, "
            + "\"error\": \"Não autorizado\", "
            + "\"message\": \"Chave inválida\", "
            + "\"path\": \"/login\"}";
    }
    
	}

}

package com.avaliacao.pleno.gs3.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request){
		
		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),
				e.getMessage(), System.currentTimeMillis());
		
		e.getBindingResult().getFieldErrors().stream().forEach(x ->{
			err.addError(x.getField(), x.getDefaultMessage());
		});
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}
	
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<StandardError> autorization(AccessDeniedException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(HttpStatus.FORBIDDEN.value(),e.getMessage() , System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(err);
	}
}

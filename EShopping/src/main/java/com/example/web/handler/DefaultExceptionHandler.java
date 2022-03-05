package com.example.web.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler{
	
//	@ExceptionHandler(Exception.class)
//	public final ResponseEntity<ErrorMessage> SometingWentWrong(Exception ex){
//		
//	}
}

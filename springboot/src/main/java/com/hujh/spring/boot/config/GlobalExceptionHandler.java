package com.hujh.spring.boot.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public void defaultExceptionHandler(HttpServletRequest req, Exception e) {
		// 
		
	}
	
}

package com.userManagementSystem.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userManagementSystem.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {
	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundException(
			UserNotFoundException ex,
			HttpServletRequest request
			){
		log.warn("User not found at {} : {}", request.getRequestURI(), ex.getMessage());
		
		ErrorResponse response = new ErrorResponse();
		response.setStatus(404);
	    response.setMessage(ex.getMessage());
	    response.setPath(request.getRequestURI());
	    response.setTimestamp(LocalDateTime.now().toString());
	    
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(
	        MethodArgumentNotValidException ex,
	        HttpServletRequest request) {

	    log.warn("Validation error at {} : {}", request.getRequestURI(), ex.getMessage());

	    Map<String, String> fieldErrors = new HashMap<>();

	    ex.getBindingResult().getFieldErrors().forEach(error ->
	            fieldErrors.put(error.getField(), error.getDefaultMessage())
	    );

	    ErrorResponse response = new ErrorResponse();
	    response.setStatus(HttpStatus.BAD_REQUEST.value());
	    response.setMessage("Validation failed");
	    response.setPath(request.getRequestURI());
	    response.setTimestamp(LocalDateTime.now().toString());

	    return ResponseEntity.badRequest().body(response);
	}

}

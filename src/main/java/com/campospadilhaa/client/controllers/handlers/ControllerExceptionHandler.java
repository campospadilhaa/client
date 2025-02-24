package com.campospadilhaa.client.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.campospadilhaa.client.dto.CustomError;
import com.campospadilhaa.client.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

/*
 * O console é consultado para identificar qual a exceção emitida pelo Spring, nestes exemplos:
 * ResourceNotFoundException, ResourceDatabaseException ou MethodArgumentNotValidException 
 */

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class) // configurada a classe de exceção criada: ResourceNotFoundException
	public ResponseEntity<CustomError> resourceNotFoundException(ResourceNotFoundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;

		CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}
}
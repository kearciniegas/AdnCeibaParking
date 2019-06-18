package com.ceiba.induccion.infrastructure.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ceiba.induccion.domain.exception.Exceptions;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleConflictRuntimeException(RuntimeException ex, WebRequest request) {
		String bodyOfResponse = ex.getMessage();
		return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}

	@ExceptionHandler(value = { Exceptions.class })
	protected ResponseEntity<Object> handleConflictExcepcionDuplicidad(RuntimeException ex, WebRequest request) {
		Map<String, String> mapResponse = new HashMap<>();
		mapResponse.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(mapResponse);
	}
}

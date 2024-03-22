package com.example.demo.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(BaseException.class)
	public ResponseEntity<ExceptionResponse> handle(BaseException ex) {
		log.warn(ex.getMessage(), ex);

		BaseExceptType exceptType = ex.getType();
		return ResponseEntity.status(exceptType.status())
			.body(ExceptionResponse.of(exceptType.code(), exceptType.message()));
	}
}

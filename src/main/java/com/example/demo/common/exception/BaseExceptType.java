package com.example.demo.common.exception;

import org.springframework.http.HttpStatus;

public interface BaseExceptType {

	String message();

	String code();

	HttpStatus status();
}

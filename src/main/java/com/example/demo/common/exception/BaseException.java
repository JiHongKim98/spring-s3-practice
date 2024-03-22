package com.example.demo.common.exception;

public class BaseException extends RuntimeException {

	private final BaseExceptType baseExceptType;

	public BaseException(BaseExceptType baseExceptType) {
		super(baseExceptType.message());
		this.baseExceptType = baseExceptType;
	}

	public BaseExceptType getType() {
		return baseExceptType;
	}
}

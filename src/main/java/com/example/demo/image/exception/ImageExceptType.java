package com.example.demo.image.exception;

import org.springframework.http.HttpStatus;

import com.example.demo.common.exception.BaseExceptType;

public enum ImageExceptType implements BaseExceptType {
	IMAGE_UPLOAD_ERROR(HttpStatus.BAD_REQUEST, "이미지 업로드에 실패했습니다."),
	IMAGE_ENCODING_ERROR(HttpStatus.BAD_REQUEST, "이미지 인코딩에 실패했습니다");

	private final HttpStatus status;
	private final String message;

	ImageExceptType(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	@Override
	public String message() {
		return message;
	}

	@Override
	public String code() {
		return this.name();
	}

	@Override
	public HttpStatus status() {
		return status;
	}
}

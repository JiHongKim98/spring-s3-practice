package com.example.demo.image.application.dto;

public record ImageUrlResponse(
	String imageUrl
) {

	public static ImageUrlResponse of(String imageUrl) {
		return new ImageUrlResponse(imageUrl);
	}
}

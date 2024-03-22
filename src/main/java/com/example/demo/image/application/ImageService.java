package com.example.demo.image.application;

import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.application.dto.ImageUrlResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {

	private final ImageClient imageClient;

	public ImageUrlResponse uploadImage(MultipartFile file) {
		String objectKey = UUID.randomUUID().toString();
		String imageUrl = imageClient.upload(objectKey, file);
		return ImageUrlResponse.of(imageUrl);
	}
}

package com.example.demo.image.infrastructure;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.config.S3Properties;
import com.example.demo.image.application.ImageClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class S3ImageClient implements ImageClient {

	private final S3Properties properties;
	private final S3Uploader s3Uploader;

	@Override
	public String upload(String objectKey, MultipartFile file) {
		String bucketName = properties.bucketName();
		s3Uploader.upload(bucketName, objectKey, file);
		return properties.imageUrl() + objectKey;
	}
}

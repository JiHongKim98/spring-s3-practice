package com.example.demo.image.infrastructure;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.common.config.S3Properties;
import com.example.demo.image.application.ImageClient;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@RequiredArgsConstructor
public class S3ImageClient implements ImageClient {

	private final S3Client s3Client;
	private final S3Properties properties;

	@Override
	public String upload(String objectKey, MultipartFile file) throws IOException {
		PutObjectRequest request = PutObjectRequest.builder()
			.bucket(properties.bucketName())
			.key(objectKey)
			.contentType(file.getContentType())
			.build();
		s3Client.putObject(request, RequestBody.fromBytes(file.getBytes()));

		return properties.imageUrl() + objectKey;
	}
}

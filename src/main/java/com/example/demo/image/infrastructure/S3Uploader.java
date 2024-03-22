package com.example.demo.image.infrastructure;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@RequiredArgsConstructor
public class S3Uploader {

	private final S3Client s3Client;

	public void upload(String bucketName, String key, MultipartFile file) {
		PutObjectRequest request = PutObjectRequest.builder()
			.bucket(bucketName)
			.key(key)
			.contentType(file.getContentType())
			.build();
		s3Client.putObject(request, RequestBody.fromBytes(getBytes(file)));
	}

	private byte[] getBytes(MultipartFile file) {
		try {
			return file.getBytes();
		} catch (IOException ex) {
			throw new RuntimeException(ex);  // TODO: 예외 처리 보강
		}
	}
}

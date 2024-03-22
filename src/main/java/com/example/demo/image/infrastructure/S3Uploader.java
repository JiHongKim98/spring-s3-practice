package com.example.demo.image.infrastructure;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.exception.ImageExceptType;
import com.example.demo.image.exception.ImageException;

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

		putObject(request, file);
	}

	private void putObject(PutObjectRequest request, MultipartFile file) {
		try {
			s3Client.putObject(request, RequestBody.fromBytes(getBytes(file)));
		} catch (Exception ex) {
			throw new ImageException(ImageExceptType.IMAGE_UPLOAD_ERROR);
		}
	}

	private byte[] getBytes(MultipartFile file) {
		try {
			return file.getBytes();
		} catch (IOException ex) {
			throw new ImageException(ImageExceptType.IMAGE_ENCODING_ERROR);
		}
	}
}

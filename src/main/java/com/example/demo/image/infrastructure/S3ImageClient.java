package com.example.demo.image.infrastructure;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.application.ImageClient;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Component
@RequiredArgsConstructor
public class S3ImageClient implements ImageClient {

	@Value("${aws.s3.bucket-name}")
	private String bucketName;

	@Value("${aws.s3.image-url}")
	private String imageUrl;

	private final S3Client s3Client;

	@Override
	public String upload(String objectKey, MultipartFile file) throws IOException {
		PutObjectRequest request = PutObjectRequest.builder()
			.bucket(bucketName)
			.key(objectKey)
			.contentType(file.getContentType())
			.build();
		RequestBody requestBody = RequestBody.fromBytes(file.getBytes());

		s3Client.putObject(request, requestBody);

		return imageUrl + objectKey;
	}
}

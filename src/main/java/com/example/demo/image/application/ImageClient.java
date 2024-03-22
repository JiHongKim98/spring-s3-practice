package com.example.demo.image.application;

import org.springframework.web.multipart.MultipartFile;

public interface ImageClient {

	String upload(String objectKey, MultipartFile file);
}

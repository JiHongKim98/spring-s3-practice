package com.example.demo.image.application;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ImageClient {

	String upload(String objectKey, MultipartFile file) throws IOException;
}

package com.example.demo.image.presentation;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.image.application.ImageService;
import com.example.demo.image.application.dto.ImageUrlResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/v1/images")
@RequiredArgsConstructor
public class ImageController {

	private final ImageService imageService;

	@PostMapping("/upload")
	public ResponseEntity<ImageUrlResponse> upload(
		@RequestPart(name = "files", required = false) MultipartFile file
	) throws IOException {
		log.info("file => {}", file);

		return ResponseEntity.ok(imageService.uploadImage(file));
	}
}

package com.example.demo.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "aws.s3")
public record S3Properties(
	String bucketName,
	String accessKey,
	String secretKey,
	String region,
	String imageUrl
) {
}

package com.example.demo;

import java.nio.charset.StandardCharsets;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import static org.springframework.util.StreamUtils.copyToString;

@SpringBootApplication
public class DemoApplication {

	private static final Log logger = LogFactory.getLog(DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	ApplicationRunner validateConfiguration(ResourceLoader resourceLoader) {
		return args -> {
			Resource resource = resourceLoader.getResource("classpath:/application-prod.yaml");
			if (resource.exists()) {
				logger.info("Resource loaded from the classpath %s".formatted(StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8)));
			} else {
				logger.error("Resource %s does not exist".formatted(resource));
			}
		};
	}

}

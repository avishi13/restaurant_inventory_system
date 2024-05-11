package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.project.model")

public class SpringStsDemoDatabaseConnectivityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringStsDemoDatabaseConnectivityApplication.class, args);
	}

}

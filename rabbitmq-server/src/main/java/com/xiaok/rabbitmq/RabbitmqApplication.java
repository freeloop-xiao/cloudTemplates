package com.xiaok.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RabbitmqApplication {
	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
}


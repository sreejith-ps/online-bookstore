package com.sps.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BookServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookServiceRegistryApplication.class, args);
	}

}

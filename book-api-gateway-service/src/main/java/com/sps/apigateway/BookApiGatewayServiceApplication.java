package com.sps.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookApiGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookApiGatewayServiceApplication.class, args);
	}

}

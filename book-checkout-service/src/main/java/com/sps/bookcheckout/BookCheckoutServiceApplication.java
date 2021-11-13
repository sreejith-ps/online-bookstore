package com.sps.bookcheckout;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BookCheckoutServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCheckoutServiceApplication.class, args);
	}

}

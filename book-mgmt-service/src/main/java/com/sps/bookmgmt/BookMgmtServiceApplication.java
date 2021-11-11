package com.sps.bookmgmt;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sps.bookmgmt.model.Book;
import com.sps.bookmgmt.repository.BookRepository;

@SpringBootApplication
public class BookMgmtServiceApplication implements CommandLineRunner{

	@Autowired
	BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookMgmtServiceApplication.class, args);
	}
	
	public void run(String... args) {
		repository.saveAll(Arrays.asList(
				new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99),
				new Book(2L, "Adam Grant1", "Think Again1", "1-234-56-788", "Classic", 49.99)
				));
	}

}

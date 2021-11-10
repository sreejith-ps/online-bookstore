package com.sps.bookmgmt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookmgmt.entity.Book;

@RestController
@RequestMapping("/book")
public class BookController {

	@GetMapping("/{isbn}")
	public Book getBookDetails(@PathVariable("isbn") String isbn) {
		Book book = new Book();
		book.setIsbn("1-2345-567-89");
		book.setName("Think Again");
		book.setAuthor("Adam Grant");
		book.setDescription("Think Again");
		book.setPrice(39.99);
		return book;
	}
	
}

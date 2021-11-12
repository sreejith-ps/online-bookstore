package com.sps.bookmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sps.bookmgmt.exception.ResourceNotFoundException;
import com.sps.bookmgmt.model.Book;
import com.sps.bookmgmt.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	BookService bookService;

	@GetMapping("/{isbn}")
	public Book getBookDetails(@PathVariable("isbn") Long isbn) throws ResourceNotFoundException {
		Book book = bookService.getBookDetailsById(isbn);
		return book;
	}

	@GetMapping
	public List<Book> getBooks() {
		return bookService.getAllBooks();
	}

	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.create(book);
	}

	@PutMapping("/{isbn}")
	public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("isbn") Long bookId) 
			throws ResourceNotFoundException {
		Book modifiedBook = bookService.update(book, bookId);
		return ResponseEntity.ok(modifiedBook);
	}
	
	@DeleteMapping("/{isbn}")
	public ResponseEntity<HttpStatus> deleteBook(@PathVariable("isbn") Long isbn) 
			throws ResourceNotFoundException {
		bookService.delete(isbn);
		return ResponseEntity.noContent().build();
	}

}

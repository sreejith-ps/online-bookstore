package com.sps.bookmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sps.bookmgmt.exception.ResourceNotFoundException;
import com.sps.bookmgmt.model.Book;
import com.sps.bookmgmt.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository repository;
	
	public List<Book> getAllBooks() {
		return repository.findAll();
	}

	public Book create(Book book) {
		book = repository.save(book);
		return book;
	}

	public Book getBookDetailsById(Long id) throws ResourceNotFoundException {
		Book book = repository.findById(id).orElseThrow(() -> 
			new ResourceNotFoundException("Book not found with id - " + id));
		return book;
	}

	public Book update(Book modifedBook, Long isbn) throws ResourceNotFoundException {
		Book book = repository.findById(isbn).orElseThrow(() -> 
			new ResourceNotFoundException("Book not found with id - " + isbn));    
		book.setAuthor(book.getAuthor());
		book.setDescription(modifedBook.getDescription());
		book.setName(modifedBook.getName());
		book.setPrice(modifedBook.getPrice());
		book.setType(modifedBook.getType());
		
		repository.save(book);
		
		return book;
	}

	public void delete(Long id) throws ResourceNotFoundException {
		Book book = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found with id - " + id));
		repository.delete(book);
//		repository.deleteById(id);
	}

}

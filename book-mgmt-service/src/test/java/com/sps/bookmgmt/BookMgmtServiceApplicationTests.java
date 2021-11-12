package com.sps.bookmgmt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sps.bookmgmt.controller.BookController;
import com.sps.bookmgmt.exception.ResourceNotFoundException;
import com.sps.bookmgmt.model.Book;
import com.sps.bookmgmt.repository.BookRepository;
import com.sps.bookmgmt.service.BookService;

@SpringBootTest
class BookMgmtServiceApplicationTests {
	
	@Autowired
	private BookController controller;
	

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
	
	

	@Autowired
	private BookService bookService;
	
	@MockBean
	private BookRepository bookRepository;
	
	
	@Test
	public void getAllBooksTest() {
		when(bookRepository.findAll()).thenReturn(Stream.of(
				new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99),
				new Book(2L, "Adam Grant1", "Think Again1", "1-234-56-788", "Classic", 49.99)).collect(Collectors.toList()));
		assertEquals(2,  bookService.getAllBooks().size());
	}
	
	@Test
	public void getBookDetailsByIdTest() throws ResourceNotFoundException {
		Long id = 1L;
		when(bookRepository.getById(id)).thenReturn(new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99));
		assertSame(new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99), bookService.getBookDetailsById(id));
	}
	
	@Test
	public void createTest() {
		Book book = new Book(null, "Adam Grant Test", "Think Again", "1-234-56-789", "Classic", 39.99);
		when(bookRepository.save(book)).thenReturn(book);
		assertEquals(book, bookService.create(book));
	}
	
	@Test
	public void deleteTest() throws ResourceNotFoundException {
		Book book = new Book(1L, "Adam Grant Test", "Think Again", "1-234-56-789", "Classic", 39.99);
		bookService.delete(1L);
		verify(bookRepository, times(1)).delete(book);
	}
	
	

}

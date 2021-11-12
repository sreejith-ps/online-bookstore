package com.sps.bookmgmt.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sps.bookmgmt.model.Book;
import com.sps.bookmgmt.repository.BookRepository;
import com.sps.bookmgmt.service.BookService;

@WebMvcTest(value = BookController.class)
public class BookControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Test
	public void getAllBooksTest() throws Exception {
		List<Book> mockBookList = Stream
				.of(new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99),
						new Book(2L, "Adam Grant1", "Think Again1", "1-234-56-788", "Classic", 49.99))
				.collect(Collectors.toList());
		String input = getJson(mockBookList);
		String URI = "/api/books";

		when(bookService.getAllBooks()).thenReturn(mockBookList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		assertEquals(2, bookService.getAllBooks().size());
		assertThat(result.getResponse().getContentAsString()).isEqualTo(input);
	}

	@Test
	public void getBookDetailsByIdTest() throws Exception {
		Long id = 1L;
		Book mockBook = new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99);
		String input = getJson(mockBook);
		String URI = "/api/books/1";

		when(bookService.getBookDetailsById(Mockito.anyLong())).thenReturn(mockBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(URI)
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(input);
		System.out.println(result.getResponse().getContentAsString());
		JSONAssert.assertEquals(input, result.getResponse().getContentAsString(), false);
	}

	@Test
	public void createBookTest() throws Exception {
		Book mockBook = new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99);
		String input = getJson(mockBook);
		String URI = "/api/books";
		when(bookService.create(Mockito.any(Book.class))).thenReturn(mockBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(input)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		String output = response.getContentAsString();
		assertThat(output).isEqualTo(input);
		assertEquals(HttpStatus.OK.value(), response.getStatus());

	}

	@Test
	public void updateBookTest() throws Exception {
		Book mockBook = new Book(1L, "Adam Grant", "Think Again", "1-234-56-789", "Classic", 39.99);
		String input = getJson(mockBook);
		String URI = "/api/books/1";
		when(bookService.update(Mockito.any(Book.class), Mockito.anyLong())).thenReturn(mockBook);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.put(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(input)
				.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertThat(response.getContentAsString()).isEqualTo(input);

	}

	private String getJson(Object obj) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
}

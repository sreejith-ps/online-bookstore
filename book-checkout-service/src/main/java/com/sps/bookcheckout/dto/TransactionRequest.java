package com.sps.bookcheckout.dto;

import java.util.ArrayList;
import java.util.List;

public class TransactionRequest {

	private List<Book> books = new ArrayList<>();
	private String promocode;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public String getPromocode() {
		return promocode;
	}
	public void setPromocode(String promocode) {
		this.promocode = promocode;
	}
}

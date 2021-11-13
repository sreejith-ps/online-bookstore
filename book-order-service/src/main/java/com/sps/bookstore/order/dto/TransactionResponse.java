package com.sps.bookstore.order.dto;

import java.util.ArrayList;
import java.util.List;

public class TransactionResponse {

	private List<Book> books = new ArrayList<>();
	private double totalPrice;
	
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}

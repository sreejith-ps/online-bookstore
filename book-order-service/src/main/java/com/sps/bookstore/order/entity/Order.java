package com.sps.bookstore.order.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "book_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private Long orderId;
	@Column(name = "bookid")
	private Long bookId;
	@Column(name = "name")
	private String name;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "discount")
	private Double discount;
	@Column(name = "price")
	private Double price;
	
	public Order() {}
	
	public Order(Long id, Long bookId, String name, Integer quantity, Double discount, Double price) {
		super();
		this.orderId = id;
		this.bookId = bookId;
		this.name = name;
		this.quantity = quantity;
		this.discount = discount;
		this.price = price;
	}
	public Long getId() {
		return orderId;
	}
	public void setId(Long id) {
		this.orderId = id;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	

}

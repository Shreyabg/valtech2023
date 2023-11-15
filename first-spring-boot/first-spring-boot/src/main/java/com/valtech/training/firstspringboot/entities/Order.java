package com.valtech.training.firstspringboot.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")//orders is keyword on DB
public class Order {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String item;
	private int itemCounter;
	private String description;
	private LocalDate orderDate;
	
	
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(long id, String item, int count, String description, LocalDate orderDate) {
		super();
		this.id = id;
		this.item = item;
		this.itemCounter = count;
		this.description = description;
		this.orderDate = orderDate;
	}
	

	public Order(String item, int count, String description, LocalDate orderDate) {
		super();
		this.item = item;
		this.itemCounter = count;
		this.description = description;
		this.orderDate = orderDate;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getItemCounter() {
		return itemCounter;
	}
	public void setItemCounter(int count) {
		this.itemCounter = count;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

}

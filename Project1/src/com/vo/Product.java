package com.vo;

public class Product {
	private int no;
	private String name;
	private int ea;
	private int price;
	private String country;
	
	public Product() {}

	public Product(String name, int ea, int price, String country) {
		this.name = name;
		this.ea = ea;
		this.price = price;
		this.country = country;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEa() {
		return ea;
	}

	public void setEa(int ea) {
		this.ea = ea;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
}

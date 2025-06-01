package com.vo;

public class Order {
	private int no;
	private int productNo;
	private String productName;
	private String userId;
	private int productEa;
	private int productPrice;
	
	public Order( ) {}

	public Order(int productNo, String productName, String userId, int productEa, int productPrice) {
		this.productNo = productNo;
		this.productName = productName;
		this.userId = userId;
		this.productEa = productEa;
		this.productPrice = productPrice;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
	
	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getProductEa() {
		return productEa;
	}

	public void setProductEa(int productEa) {
		this.productEa = productEa;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	
}

package com.service;

import java.util.List;

import com.vo.Product;

public interface ProductService {
	public boolean addProduct(Product product); // 상품 등록
	public boolean modifyProduct(Product product); // 상품 수정
	public boolean removeProduct(int no); // 상품 삭제
	public List<Product> ProductList(); // 상품 목록
	public boolean updateEa(Product product); // 재고 업데이트
}

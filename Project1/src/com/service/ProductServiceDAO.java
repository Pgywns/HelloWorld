package com.service;

import java.util.List;

import com.common.ProductDAO;
import com.vo.Product;

public class ProductServiceDAO implements ProductService {

	ProductDAO dao = new ProductDAO();
	
	@Override
	public boolean addProduct(Product product) {
		return dao.insert(product) == 1;
	}

	@Override
	public boolean modifyProduct(Product product) {
		return dao.update(product) == 1;
	}

	@Override
	public boolean removeProduct(int no) {
		return false;
	}

	@Override
	public List<Product> ProductList() {
		return dao.productList();
	}
	
}

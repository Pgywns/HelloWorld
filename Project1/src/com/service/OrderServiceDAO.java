package com.service;

import java.util.List;

import com.common.OrderDAO;
import com.vo.Order;

public class OrderServiceDAO implements OrderService {

	OrderDAO dao = new OrderDAO();
	
	@Override
	public boolean addOrder(Order order) {
		return dao.insert(order) == 1;
	}

	@Override
	public boolean removeOrder(int no) {
		return dao.delete(no) == 1;
	}

	@Override
	public List<Order> OrderList() {
		return dao.orderList();
	}

}

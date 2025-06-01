package com.service;

import java.util.List;
import com.vo.Order;

public interface OrderService {
	public boolean addOrder(Order order); // 주문 등록
	public boolean removeOrder(int no); // 주문 삭제
	public List<Order> OrderList(); // 주문 목록
}

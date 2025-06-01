package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.Order;

public class OrderDAO extends DAO {
	
	public List<Order> orderList() {
		String sql = "select * from userorder order by no ";
		
		getConnect();
		List<Order> list = new ArrayList<Order>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Order order = new Order();
				order.setNo(rs.getInt("no"));
				order.setProductNo(rs.getInt("product_no"));
				order.setProductName(rs.getString("product_name"));
				order.setUserId(rs.getString("user_id"));
				order.setProductEa(rs.getInt("product_ea"));
				order.setProductPrice(rs.getInt("product_price"));
				
				list.add(order);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}	
		
		return null;
	} // orderList
	
	public int insert(Order order) {
		String sql = "insert into userorder(product_no, product_name, user_id, product_ea, product_price)" + "values(?, ?, ?, ?, ?)";

		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, order.getProductNo());
			psmt.setString(2, order.getProductName());
			psmt.setString(3, order.getUserId());
			psmt.setInt(4, order.getProductEa());
			psmt.setInt(5, order.getProductPrice());
		
			int r = psmt.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return 0;
	} // insert
	
	public int delete(int no) {
		String sql = "delete from userorder " + " where no = ?";
		// 접속
		getConnect();

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			disConnect();
		}
		return 0;
	} // delete
	
}

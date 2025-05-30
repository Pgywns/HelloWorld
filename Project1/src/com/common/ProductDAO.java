package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.Product;

public class ProductDAO extends DAO {
	
	public List<Product> productList() {
		String sql = "select * from product order by no ";
		
		getConnect();
		List<Product> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setNo(rs.getInt("no"));
				product.setName(rs.getString("name"));
				product.setEa(rs.getInt("ea"));
				product.setPrice(rs.getInt("price"));
				product.setCountry(rs.getString("country"));
				
				list.add(product);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}	
		
		return null;
	} // productList
	
	public int insert(Product product) {
		
		String sql = "insert into product(name, ea, price, country)" + "values(?, ?, ?, ?)";

		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, product.getName());
			psmt.setInt(2, product.getEa());
			psmt.setInt(3, product.getPrice());
			psmt.setString(4, product.getCountry());

			if (product.getName().equals("")) {
				System.out.println("상품 이름은 필수 항목입니다.");
				return 0;
			}
			
			int r = psmt.executeUpdate();
			return r;
			
		} catch (SQLException e) {
			System.out.println("중복된 상품이거나 정보를 잘못 입력하였습니다.");
		} finally {
			disConnect();
		}
		
		return 0;		
	} // insert
	
	public int update(Product product) {
		String sql = "update product "
				   + "set price = ? "
				   + "   ,ea = ? "
				   + "   ,country = ? "   
		   		   + " where  no = ? ";
		
		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, product.getPrice());
			psmt.setInt(2, product.getEa());
			psmt.setString(3, product.getCountry());
			psmt.setInt(4, product.getNo());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return 0;

	} // update
}

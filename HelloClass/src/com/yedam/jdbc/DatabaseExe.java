package com.yedam.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * 1. Driver Manager
 * 2. Connection
 * 3. Statement
 * 4. 실행
 * 5. ResultSet
 * 6. 출력
 */

public class DatabaseExe {
	
	public static void main(String[] args) {
		
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String id = "scott";
		String pass = "tiger";
		
		Connection conn = null;
		
		// 연결
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
			conn.setAutoCommit(false);
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 연결");
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		// Statement 객체
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "delete from product where p_code = 200";
		
		try {
			stmt = conn.createStatement();
			int r = stmt.executeUpdate(sql); // 처리된 건수를 반환
			if (r > 0) {
				conn.commit();
				System.out.println(r + "건 등록됨");
			} else {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from product"); // 결과문이 담긴 ResultSet을 반환
			System.out.println("상품코드  상품이름               가격");
			System.out.println("---------------------------------");
			while (rs.next()) {
				System.out.printf("%-6d %-20s %d\n", rs.getInt("p_code"), rs.getString("p_name"), rs.getInt("p_price"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		try {
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			if (conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	} // main
	
}

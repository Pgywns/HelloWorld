package com.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String id = "project1";
	String pass = "project1";
	Connection conn;
	Statement stmt;
	PreparedStatement psmt;
	ResultSet rs;
	
	// Connection 생성하는 메소드
	public void getConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, id, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // getConnect
	
	public void disConnect() {
		try {
			if (conn != null) conn.close();
			if (stmt != null) stmt.close();
			if (rs != null) rs.close();
				
		} catch(SQLException e) {
			e.printStackTrace();
		}
	} // disConnect
}

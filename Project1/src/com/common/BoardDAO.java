package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.Board;

public class BoardDAO extends DAO {
	
	public List<Board> boardList() {
		String sql = "select * from board";

		// 접속
		getConnect();
		List<Board> list = new ArrayList<>();
		
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while (rs.next()) {
				Board board = new Board();
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUploaddate(rs.getString("uploaddate"));
				board.setWriter(rs.getString("writer"));
				
				list.add(board);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			disConnect();		
		}
		
		return null;
	}
	
} // BoardDAO

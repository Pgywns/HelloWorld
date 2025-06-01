package com.common;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vo.Board;

public class BoardDAO extends DAO {

	public List<Board> boardList() {
		String sql = "select * from board order by no";

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
	} // boardList

	public int delete(int no) {
		String sql = "delete from board " + "where  no = ?";
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

	public int insert(Board board) {

		String sql = "insert into board(title, content, writer )" + "values(?, ?, ?)";

		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setString(1, board.getTitle());
			psmt.setString(2, board.getContent());
			psmt.setString(3, board.getWriter());

			if (board.getTitle().equals("")) {
				System.out.println("제목은 필수 항목입니다.");
				return 0;
			}

			int r = psmt.executeUpdate();
			return r;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return 0;
	} // insert

	public int update(Board board) {
		String sql = "update board "
				   + "set no = ?";    
	
		if (!board.getTitle().equals("")) {
			sql = sql + "     , title = " + "'" + board.getTitle() + "'";
		}
		
		if (!board.getContent().equals("")) {
			sql = sql + "     , content = " + "'" + board.getContent() + "'";
		}
		
		sql = sql + " where no = ?";
		
		// 접속
		getConnect();
		try {
			psmt = conn.prepareStatement(sql);

			psmt.setInt(1, board.getNo());
			psmt.setInt(2, board.getNo());

			int r = psmt.executeUpdate();
			return r;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("수정에 실패하였습니다. 다시 입력하세요.");
		} finally {
			disConnect();
		}
		return 0;

	} // update
	
} // BoardDAO

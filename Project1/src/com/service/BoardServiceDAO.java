package com.service;

import java.util.List;

import com.common.BoardDAO;
import com.vo.Board;

public class BoardServiceDAO implements BoardService {

	BoardDAO dao = new BoardDAO();
	
	@Override
	public boolean addBoard(Board board) {
		return dao.insert(board) == 1;
	}

	@Override
	public boolean modifyBoard(Board board) {
		return dao.update(board) == 1;
	}

	@Override
	public boolean deleteBoard(int no) {
		return dao.delete(no) == 1;
	}

	@Override
	public List<Board> boardList() {
		return dao.boardList();
	}

}

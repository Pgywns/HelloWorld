package com.service;

import java.util.List;

import com.common.BoardDAO;
import com.vo.Board;

public class BoardServiceDAO implements BoardService {

	BoardDAO dao = new BoardDAO();
	
	@Override
	public boolean addBoard(Board board) {
		return false;
	}

	@Override
	public boolean modifyBoard() {
		return false;
	}

	@Override
	public boolean deleteBoard() {
		return false;
	}

	@Override
	public List<Board> boardList() {
		return dao.boardList();
	}

}

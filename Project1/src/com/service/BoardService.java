package com.service;

import java.util.List;

import com.vo.Board;

public interface BoardService {
	public boolean addBoard(Board board); // 글 등록
	public boolean modifyBoard(); // 글 수정
	public boolean deleteBoard(); // 글 삭제
	public List<Board> boardList(); // 글 목록
}

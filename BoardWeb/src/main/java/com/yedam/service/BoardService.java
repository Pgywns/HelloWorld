package com.yedam.service;

import java.util.List;

import com.yedam.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList(int page);
	public List<BoardVO> selectListWithPaging(int page);
	public BoardVO getBoard(int bno);
	public boolean registerBoard(BoardVO board);
	public boolean modifyBoard(BoardVO board);
	public boolean removeBoard(int bno);
}

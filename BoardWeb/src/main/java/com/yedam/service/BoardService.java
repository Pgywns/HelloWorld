package com.yedam.service;

import java.util.List;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> boardList(SearchDTO search);
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO getBoard(int bno);
	public boolean registerBoard(BoardVO board);
	public boolean modifyBoard(BoardVO board);
	public boolean removeBoard(int bno);
	
	// 전체카운트 계산
	public int getTotalCount(SearchDTO search); // selectCount()
}

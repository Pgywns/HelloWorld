package com.yedam.service;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

public interface BoardService {
	public List<BoardVO> boardList(SearchDTO search);
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO getBoard(int bno);
	public boolean registerBoard(BoardVO board);
	public boolean modifyBoard(BoardVO board);
	public boolean removeBoard(int bno);
	
	// 전체카운트 계산
	public int getTotalCount(SearchDTO search); // selectCount()
	public List<Map> chartCount();
	
	// 이벤트
	public List<EventVO> eventList();
	public boolean addEvent(EventVO event);
	public boolean removeEvent(EventVO event);
}

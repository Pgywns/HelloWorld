package com.yedam.mapper;

import java.util.List;
import java.util.Map;

import com.yedam.common.SearchDTO;
import com.yedam.vo.BoardVO;
import com.yedam.vo.EventVO;

/*
 * 인터페이스 - XML 매칭
 */

public interface BoardMapper {
	public List<BoardVO> selectList(); // 사용 X
	public List<BoardVO> selectListWithPaging(SearchDTO search);
	public BoardVO selectBoard(int bno);
	public int updateReadCnt(int bno);
	public int insertBoard(BoardVO board);
	public int updateBoard(BoardVO board);
	public int deleteBoard(int bno);
	public int selectCount(SearchDTO search);
	
	public List<Map> selectUserByCount();
	
	// 이벤트
	public List<EventVO> selectEvent();
	public int insertEvent(EventVO event);
	public int deleteEvent(EventVO event);
}

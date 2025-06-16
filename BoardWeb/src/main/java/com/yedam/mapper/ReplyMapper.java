package com.yedam.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> selectReply(@Param("bno") int bno, @Param("page") int page);
	public ReplyVO getReply(int rno);
	public int insertReply(ReplyVO reply);
	public int deleteReply(int rno);
	public int selectTotal(int bno);
}

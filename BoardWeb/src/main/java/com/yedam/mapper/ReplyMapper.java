package com.yedam.mapper;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyMapper {
	public List<ReplyVO> selectReply(int bno);
	public ReplyVO getReply(int rno);
	public int insertReply(ReplyVO reply);
	public int deleteReply(int rno);
}

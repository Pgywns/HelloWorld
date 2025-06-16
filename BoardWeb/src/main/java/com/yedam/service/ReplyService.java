package com.yedam.service;

import java.util.List;

import com.yedam.vo.ReplyVO;

public interface ReplyService {
	public boolean addReply(ReplyVO reply);
	public List<ReplyVO> replyList(int bno, int page);
	public ReplyVO getReply(int rno);
	public boolean removeReply(int rno);
	public int totalCount(int bno);
}

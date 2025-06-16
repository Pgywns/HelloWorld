package com.yedam.common;

import java.util.List;

import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AppTest {
	public static void main(String[] args) {
		ReplyService svc = new ReplyServiceImpl();
		
		// 댓글 목록조회
		List<ReplyVO> list = svc.replyList(213, 1);
		
		for (ReplyVO reply : list) {
			System.out.println(reply.toString());
		}
		
		// 단건 조회
		ReplyVO rvo = svc.getReply(3);
		System.out.println(rvo.toString());
		
		// 댓글 등록
		ReplyVO reply = new ReplyVO();
		reply.setBoardNo(210);
		reply.setReply("댓글 테스트");
		reply.setReplyer("user99");
		svc.addReply(reply);
		
		// 댓글 삭제
		svc.removeReply(4);
		
	}
}

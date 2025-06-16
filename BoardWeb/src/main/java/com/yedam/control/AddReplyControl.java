package com.yedam.control;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.service.ReplyService;
import com.yedam.service.ReplyServiceImpl;
import com.yedam.vo.ReplyVO;

public class AddReplyControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 댓글 등록. 원본 글 번호, 댓글 작성자, 댓글
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String reply = req.getParameter("reply");
		String replyer = req.getParameter("replyer");
		
		ReplyVO rvo = new ReplyVO();
		rvo.setBoardNo(Integer.parseInt(bno));
		rvo.setReply(reply);
		rvo.setReplyer(replyer);
		rvo.setReplyDate(new Date());
		
		// json 문자열 생성 함수
		Map<String, Object> map = new HashMap<>();
		
		Gson gson = new GsonBuilder().create();
		
		ReplyService svc = new ReplyServiceImpl();
		if (svc.addReply(rvo)) {
			map.put("retVal", rvo);
			map.put("retCode", "Success");
//			resp.getWriter().print("{\"retCode\": \"Success\"}");
		} else {
			map.put("retCode", "Fail");
//			resp.getWriter().print("{\"retCode\": \"Fail\"}");
		}
		String json = gson.toJson(map);
		System.out.println(json);
		resp.getWriter().print(json);
		
	}
}

package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardService svc = new BoardServiceImpl();
		
		// http://localhost:8080/BoardWeb/board.do?bno=34
		String bno = req.getParameter("bno");
		
		// 추가 파라미터(page, searchCondition, keyword)
		String page = req.getParameter("page");
		String sc = req.getParameter("searchCondition");
		String kw = req.getParameter("keyword");
		
		// 글상세 조회
		BoardVO board = svc.getBoard(Integer.parseInt(bno));
		
		// 요청정보 저장
		req.setAttribute("board", board);
		req.setAttribute("page", page);
		req.setAttribute("searchCondition", sc);
		req.setAttribute("keyword", kw);
		
		// 요청재지정(페이지 이동)
		req.getRequestDispatcher("WEB-INF/jsp/board.jsp").forward(req, resp);
	}
	
}

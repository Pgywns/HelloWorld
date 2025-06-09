package com.yedam.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.common.PageDTO;
import com.yedam.service.BoardService;
import com.yedam.service.BoardServiceImpl;
import com.yedam.vo.BoardVO;

public class BoardListControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// forward 요청(req)과 응답(resp) 정보를 가지고 페이지 이동
//		req.setAttribute("myName", "HongKilDong");
		String page = req.getParameter("page");
		page = page == null ? "1" : page;
		
		BoardService svc = new BoardServiceImpl();
		List<BoardVO> list = svc.boardList(Integer.parseInt(page));
		
		// 페이징 계산
		int totalCnt = 224;
		PageDTO paging = new PageDTO(Integer.parseInt(page), totalCnt);
		
		req.setAttribute("blist", list); // 요청정보에 값을 담음
		req.setAttribute("pageInfo", paging);
		
		// 요청재지정(페이지 이동)
		req.getRequestDispatcher("WEB-INF/jsp/boardList.jsp").forward(req, resp);
	}
	
}

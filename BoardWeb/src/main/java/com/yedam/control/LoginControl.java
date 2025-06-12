package com.yedam.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yedam.common.Control;
import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceImpl;
import com.yedam.vo.MemberVO;

public class LoginControl implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("mid");
		String pw = req.getParameter("pass");
		
		// 로그인
		MemberService svc = new MemberServiceImpl();
		MemberVO member = svc.login(id, pw);
		
		if (member != null) {
			// 글 등록화면
			// 세션 객체에 setAttribute("logId", member.memberId)
			HttpSession session = req.getSession(); // cookie
			session.setAttribute("logId", member.getMemberId());
			session.setAttribute("auth", member.getResponsibility());
			
			if (member.getResponsibility().equals("User")) {
				resp.sendRedirect("addBoard.do");
			} else if (member.getResponsibility().equals("Admin")) {
				resp.sendRedirect("memberList.do");
			}
			
		} else {
			// 로그인 화면으로 이동
			req.setAttribute("msg", "ID와 PW를 확인하세요.");
			req.getRequestDispatcher("WEB-INF/jsp/loginForm.jsp").forward(req, resp);
		}
	}

}

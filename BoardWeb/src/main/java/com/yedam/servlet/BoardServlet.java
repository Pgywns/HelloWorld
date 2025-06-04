package com.yedam.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/board.serv")
public class BoardServlet extends HttpServlet {
	
	public BoardServlet() {
		System.out.println("BoardServlet 생성자 호출");
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출");
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("service 메소드 호출");
	}
}

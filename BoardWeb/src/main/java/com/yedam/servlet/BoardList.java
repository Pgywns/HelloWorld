package com.yedam.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.mapper.BoardMapper;
import com.yedam.vo.BoardVO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/boardList.serv")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public BoardList() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.print("hello");
		out.print("<p>안녕<p/>");
		SqlSession sqlSession = DataSource.getInstance().openSession();
		
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		List<BoardVO> list = mapper.selectList();
		
		out.print("<table border='1'>");
		out.print("<thead><tr><th>글번호</th><th>제목</th><th>내용</th><th>작성자</th></thead>");
		out.print("<tbody>");
		for (int i = 0; i < list.size(); i++) {
			out.print("<tr>");
			out.print("<td align = 'center'>" + list.get(i).getBoardNo() + "</td>");
			out.print("<td>" + list.get(i).getTitle() + "</td>");
			out.print("<td>" + list.get(i).getContent() + "</td>");
			out.print("<td>" + list.get(i).getWriter() + "</td>");
			out.print("</tr>");			
		}
		out.print("</tbody></table>");
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

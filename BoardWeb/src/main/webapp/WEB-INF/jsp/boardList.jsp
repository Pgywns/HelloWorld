<%@page import="com.yedam.common.PageDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 액션태그 -->
<jsp:include page="../include/header.jsp"/>

	<% 
		// 반환 타입이 object인데 object는 모든 타입의 상위에 있으므로 하위 타입으로 형변환 가능
		List<BoardVO> list = (List<BoardVO>) request.getAttribute("blist");
		PageDTO paging = (PageDTO)request.getAttribute("pageInfo");
	%>
	<p><%=paging %></p>
    <h3>게시글 목록</h3>

    <table class="table">
        <thead>
            <tr>
                <th>글 번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일시</th>
                <th>조회수</th>
            </tr>
        </thead>
        <tbody>
        	<% for (BoardVO board : list) { %>
            <tr>
                <td><a href = "board.do?bno=<%= board.getBoardNo()%>"><%= board.getBoardNo() %></a></td>
                <td><%= board.getTitle() %></td>
                <td><%= board.getWriter() %></td>
                <td><%= board.getWriteDate() %></td>
                <td><%= board.getReadCnt() %></td>
            </tr>
            <% } %>
        </tbody>
    </table>
    
	<nav aria-label="Page navigation example">
		<ul class="pagination justify-content-center">
		
			<%if(!paging.isPrev()) {%>
			<li class="page-item disabled">
				<a class="page-link">Previous</a>
			</li>
			<%} else { %>
			<li class="page-item">
				<a class="page-link" href="boardList.do?page=<%=paging.getStart() - 1%>">Previous</a>
			</li>
			<%} %>
			
			<% for (int p = paging.getStart(); p <= paging.getEnd(); p++) { %>
			
			<%if (p == paging.getCurrentPage()) { %>
			<li class="page-item active" aria-current="page"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
			<% } else { %>
			<li class="page-item"><a class="page-link" href="boardList.do?page=<%=p %>"><%=p %></a></li>
			<% } %>
			
			<% } %>
			
			<%if(!paging.isNext()) {%>
			<li class="page-item disabled">
				<a class="page-link">Next</a>
			</li>
			<%} else { %>
			<li class="page-item">
				<a class="page-link" href="boardList.do?page=<%=paging.getEnd() + 1 %>">Next</a>
			</li>
			<%} %>
		</ul>
	</nav>
<jsp:include page="../include/footer.jsp"/>
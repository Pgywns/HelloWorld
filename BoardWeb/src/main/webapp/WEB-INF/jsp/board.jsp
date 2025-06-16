<%@page import="com.yedam.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<h3>상세화면</h3>

<form action="modifyBoard.do">
<input type="hidden" name="bno" value="${board.boardNo }">
<input type="hidden" name="page" value="${page }">
<input type="hidden" name="searchCondition" value="${searchCondition }">
<input type="hidden" name="keyword" value="${keyword }">
	<table class="table">
		<tr>
			<th>글 번호</th>
			<td>${board.boardNo }</td>
			<th>조회수</th>
			<td>${board.readCnt }</td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">${board.title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td colspan="3"><textarea readonly>${board.content}</textarea></td>
		</tr>
		<tr>
			<th>작성자</th>
			<td colspan="3">${board.writer }</td>
		</tr>
		<tr>
			<th>작성일시</th>
			<td colspan="3">${board.writeDate }</td>
		</tr>
		<tr>
			<c:choose>
				<c:when test="${board.writer != logId}">
				<td colspan="4" align="center"><input type="submit" value="수정"
				class="btn btn-warning" disabled>
				<button class="btn btn-danger" type="button" disabled>삭제</button></td>
				</c:when>
				<c:otherwise>
				<td colspan="4" align="center"><input type="submit" value="수정"
				class="btn btn-warning">
				<button class="btn btn-danger" type="button">삭제</button></td>
				</c:otherwise>
			</c:choose>
		</tr>
	</table>
</form>
<style>
	div.reply ul {
		list-style-type: none;
	}
	div.reply span {
		display: inline-block;
	}
</style>
<!-- 댓글관련 페이지 -->
<div class="container reply">
	<div class="header">
		<input class="col-sm-8" id="reply">
		<button class="col-sm-3 btn btn-primary" id="addReply">등록</button>
	</div>
	<div class="content">
		<ul>
			<li>
				<span class="col-sm-2">글 번호</span>
				<span class="col-sm-4">글 내용</span>
				<span class="col-sm-2">작성자</span>
				<span class="col-sm-2">작성일시</span>
				<span class="col-sm-1"></span>
			</li>		
		</ul>
		<ul id="target">
			
		</ul>
	</div>
	<div class="footer">
<nav aria-label="...">
	<ul class="pagination pagination-sm">
		<li class="page-item disabled">
			<span class="page-link">Previous</span>
		</li>
		
		<li class="page-item">
			<a class="page-link" href="#">1</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">2</a>
		</li>
		<li class="page-item">
			<a class="page-link" href="#">3</a>
		</li>
		
		<li class="page-item">
		 	<a class="page-link" href="#">Next</a>
		</li>
	</ul>
</nav>
	</div>
</div>
<!-- 댓글관련 페이지 -->

<script>
	let bno = "${board.boardNo}";
	let logId = "${logId}";
	document.querySelector('button.btn-danger').addEventListener('click', function(){
		location.href = 'removeBoard.do?bno=' + bno;
	});
</script>
<script src="js/service.js"></script>
<script src="js/reply.js"></script>
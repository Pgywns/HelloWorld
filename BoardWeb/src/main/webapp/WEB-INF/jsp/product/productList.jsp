<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<h3>product/productList.jsp</h3>

<div id="show">
	<table class="table">
		<tr>
			<th>글 번호</th>
			<td><input type="text" id="bno" class="form-control"></td>
		</tr>
		<tr>
			<th>글 내용</th>
			<td><input type="text" id="reply" class="form-control"></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<button id="addReply" class="btn btn-primary">등록</button>
			</td>
		</tr>
	</table>

	<table class="table">
		<thead>
			<tr>
				<th>댓글 번호</th>
				<th>댓글 내용</th>
				<th>작성자</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
		
		</tbody>
	</table>

</div>
<script>
	const logId = "${logId}";
</script>
<script src="js/service.js"></script>
<script src="js/ajax2.js"></script>
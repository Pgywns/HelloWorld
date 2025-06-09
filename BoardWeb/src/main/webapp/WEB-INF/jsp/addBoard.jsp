<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../include/header.jsp"/>
	<h3>글 등록</h3>
    <form action="addBoard.do" method="post">
        <table class="table">
            <tr>
                <th>제목</th>
                <td><input type="text" required name="title"></td>
            </tr>
            <tr>
                <th>내용</th>
                <td><input type="text" required name="content"></td>
            </tr>
            <tr>
                <th>작성자</th>
                <td><input type="text" required name="writer"></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="등록">
                    <input type="reset" value="취소">
                </td>
            </tr>
        </table>
    </form>
<jsp:include page="../include/footer.jsp"/>
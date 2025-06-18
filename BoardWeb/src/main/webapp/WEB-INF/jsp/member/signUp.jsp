<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<h3>회원가입(signUp.jsp)</h3>
<form name="signForm" action="signUp.do" method="post" enctype="multipart/form-data">
  <table class="table">
    <tr>
      <th>아이디</th>
      <td><input class="form-control" type="text" name="userId"></td>
    </tr>
    <tr>
      <th>비밀번호</th>
      <td><input class="form-control" type="password" name="userPw"></td>
    </tr>
    <tr>
      <th>이름</th>
      <td><input class="form-control" type="text" name="userName"></td>
    </tr>
    <tr>
      <th>이미지</th>
      <td><input class="form-control" type="file" name="userImg"></td>
    </tr>
    <tr>
      <td colspan="2" align="center">
        <input type="submit" class="btn btn-primary" value="회원가입">
        <input type="reset" class="btn btn-secondary" value="초기화">
      </td>
  </table>
</form>

<script>
	let check = false;
	// document.form
	document.forms.signForm.addEventListener('submit', function(e) {
		if (!check) {
			e.preventDefault();
			alert("입력 값을 확인하세요");
			return;
		}
		
		this.submit();
	})
	
	document.querySelector('input[name="userId"]').addEventListener('change', function() {
		let user = this.value;
		fetch('checkId.do?id=' + user)
		.then(data => data.json())
		.then(result => {
			if (result.retCode == 'Exist') {
				alert("존재하는 아이디입니다.");
				document.querySelector('input[name="userId"]').focus();
				document.querySelector('input[name="userId"]').value = "";
			} else {
				alert("사용 가능한 아이디입니다.");
				check = true;
			}
		})
	})
	
	document.querySelector('input[name="userPw"]').addEventListener('change', function() {
		let pw = this.value;
		
		if (pw.length < 4) {
			alert("비밀번호는 4자리 이상으로 입력하세요!");
			document.querySelector('input[name="userPw"]').focus();
			document.querySelector('input[name="userPw"]').value = "";
		} else {
			alert("사용 가능한 비밀번호입니다.");
			check = true;
		}
		
	})
</script>
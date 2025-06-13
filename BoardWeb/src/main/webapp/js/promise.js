/**
 * promise.js
 */
// Promis 객체 역할
// 비동기 방식의 처리를 동기 방식의 순서로 처리



// 목록
fetch('replyList.do?bno=213')
	.then(function(data) {
		console.log(data); // response 결과
		return data.json(); // json -> object
	})
	.then(function(result) {
		console.log(result);
		result.forEach(function(item) {
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		}); // 댓글수만큼 tr 생성
	})
	.catch(function(err) {
		console.log(err);
	}); 

document.querySelector('#addReply').addEventListener('click', addReplyFnc);
// 등록
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	
	// 필수입력
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	
	fetch('addReply.do', { // post 형식은 전달될 내용이 많거나 파일을 업로드할 때 사용함
		method: 'post',
		headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
		body: 'bno=' + bno + '&reply=' + reply + '&replyer=' + logId
	})
		.then(json => json.json())
		.then(data => {
			if (data.retCode == 'Success') {
				alert('등록 성공!');
				let tr = makeRow(data.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록 실패');
			}
		})
		.catch(err => console.error(err))
}	
	
// 삭제
function deleteReplyFnc(e) {
	if (!confirm("삭제하시겠습니까?")) {
		return;
	}
	let rno = e.target.parentElement.parentElement.dataset.rno;
	
	// ajax
	fetch('removeReply.do?rno=' + rno)
		.then(json => json.json())
		.then(data => {
			if (data.retCode == 'Success') {
				alert('삭제 성공!');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('삭제 실패');
			}
		})
		.catch(err => console.error(err))
}
	
// row 생성
function makeRow(item) {
	let tr = document.createElement('tr');
	tr.setAttribute('data-rno', item.replyNo);
	
	// 글 번호, 내용, 작성자
	for (let prop of ['replyNo', 'reply', 'replyer']) {
		let td = document.createElement('td');
		td.innerHTML = item[prop]; // item['replyNo']
		tr.appendChild(td);			
	}
	
	// button
	let td = document.createElement('td');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteReplyFnc);
	btn.innerHTML = '삭제';
	btn.className = "btn btn-danger";
	td.appendChild(btn);
	tr.appendChild(td);
	
	return tr;
}


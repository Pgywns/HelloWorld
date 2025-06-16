/**
 * service.js
 */

// svc 객체의 add메소드
const svc = {
	add: function(num1 = 0, num2 = 0) {
		return num1 + num2;
	},
	
	// 목록 출력 메소드
	replyList(param = { bno, page }, successCallback, errorCallback) {
		// ajax 호출
		fetch('replyList.do?bno=' + param.bno + '&page=' + param.page)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	
	// 댓글 삭제 메소드
	removeReply(rno, successCallback, errorCallback) {
		fetch('removeReply.do?rno=' + rno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	
	// 댓글 등록 메소드
	addReply(param = { bno, reply, replyer }, successCallback, errorCallback) {
		fetch('addReply.do',{
			method: 'post',
			headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
			body: 'bno=' + param.bno + '&reply=' + param.reply + '&replyer=' + param.replyer
		})
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	},
	
	replyCount(bno, successCallback, errorCallback) {
		// ajax
		fetch('replyCount.do?bno=' + bno)
			.then(data => data.json())
			.then(successCallback)
			.catch(errorCallback)
	}
}

const add = (num1, num2) => {
	return num1 + num2;
}

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

function deleteReplyFnc() {
	
}
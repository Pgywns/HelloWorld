/**
 * reply.js 
 */
let page = 1;

Date.prototype.format = function() {
	let yyyy = this.getFullYear();
	let MM = this.getMonth() + 1;
	let dd = this.getDate();
	let hh = this.getHours();
	let mm = this.getMinutes();
	let ss = this.getSeconds();
	
	return yyyy + '-' + ('0' + MM).slice(-2) + '-' + ('0' + dd).slice(-2) + ' ' + ('0' + hh).slice(-2) + ':' + ('0' + mm).slice(-2) + ':' + ('0' + ss).slice(-2);
}

// 글 목록 출력
showReplyList();
function showReplyList() {
	document.querySelector('#target').innerHTML = "";
	
	svc.replyCount(bno
			, result => {
				let totalCnt = result.totalCnt;
				let realEnd = Math.ceil(totalCnt / 5);
			
				page = page > realEnd && realEnd != 0 ? realEnd : page;
				
				svc.replyList({ bno, page }
						, result => { // 성공 콜백함수
							let ul = document.querySelector('#target');
							let template = document.querySelector('#target li');

							for (let reply of result) {
								template = makeTemplate(reply);
								
								ul.insertAdjacentHTML("beforeend", template);
							}
							
							// 댓글페이지
							showPageList();
						}
						, err => console.log(err)	
					);
			}
			,err => console.log(err)
	);
}
// 이벤트
// 1) 댓글 등록 이벤트
document.querySelector('#addReply').addEventListener('click', addReplyHandler);
// 2) 댓글 링크 이벤트 등록
function pagingEvent() {
	document.querySelectorAll('.footer nav a').forEach(function(tag, idx) {
		tag.addEventListener('click', function(e) {
		page = e.target.dataset.page;
		showReplyList();
		});
	});	
	document.querySelectorAll('#target li').forEach(elem => {
		elem.addEventListener('mouseover', () => { elem.style.background = 'gray' });
		elem.addEventListener('mouseout', () => { elem.style.background = '' });
	});
}

// 댓글 등록 이벤트핸들러
function addReplyHandler(e) {
	let reply = document.querySelector('#reply').value;
	if (!logId || !reply) {
		alert('값을 확인하세요!');
		return;
	}
	// 댓글 등록
	svc.addReply({bno, reply, replyer: logId}
		, result => {
			let ul = document.querySelector('#target');
			
			if (result.retCode == "Success") {
				let rval = result.retVal;
				
				//ul.insertAdjacentHTML("afterbegin", makeTemplate(rval));
				page = 1;
				showReplyList();
				document.querySelector('#reply').value = "";
				alert("등록 성공");			
			}
		}
		, err => console.log(err)
	);
}

// 댓글 페이징 출력
function showPageList() {
	svc.replyCount(bno
		, result => {
			let totalCnt = result.totalCnt;
			let start, end;
			let prev, next;
			let realEnd = Math.ceil(totalCnt / 5);
			
			end = Math.ceil(page / 10) * 10;
			start = end - 9;
			end = end > realEnd ? realEnd : end;
			prev = start > 1;
			next = end < realEnd;	
			
			// 기존 페이징 clear
			document.querySelector('nav ul.pagination-sm').innerHTML = "";
			
			// 페이지목록 출력
			let target = document.querySelector('nav ul.pagination-sm');
			
			// 이전 페이지
			let str;
			if (prev) {
				str = `<li class="page-item">
					     <a class="page-link" href="#" data-page="${start - 1}">Previous</a>
					   </li>`;
			} else {
				str = `<li class="page-item disabled">
					     <span class="page-link" href="#">Previous</span>
					   </li>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			
			// 페이징
			for (let p = start; p <= end; p++) {
				if (p == page) {
					str = `<li class="page-item active" aria-current="page">
							 <span class="page-link" href="#">${p}</span>
						   </li>`;
				} else {
					str = `<li class="page-item">
						     <a class="page-link" href="#" data-page="${p}">${p}</a>
						   </li>`;
				}
				target.insertAdjacentHTML('beforeend', str);
			}
			
			// 이후 페이지
			if (next) {
				str = `<li class="page-item">
					     <a class="page-link" href="#" data-page="${end + 1}">Next</a>
					   </li>`;
			} else {
				str = `<li class="page-item disabled">
					     <span class="page-link" href="#">Next</span>
					   </li>`;
			}
			target.insertAdjacentHTML('beforeend', str);
			
			// 생성한 a태그에 이벤트 등록
			pagingEvent();
		}
		, err => console.log(err)
		
	);
}

// 댓글 화면 출력
function makeTemplate(reply = {}) {
	let rdate = new Date(reply.replyDate).format();
	template = `
		<li data-rno=${reply.replyNo}>
			<span class="col-sm-2">${reply.replyNo}</span>
			<span class="col-sm-4">${reply.reply}</span>
			<span class="col-sm-2">${reply.replyer}</span>
			<span class="col-sm-2">${rdate}</span>
			<span class="col-sm-1"><button onclick="deleteReply(event)" class="btn btn-danger">삭제</button></span>
		</li>`;
	
	return template; // li 반환
}

// 댓글 삭제 함수
async function deleteReply(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	let data = await fetch('replyInfo.do?rno=' + rno);
	
	let result = await data.json();
	if (result.replyer != logId) {
		alert('권한없음!');
		return;
	}
	
	// 권한이 있을경우 삭제
	svc.removeReply(rno
		, result => {
			if (result.retCode == 'Success') {
				//e.target.parentElement.parentElement.remove();
				alert("삭제 성공");
				showReplyList();
			} else {
				alert("처리 실패!");
			}
		}
		, err => console.log(err)
	);
}
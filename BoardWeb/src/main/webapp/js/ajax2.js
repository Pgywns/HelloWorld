/**
 * ajax2
 */
console.log(svc.add(10, 20))

// 목록 출력 메소드
svc.replyList(221, // 게시글 번호
	function(result){ // 성공 콜백함수
		result.forEach(function(item) {
			let tr = makeRow(item);
			document.querySelector('table:nth-of-type(2) tbody').appendChild(tr);
		}); // 댓글수만큼 tr 생성`
	},
	function(err){ // 실패 콜백함수
		console.error(err);
	})

document.querySelector('#addReply').addEventListener('click', addReplyFnc);
function addReplyFnc(e) {
	const bno = document.querySelector('#bno').value;
	const reply = document.querySelector('#reply').value;
	
	// 필수입력
	if (!bno || !reply || !logId) {
		alert('필수값 입력!');
		return;
	}
	
	svc.addReply({ bno, reply, replyer: logId },
		function(result) {
			if (result.retCode == 'Success') {
				alert('등록 성공!');
				let tr = makeRow(result.retVal);
				let target = document.querySelector('table:nth-of-type(2) tbody tr');
				document.querySelector('table:nth-of-type(2) tbody').insertBefore(tr, target);
			} else {
				alert('등록 실패');
			}
		},
		function(err) {
			console.error(err);
		})
}
	
// 삭제 함수
function deleteReplyFnc(e) {
	let rno = e.target.parentElement.parentElement.dataset.rno;
	svc.removeReply(rno,
		function(result) {
			if (result.retCode == 'Success') {
				alert('삭제 성공!');
				e.target.parentElement.parentElement.remove();
			} else {
				alert('삭제 실패');
			}
		},
		function(err) {
			console.error(err);
		}
	)
}
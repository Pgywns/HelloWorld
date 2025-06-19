import { makeRow, url } from './covid_module.js';

// document.querySelector('#centerList').innerHTML = "Hello";

// 변수선언
let centerAry;

fetch(url)
	.then(data => data.json())
	.then(result => {
		centerAry = result.data;
		// 시, 도 정보 배열
		let sidoAry = [];
		
		// tr>td*2
		// #centerList
		centerAry.forEach((center, idx) => {
			// sidoAry에 중복하지 않고 담기
			if (sidoAry.indexOf(center.sido) == -1) {
				sidoAry.push(center.sido); // 추가
			}
			if (idx < 10) {
				let tr = makeRow(center)
				document.querySelector('#centerList').appendChild(tr);
			}
		})
		
		// sidoAry의 갯수만큼 옵션 추가
		sidoAry.forEach(sido => {
			let opt = document.createElement('option');
			opt.value = sido;
			opt.innerHTML = sido;
			document.getElementById('sido').appendChild(opt);		
		})
	})
	.catch(err => console.log(err))

// event
document.querySelector('button.btn-primary').addEventListener('click', function() {
	// 목록지우기
	document.querySelector('#centerList').innerHTML = "";
	let keyword = document.getElementById('centerName').value;
	
	centerAry
		//.filter(center => center.centerName.indexOf(keyword) != -1)
		.filter(center => center.centerName.includes(keyword))
		.forEach(center => {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);
		})
});

// select 태그의 change 이벤트
document.querySelector('#sido').addEventListener('change', function() {
	document.querySelector('#centerList').innerHTML = "";
	let keyword = document.getElementById('sido').value;
	
	centerAry.reduce((acc, center) => {
		if (center.sido == keyword) {
			let tr = makeRow(center);
			document.querySelector('#centerList').appendChild(tr);
		}
		return acc;
	}, document.querySelector('#centerList'));
		//.filter(center => center.sido == keyword)
		//.forEach(center => {
		//	let tr = makeRow(center);
		//	document.querySelector('#centerList').appendChild(tr);
		//})
});

// [].push(), [].unshift(), [].pop, [].shift() => [].splice()
// reduce();

/* let result = [1, 3, 5, 7].reduce(function(acc, elem, idx, ary) {
	console.log(acc, elem);
	if (elem > 4) {
		let li = document.createElement('li');
		li.innerHTML = elem;
		acc.appendChild(li);
	}
	return acc;
}, document.querySelector('#target'));
console.log('결과: ', result); */

/**
 * 
 */
let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&serviceKey=o8IL1InBu0%2Fyvvsw7nH66QwyjCvH0Rid1OzPhrzCJeuc6Uh4wSAk0euiCQ%2BBYzbYFgYkt%2BxFeD%2BLbKaYl2iRAw%3D%3D`;

function makeRow(center) {
	let tr = document.createElement('tr');
	for (const prop of ['id', 'centerName', 'phoneNumber']) {
		let td = document.createElement('td');
		td.innerHTML = center[prop];
		tr.appendChild(td);
	}
	return tr;
}

export { url, makeRow }
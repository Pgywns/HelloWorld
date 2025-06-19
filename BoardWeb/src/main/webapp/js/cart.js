/**
 * cart.js
 */
// 장바구니 상품.
const cartItems = [{
	itemId: 1,
	itemName: "상품1",
	price: 2500,
	qty: 3,
	image: 'basket1.jpg'
}, {
	itemId: 2,
	itemName: "상품2",
	price: 3500,
	qty: 2,
	image: 'basket2.jpg'
}, {
	itemId: 3,
	itemName: "상품3",
	price: 4500,
	qty: 1,
	image: 'basket3.jpg'
}]

const basket = {
	// 장바구니 수량 변경.
	changePNum(e) {
		let elem = e.target;
		let subdiv = elem.closest('div.subdiv'); // 이벤트가 발생한 곳에 부모요소 중에서 class가 subdiv인 div
		let inputElem = subdiv.querySelector('input[name="p_num1"]'); // subdiv에 input태그 (수량)
		let currentQty = parseInt(inputElem.value); // 현재 수량
		let itemPrice = subdiv.querySelector('input[name="p_price"]').value; // 이벤트가 발생한 상품의 가격

		if (elem.classList.contains('up')) { // elem의 클래스 중에서 up이 있는 클래스
			currentQty++; // 수량 증가
		} else if (elem.classList.contains('down')) { 
			if (!(currentQty - 1)) { // 수량이 1일 때는 수량 감소 불가
				return;
			}
			currentQty--;
		}
		inputElem.value = currentQty; // 증감시킨 현재 수량을 input의 value에 적용
		subdiv.querySelector('div.sum').innerText = currentQty * itemPrice + "원"; // subdiv에서 class가 sum인 div의 텍스트를 현재 수량 * 상품의 가격으로 설정
		
		this.allItem(); // 총 합계 결과
	},
	// 상품삭제.
	delItem(e) {
		if (confirm("상품을 삭제하시겠습니까?")) {
			let elem = e.target;
			elem.closest('div.data').remove();
		}
		this.allItem();
	},
	// 선택상품삭제.
	delCheckedItem() {
		if (confirm("선택한 상품을 삭제하시겠습니까?")) {
			let data = document.querySelectorAll('.check input');
			data.forEach(result => {
				if (result.checked) {
					result.closest('div.data').remove();
				}
			})
		}
		this.allItem();
	},
	// 장바구니 비우기.
	delAllItem() {
		if (confirm("장바구니를 비우시겠습니까?")) {
			let data = document.querySelectorAll('.data');
			data.forEach(result => {
				result.remove();
			})			
		} else {
			return;
		}
		this.allItem();
	},
	
	allItem() {
		let sumQty = 0, sumPrice = 0;
		document.querySelectorAll('div.data input[name="p_num1"]').forEach(item => {
			sumQty += parseInt(item.value);
		})
		document.querySelectorAll('div.data div.sum').forEach(item => {
			sumPrice += parseInt(item.innerText.substring(0, item.innerText.length - 1));
		})
		document.querySelector('div.sumcount>span').innerText = sumQty;
		document.querySelector('div.summoney>span').innerText = sumPrice;
	}
}

cartItems.forEach(item => {
	const template = `
	<div class="row data" data-id=${item.itemId}>
		<div class="subdiv">
	        <div class="check"><input type="checkbox" name="buy" value="260" checked="false">&nbsp;</div>
	        <div class="img"><img src="./images/${item.image}" width="60"></div>
	        <div class="pname"> <span>${item.itemName}</span> </div>
	    </div>
	    <div class="subdiv">
	        <div class="basketprice">
	            <input type="hidden" name="p_price" id="p_price1" class="p_price" value="${item.price}">${item.price}원
	        </div>
	        <div class="num">
	            <div class="updown">
	                <input type="text" name="p_num1" id="p_num1" size="2" maxlength="4" class="p_num" value=${item.qty}
	                    onkeyup="javascript:basket.changePNum(event);">
	                <span onclick="javascript:basket.changePNum(event);">
	                    <i class="fas fa-arrow-alt-circle-up up"></i> </span>
	                <span onclick="javascript:basket.changePNum(event);">
	                    <i class="fas fa-arrow-alt-circle-down down"></i> </span>
	            </div>
	        </div>
	        <div class="sum">${item.price * item.qty}원</div>
	    </div>
	    <div class="subdiv">
	        <div class="basketcmd">
	            <a href="javascript:void(0)" class="abutton" onclick="javascript:basket.delItem(event);">삭제</a>
	        </div>
	    </div>
	</div>`;
		
	document.querySelector('#basket').insertAdjacentHTML('beforeend', template);
});

basket.allItem();
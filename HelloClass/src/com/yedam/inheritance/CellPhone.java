package com.yedam.inheritance;

/*
 	부모: CellPhone
 		- 전원켜기, 전원끄기, 통화, 볼륨Up, 볼륨Down
 		- Model, Color
 	자식: SmartPhone
 		- TV 보기
*/

// extends Object가 생략되어 있어서 Object가 가지고 있는 것들을 물려받음
public class CellPhone {
	String model;
	String color;
	
	// 생성자
	public CellPhone(String model, String color) {
		this.model = model;
		this.color = color;
	}
	
	// 메소드
	void powerOn() {
		System.out.println("전원을 켜기.");
	}
	
	void powerOff() {
		System.out.println("전원을 끄기");
	}
	
	void 통화하기() {
		System.out.println("통화하다.");
	}

	// toString() 오버라이딩
	@Override
	public String toString() {
		return "CellPhone [model=" + model + ", color=" + color + "]";
	}
		
} // CellPhone

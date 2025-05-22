package com.yedam.inheritance;

/*
 * 부모클래스: Animal(추상) 
 */

public class Bird extends Animal {

	@Override
	public void sound() {
		// 부모클래스에 추상메소드가 있기 때문에 자식클래스에서 반드시 재정의(overriding)를 해야 함
		System.out.println("짹짹");
	}
	
}

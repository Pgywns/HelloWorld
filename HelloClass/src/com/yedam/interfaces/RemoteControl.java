package com.yedam.interfaces;

/*
 * 인터페이스: 필드(상수) 
 */

public interface RemoteControl {
	public int MAX_VOLUME = 10;
	
	// 추상메소드
	// 인터페이스에는 abstract가 없어도 추상메소드
	public void turnOn();
	public void turnOff();
}

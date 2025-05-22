package com.yedam.interfaces;

public class InterfaceExe {
	public static void main(String[] args) {
		final int num = 10;
		
		RemoteControl rc = new Television();
		rc.turnOn();
		rc.turnOff();
		
		rc = new Radio();
		rc.turnOn();
		rc.turnOff();
		
	} // main
}

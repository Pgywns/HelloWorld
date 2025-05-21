package com.yedam.inheritance;

public class PhoneExe {
	
	public static void main(String[] args) {
		// 부모클래스
		CellPhone phone1 = new CellPhone("IT203", "red"); // CellPhone 인스턴스
//		phone1.model = "IT203";
//		phone1.color = "red";
		phone1.powerOn();
		phone1.powerOff();
		System.out.println(phone1.toString());
		
		// 자식클래스
		CellPhone phone2 = new SmartPhone("S21", "white", 5); // SmartPhone 인스턴스
//		phone2.model = "S21";
//		phone2.color = "white";
		phone2.powerOn();
		phone2.powerOff();
		System.out.println(phone2.toString());
			
		SmartPhone phone3 = null;
		
		phone2 = phone1;
		
		if (phone2 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone2; // Casting 강제 형변환
			phone3.channel = 3;
			phone3.watch();			
		}
		
		// instanceof 메소드로 변환 가능한지 체크
		if (phone1 instanceof SmartPhone) {
			phone3 = (SmartPhone) phone1;
			phone3.channel = 5;
			phone3.watch();			
		}
		
	} // main
	
} // class

package com.yedam.api;

public class WrapperExe {
	
	public static void main(String[] args) {
		int num = 10;
		
//		Integer num2 = 20; 이렇게 써도 무방함
		Integer num2 = new Integer(20);
		
		num = num2.intValue();
		
		String str = "10";
		num = Integer.parseInt(str);
		
		double num3 = Double.parseDouble(str);
		num3 = Float.parseFloat(str);
		
		Integer num4 = new Integer(10); // 기본타입 -> 참조타입 (Boxing)
		Integer num5 = new Integer(10); // 참조타입 -> 기본타입 (unBoxing)
		
		System.out.println(num4.intValue() == num5.intValue());
		
	} // main

}

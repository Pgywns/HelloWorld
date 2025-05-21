package com.yedam.ref;

// 실행 클래스
public class CalculatorExe {
	public static void main(String[] args) {
		int a = 20, b = 30;
		
		System.out.println(Calculator.sum(a, b));
		
//		CalculatorExe ce = new CalculatorExe();
//		ce.printStar();
		
		CalculatorExe.printStar();
		
	}
	
	static void printStar() {
		System.out.println("*");
	}
}

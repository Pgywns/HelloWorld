package com.yedam;

import java.util.Scanner;

public class JSExe {

	public static void main(String[] args) {
		int num1 = 30;
		int num2 = 30;

//		System.out.println(num1 == num2);

		String str1 = new String("Hello"); // 원래 방법
		String str2 = new String("Hello");

//		System.out.println(str1);
//		System.out.println(str2);

//		System.out.println(str1.equals(str2));

//		test2();
		// test3();
//		test4();
		test5();
	} // main

	public static void test5() {
		// printf("형식문자열", 값1, 값2...)
		System.out.printf("%s %d %f, %s", "문자", 30, 20.3, "\n");
		
		// "홍길동", 100, 23.9
		System.out.printf("%s %d %.1f %s", "홍길동", 100, 23.9, "\n");
		
		System.out.printf("안녕하세요. %s입니다.\n나이는 %d입니다.\n몸무게는 %.1f입니다.", "박효준", 28, 63.8);

	}
	
	public static void test4() {
		Scanner scn = new Scanner(System.in);
		String name = "";
		while (true) {
			System.out.print("메세지를 입력하세요. 종료하려면 quit>> ");
			String msg = scn.nextLine();
			
			if (name.equals("")) {
				name += msg;
			} else if (msg.equals("quit")) {
				name += " 입니다.";
				System.out.println("종료합니다.");
				break;
			} else {
				name += ", " + msg;
			}
			
			System.out.println("입력한 값은: " + msg);
		}
		System.out.println("친구목록은 " + name);
	} // test4
	
	public static void test3() {
		Scanner scn = new Scanner(System.in);
		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			System.out.println("학생의 점수를 입력>>");
			String value = scn.nextLine();
			int score = Integer.parseInt(value);
			sum += score;
		}
		double avg = sum / 3.0;
		avg = Math.round(avg * 100) / 100.0;
		System.out.println("합계: " + sum + ", 평균: " + avg);
	} // test3
	
	
	public static void test2() {
		// 임의의 수를 생성 (30 ~ 100사이의 임의의 값)
		int sum = 0;
		for (int i = 1; i <= 7; i++) {
			int result = (int) (Math.random() * 71) + 30;
			sum += result;
		}
		double avg = sum / 7.0;
		System.out.println("결과: " + sum);
		System.out.println("결과: " + Math.round(avg * 100) / 100.0);
		System.out.println("결과: " + String.format("%.3f", avg / 5));
	} // test2
	
	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("test: " + sum);
	} // test
	
}

package com.yedam.operator;

import java.util.Scanner;

public class OperatorExe {

	public static void main(String[] args) {
		test5();
	} // main

	public static void test5() {
		String pass = "";
		
		int score = (int) (Math.random() * 100);
		pass = (score >= 60) ? ((score >= 80) ? "우수" : "합격") : ((score < 20) ? "노답" : "불합격");
		
		System.out.printf("%d점은 %s입니다.", score, pass);
	}
	
	// "월" 정보를 입력하면 "공란" 반환하는 메소드. getSpace
	public static int getSpace(int month) {
		int space = 6;

		if (month == 1) {
			space = 3;
		} else if (month == 4) {
			space = 2;
		} else if (month == 5) {
			space = 4;
		} else if (month == 7) {
			space = 2;
		} else if (month == 6) {
			space = 0;
		} else if (month == 8) {
			space = 5;
		} else if (month == 9) {
			space = 1;
		} else if (month == 10) {
			space = 3;
		} else if (month == 12) {
			space = 1;
		}

		return space;
	} // getSpace

	// "월" 정보를 입력하면 말일을 알려주는 메소드 getLastDate(월)
	public static int getLastDate(int month) {
		int lastDate = 31;
		
		switch (month) {
		case 2:
			lastDate = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			lastDate = 30;
			break;
		}

		return lastDate;
	}

	public static void test4() {

		Scanner scn = new Scanner(System.in);
		
		System.out.print("월을 입력하세요: ");
		int mon = Integer.parseInt(scn.nextLine());
		
		System.out.printf("             %d월              \n", mon);
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		// 빈공간
		int space = getSpace(mon);
		int lastDate = getLastDate(mon);

		for (int s = 1; s <= space; s++) {
			System.out.printf("%4s", " ");
		}

		// 날짜출력
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day);
			if ((day + space) % 7 == 0) {
				System.out.println("");
			}
		}

	}

	public static void test3() {
		boolean isTrue = true;
		for (int i = 1; i <= 10; i++) {
			if (isTrue) {
				System.out.printf("i의 값은 %d\n", i);
			}
			isTrue = !isTrue; // 토글(on -> off, off -> on)
		}
	}

	public static void test2() {
		int num1 = 10;
		int num2 = 20;

		int result = ++num1 + num2++;

		System.out.printf("num1 => %d, num2 => %d, result => %d\n", num1, num2, result);

		boolean isTrue = true;

		if (isTrue) {
			System.out.println("참 입니다.");
		}

		// == 부정은 !=, > 부정은 <=, >= 부정은 <
		if (!(result >= 30)) {
			System.out.println("result는 30보다 작다");
		}

		if (!(--num1 > 10 || num2 < 20)) {
			System.out.printf("num1 =? %d", num1);
		}
	}

	// 연습 2. bye, short, long, int, char
	public static void test1() {
		byte num1 = 10;
		byte num2 = 20;
		byte sum = (byte) (num1 + num2); // 정수 연산의 기본은 int

		System.out.println(sum);

		long num3 = 10000000000L;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(num3);

	}

	// 연습 1.
	public static void test() {
		// 증가, 감소 연산자 (++, --)
		byte num1 = -128; // -128 ~ 127
		num1 = 127;
		num1++;
		System.out.println(num1);

		char ch1 = 'A';
		ch1 = 66;
		ch1 = '가';
		ch1 = 'A';
		for (int i = 1; i <= 26; i++) {
			System.out.print(ch1++);
		}
	} // test
}

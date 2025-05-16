package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe1 {
	public static void main(String[] args) {
		// Math.random 활용해서 10 ~ 100 사이의 정수를 생성.
		// 학생 10명의 점수를 생성해서 학생 점수의 평균을 구하고 최고 점수 구하기.
		int[] scoreAry = new int[10];
		int sum = 0;
		double avg = 0;
		int max = 0;
		
		for (int i = 0; i < scoreAry.length; i++) {
			scoreAry[i] = (int)(Math.random() * 91) + 10;
			sum += scoreAry[i];
			
			if (max < scoreAry[i]) {
				max = scoreAry[i];				
			}
			
			System.out.println(scoreAry[i]);
		}
		
		avg = (sum * 1.0) / scoreAry.length;
		
		System.out.printf("합: %d, 평균: %.1f, 최고 점수: %d", sum, avg, max);
		
		
//		test8();

	} // main

	public static void test1() {

		while (true) {
			int dice1 = (int) (Math.random() * 6) + 1;
			int dice2 = (int) (Math.random() * 6) + 1;

			System.out.printf("주사위1 : %d, 주사위2 : %d\n", dice1, dice2);

			if (dice1 + dice2 == 5) {
				break;
			}
		}
	} // test1

	public static void test2() {

		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if ((4 * x) + (5 * y) == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
	} // test2

	public static void test3() {
		String star = "";

		for (int i = 0; i < 5; i++) {
			star += "*";
			System.out.println(star);
		}
	} // test3

	public static void test4() {
		String star = "";

		for (int i = 0; i < 5; i++) {
			star += "*";
			System.out.printf("%5s\n", star);
		}
	} // test4

	public static void test5() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (j <= i) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	} // test5

	public static void test6() {
		for (int i = 0; i <= 4; i++) {
			for (int j = 0; j <= 4; j++) {
				if ((j + i) >= 4) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	} // test6

	public static void test7() {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				if ((j + i) >= 5) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	} // test7

	public static void test8() {
		Scanner scn = new Scanner(System.in);
		System.out.print("숫자를 입력하세요: ");
		int num = Integer.parseInt(scn.nextLine());

		for (int i = 0; i <= num; i++) {
			for (int j = 0; j <= num; j++) {
				if ((j + i) >= num) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	} // test8

	public static void test9() {
		int[] intAry = { 10, 17, 22, 31, 55, 24 };
		int temp = 0;

		for (int j = 0; j < intAry.length - 1; j++) {
			for (int i = 0; i < intAry.length - 1; i++) {
				if (intAry[i] < intAry[i + 1]) {
					temp = intAry[i];
					intAry[i] = intAry[i + 1];
					intAry[i + 1] = temp;
				}
			}
		}

		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
		}
	} // test9

}

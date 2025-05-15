package com.yedam.condition;

import java.util.Scanner;

public class IfExe {

	public static void main(String[] args) {
		// 1 ~ 1000 사이의 임의의 값을 생성.
		// 500 입력하면 "입력값보다 큽니다"
		Scanner scn = new Scanner(System.in);
		int randomValue = (int)(Math.random() * 1000) + 1; 
		int count = 0;
		
		while(true) {
			System.out.print("1 ~ 1000 사이의 값을 입력해주세요: ");
			int result = Integer.parseInt(scn.nextLine());
			count++;
			
			if (randomValue == result) {
				System.out.print("정답입니다.");
				
				if (count <= 5) {
					System.out.printf("%d번만에 정답! 똑똑하시군요!\n", count);
				} else if (count <= 10) {
					System.out.printf("%d번만에 정답! 아쉽네요!\n", count);
				} else {
					System.out.printf("%d번만에 정답! 분발하세요!\n", count);
				}
				
				break;
				
			} else if (randomValue > result){
				System.out.println("더 큰 수입니다.");
				
			} else if (randomValue < result){
				System.out.println("더 작은 수입니다.");
			}
			
		} // while
	}

	public static void test() {
		int score = 83;

		// if
		if (score >= 90) {
			System.out.println("A학점");
		} else if (score >= 80) {
			System.out.println("B학점");
		} else if (score >= 70) {
			System.out.println("C학점");
		} else {
			System.out.println("불합격");
		}

		// switch ~ case
		score = score / 10;
		switch (score) {
		case 10:
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		default:
			System.out.println("불합격");
		}
	} // test

}

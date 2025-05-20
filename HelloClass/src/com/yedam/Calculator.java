package com.yedam;

import com.yedam.member.Member;

/*
	1) 메소드의 선언
	2) 매개변수
	3) 반환유형
*/
public class Calculator {
	// 필드
	// 생성자
	// 메소드

	String printStar(int times, String shape) {
		String str = "";
		for (int i = 1; i <= times; i++) {
			str += shape + "\n";
		}
		return str;
	} // printStar

	// 메소드 오버로딩
	int add(int num1, int num2) {
		return num1 + num2;
	}

	double add(double num1, double num2) {
		return num1 + num2;
	}

	double add(int[] ary) {
		double sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}

		return sum;
	}

	Member getMaxPoint(Member[] memberArray) {
		Member max = null;
		int maxPoint = 0;
		for (int i = 0; i < memberArray.length; i++) {
			Member temp = memberArray[i];
			if (maxPoint < temp.getPoint()) {
				maxPoint = temp.getPoint();
				max = temp;
			}
		}

		return max;
	}
}

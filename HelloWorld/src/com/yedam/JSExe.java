package com.yedam;

public class JSExe {
	public static void main(String[] args) {

	} // main

	public static void test() {
		int sum = 0;
		// 1 ~ 10 까지의 누적
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println(sum);
	} // test

	public static void test2() {
		// 임의의 수를 생성 (1 ~ 100사이의 임의의 값)
		// 1 <= x < 11
		int sum = 0;
		for (int i = 1; i <= 5; i++) {
			int result = (int) (Math.random() * 100) + 1;
			System.out.println(result);
			sum += result;
		}

		System.out.println(sum);
	} // test2
}

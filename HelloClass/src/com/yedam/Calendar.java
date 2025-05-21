package com.yedam;

public class Calendar {
	
	public static void showMonth() {
		// Sun Mon Tue Wed Thu Fri Sat
		// ===========================
		//                   1   2   3 ...
		int space = 4;
		int lastDate = 31;
		
		System.out.println("         2025년 05월");
		System.out.println("============================");
		System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
		System.out.println("============================");
		
		// 시작 요일 전에는 공백을 출력
		for (int i = 1; i <= space; i++) {
			System.out.printf("%4s", " ");
		}
		
		// 날짜 출력
		for (int day = 1; day <= lastDate; day++) {
			System.out.printf("%4d", day);
			
			// 일주일 기준으로 줄바꿈
			if ((day + space) % 7 == 0) {
				System.out.println(" ");
			}
		}
		
		System.out.println("----------------------------");
		
	} // showMonth
}

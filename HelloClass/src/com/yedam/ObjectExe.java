package com.yedam;

import java.util.Scanner;

public class ObjectExe {
	public static void main(String[] args) {
//		Calendar.showMonth();
		
		Scanner scn = new Scanner(System.in);
		int year = 0;
		
		while (true) {
			System.out.print("년도를 입력하세요>> ");
			String msg = scn.nextLine();
			
			try {
				year = Integer.parseInt(msg);
			} catch (NumberFormatException e) {
				
				if (msg.equals("quit")) {
					System.out.println("종료합니다.");
					break;
				}
				
				System.out.println("년도를 입력해주세요\n");
				continue;
			}
			
			if (Calendar.isLeapYear(year)) {
				System.out.printf("%d년은 윤년입니다.\n\n", year);
			} else {
				System.out.printf("%d년은 윤년이 아닙니다.\n\n", year);
			}
		} // while
			
	} // main
}

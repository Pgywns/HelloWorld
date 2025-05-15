package com.yedam.condition;

import java.util.Scanner;

public class LoopExe {

	public static void main(String[] args) {
		// "가위(1) 바위(2) 보(3), 종료(4)"
		// "You lost", "You win", "draw"
		Scanner scn = new Scanner(System.in);

		while (true) {
			int myResult = 0;
			int result = (int) (Math.random() * 3) + 1;
			
			System.out.print("입력하세요. 가위(1), 바위(2), 보(3), 종료(4): ");
			myResult = Integer.parseInt(scn.nextLine());

			if (myResult == 4) {
				System.out.println("종료하였습니다.");
				break;
			} else if (myResult < 1 || myResult > 4) {
				System.out.println("1 ~ 4까지 입력해주세요");
			} else {
				if ((myResult == 1 && result == 2) || (myResult == 2 && result == 3)
						|| (myResult == 3 && result == 1)) {
					System.out.printf("컴퓨터는 %s, 당신은 %s를 냈습니다. You Lost\n", test2(result), test2(myResult));
				} else if ((myResult == 1 && result == 3) || (myResult == 2 && result == 1)
						|| (myResult == 3 && result == 2)) {
					System.out.printf("컴퓨터는 %s, 당신은 %s를 냈습니다. You Win\n", test2(result), test2(myResult));
				} else if (myResult == result) {
					System.out.println("Draw");
				}
			}

		}

	} // main

	public static String test2(int num) {
		String str = "";
		
		switch (num) {
		case 1:
			str = "가위";
			break;
		case 2:
			str = "바위";
			break;
		case 3:
			str = "보";
			break;
		}
		
		return str;
	}
	
	public static void test() {
		// while vs. do .. while
		boolean run = false;

//		while (run) {
//			System.out.println("while문");
//			run = !run;
//		}

		do {
			System.out.println("while문");
			run = !run;
		} while (run = !run);

		System.out.println("end of prog");
	}

}

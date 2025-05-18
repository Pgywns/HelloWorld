package com.yedam.ref;

import java.util.Scanner;

public class ArrayExe {

	public static void main(String[] args) {
//		strAry();
//		deleteAry();
		friendApp();

	} // main

	public static void friendApp() {
		Scanner scn = new Scanner(System.in);
		String[] friendAry = new String[10];

		boolean run = true;
		while (run) {

			System.out.println("1.추가 2.목록 3.삭제 4.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1: // 추가
				System.out.print("이름입력>> ");
				String name = scn.nextLine();

				// 배열에 추가
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = name;
						break;
					} else {
						if (friendAry[i].equals(name)) {
							System.out.print("추가하시겠습니까? 추가(1) / 취소(2) >> ");
							int select = Integer.parseInt(scn.nextLine());
							
							if (select == 2) {
								break;
							}
						}
					}
				}
				break;

			case 2: // 목록
				if (friendAry[0] == null) {
					System.out.println("친구가 없습니다.");
				} else {
					System.out.print("현재 친구목록은 ");
					for (int i = 0; i < friendAry.length; i++) {
						if (friendAry[i] != null) {
							System.out.printf("'%s' ", friendAry[i]);
						}
					}
					System.out.println("입니다.");
				}
				break;

			case 3: // 삭제
				System.out.print("이름입력>> ");
				String delname = scn.nextLine();
				boolean result = false;
				
				// 배열에서 삭제
				for (int i = 0; i < friendAry.length; i++) {
					if (friendAry[i] != null && friendAry[i].equals(delname)) {
						friendAry[i] = null;
						result = true;
						break;
					}
				}
				
				if (!result) {
					System.out.printf("친구 목록에 '%s'가 없습니다.\n", delname);
					break;
				}
				
				for (int i = 0; i < friendAry.length - 1; i++) {
					if (friendAry[i] == null) {
						friendAry[i] = friendAry[i + 1];
						friendAry[i + 1] = null;
					}
				}
				
				break;

			case 4: // 종료
				run = false;
				break;

			default:
				System.out.println("1 ~ 4까지의 값을 입력하세요");
			}

		}
		System.out.println("end of prog");
	} // friendApp

	public static void deleteAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10];
		stringAry[0] = "홍길동";
		stringAry[1] = "이길동";
		stringAry[2] = "박길동";
		stringAry[3] = "김길동";

		System.out.print("삭제할 친구 이름>> ");
		String name = scn.nextLine();

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null && stringAry[i].equals(name)) {
				stringAry[i] = null;
			}
		}

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}

	} // deleteAry

	public static void strAry() {
		Scanner scn = new Scanner(System.in);
		String[] stringAry = new String[10]; // 입력값을 저장

		while (true) {
			System.out.print("이름을 입력 >> ");
			String name = scn.nextLine();
			if (name.equals("quit")) {
				break; // while문 종료
			}

			for (int i = 0; i < stringAry.length; i++) {
				// 빈공간(null) 이 체크
				if (stringAry[i] == null) {
					stringAry[i] = name;
					System.out.println("입력성공");
					break;
				}
			} // for

		} // while

		for (int i = 0; i < stringAry.length; i++) {
			if (stringAry[i] != null) {
				System.out.printf("stringAry[%d]번째의 값: %s\n", i, stringAry[i]);
			}
		}

		System.out.println("end of prog");
	} // strAry

}

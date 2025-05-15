package com.yedam.operator;

import java.util.Scanner;

public class ScannerExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int myMoney = 0;
		int money = 0;

		while (true) {
			System.out.print("1.입금 2.출금 3.잔액 4.종료 : ");
			int menu = Integer.parseInt(scn.nextLine());

			if (menu == 1) {
				if (myMoney >= 100000) {
					System.out.println("더 이상 입금할 수 없습니다.");
					continue;
				}

				System.out.print("입금할 금액을 입력하세요: ");
				money = Integer.parseInt(scn.nextLine());
				if ((myMoney + money) > 100000) {
					System.out.println("계좌 금액이 10만원을 초과할 수 없습니다.");
				} else {
					myMoney += money;
				}

			} else if (menu == 2) {

				if (myMoney == 0) {
					System.out.println("잔고가 없습니다.");
					continue;
				}

				System.out.print("출금할 금액을 입력하세요: ");
				money = Integer.parseInt(scn.nextLine());
				if (myMoney < money) {
					System.out.println("잔액이 부족합니다.");
				} else {
					myMoney -= money;
				}
			} else if (menu == 3) {
				System.out.printf("현재 잔액은 %d원 입니다.\n", myMoney);
			} else if (menu == 4) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("1 ~ 4까지의 값을 입력해주세요.");
			}
		} // while
		System.out.println("eop");
	} // main
}

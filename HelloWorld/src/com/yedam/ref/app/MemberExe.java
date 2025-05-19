package com.yedam.ref.app;

import java.util.Scanner;

public class MemberExe {

	public static void main(String[] args) {
		// 1) 추가
		// 아이디, 이름, 전화번호, 포인트
		// 2) 수정
		// 아이디를 기준으로 전화번호만 변경
		// 3) 삭제
		// 아이디를 기준으로 삭제 없으면 메시지 출력
		// 4) 조회
		// 이름을 기준으로 조회

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Member[] memberAry = new Member[100];
		
		while (run) {
			System.out.println("---------------------------------------------");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.조회 | 5.종료");
			System.out.println("---------------------------------------------");
			System.out.print("선택> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("아이디를 입력하세요: ");
				String memId = scn.nextLine();

				System.out.print("이름을 입력하세요: ");
				String memName = scn.nextLine();

				System.out.print("전화번호를 입력하세요: ");
				String memPhone = scn.nextLine();

				System.out.print("포인트를 입력하세요: ");
				int memPoint = Integer.parseInt(scn.nextLine());

				Member mem = new Member();
				mem.id = memId;
				mem.name = memName;
				mem.phone = memPhone;
				mem.point = memPoint;

				for (int i = 0; i < memberAry.length; i++) {
					if (memberAry[i] == null) {
						memberAry[i] = mem;
						break;
					} else if (memberAry[i].id.equals(memId)) {
						System.out.println("이미 존재하는 아이디입니다.");
						break;
					}
				}

				break;
				
			case 2:
				System.out.print("수정할 회원의 아이디를 입력하세요: ");
				String udtId = scn.nextLine();

				for (int i = 0; i < memberAry.length; i++) {
					if (udtId.equals(memberAry[i].id)) {
						System.out.print("수정할 전화번호를 입력하세요: ");
						String udtPhone = scn.nextLine();
						memberAry[i].phone = udtPhone;
						System.out.printf("%s의 전화번호가 %s로 변경되었습니다.\n", udtId, udtPhone);
						break;
					}
				}
				break;
				
			case 3:
				boolean result = false;

				System.out.print("삭제할 회원의 아이디를 입력하세요: ");
				String delId = scn.nextLine();

				for (int i = 0; i < memberAry.length; i++) {
					if (memberAry[i] != null && delId.equals(memberAry[i].id)) {
						memberAry[i] = null;
						System.out.printf("%s가 삭제되었습니다.\n", delId);
						result = true;
						break;
					}
				}

				if (!result) {
					System.out.printf("존재하지 않는 아이디입니다.\n", delId);
					break;
				}

				for (int i = 0; i < memberAry.length - 1; i++) {
					if (memberAry[i] == null) {
						memberAry[i] = memberAry[i + 1];
						memberAry[i + 1] = null;
					}
				}

				break;
				
			case 4:
				System.out.print("조회 할 회원의 이름을 입력하세요: ");
				String selName = scn.nextLine();
				
				for (int i = 0; i < memberAry.length; i++) {
					if (memberAry[i] != null && memberAry[i].name.equals(selName)) {
						System.out.printf("아이디: %s, 이름: %s, 전화번호: %s, 포인트: %d\n", memberAry[i].id, memberAry[i].name,
								memberAry[i].phone, memberAry[i].point);
					}
				}

				break;
				
			case 5:
				System.out.println("종료되었습니다.");
				run = false;
				break;
			}

		}
	} // main
}

package com.yedam.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.yedam.service.MemberService;
import com.yedam.service.MemberServiceDAO;
import com.yedam.vo.Member;

/*
 * 사용자의 입력값을 등록, 수정, 삭제, 목록
 */

public class MemberApp {
	
	public void execute() {
		Scanner scn = new Scanner(System.in);
		MemberService svc = new MemberServiceDAO();
		
		System.out.println("---------------------------------------");
		System.out.println("1.회원등록 2.정보수정 3.회원삭제 4.목록보기 5.종료");
		System.out.print("선택>> ");
		
		// 메뉴선택
		int menu = scn.nextInt(); scn.nextLine();
		
		switch (menu) {
		case 1: // 등록
			System.out.print("회원아이디>> ");
			String mid = scn.nextLine();
			
			System.out.print("회원이름>> ");
			String name = scn.nextLine();
			
			System.out.print("연락처>> ");
			String phone = scn.nextLine();
			
			System.out.print("포인트>> ");
			String point = scn.nextLine();
			
			Member member = new Member(mid, name, phone, Integer.parseInt(point));
			
			if (svc.addMember(member)) {
				System.out.println("등록완료");
			} else {
				System.out.println("등록실패");
			}
			
			break;		
		case 2:
			System.out.print("수정할 회원아이디를 입력하세요>> ");
			mid = scn.nextLine();
			
			List<Member> memlist = new ArrayList<>();
			memlist = svc.memberList();
			
			for (int i = 0; i < memlist.size(); i++) {
				if (memlist.get(i).getMemberId().equals(mid)) {
					System.out.print("연락처를 입력하세요>> ");
					phone = scn.nextLine();
					
					System.out.print("포인트를 입력하세요>> ");
					point = scn.nextLine();
					
					Member member1 = new Member();
					member1.setPhone(phone);
					member1.setPoint(Integer.parseInt(point));
					member1.setMemberId(mid);
					
					if (svc.modifyMember(member1)) {
						System.out.println("수정을 완료하였습니다.");
						break;
					} else {
						System.out.println("수정을 실패하였습니다.");
						break;
					}
					
					
				}
			}
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			if (menu == 5) {
				return;
			}
			break;
		}
	} // execute
	
}

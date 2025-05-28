package com.app;

import java.util.Scanner;

import com.service.BoardService;
import com.service.BoardServiceDAO;
import com.service.MemberService;
import com.service.MemberServiceDAO;
import com.service.ProductService;
import com.service.ProductServiceDAO;

public class MainApp {
	Scanner scn = new Scanner(System.in);

	public void execute() {
		MemberService msc = new MemberServiceDAO();
//		BoardService bsc = new BoardServiceDAO();
//		ProductService psc = new ProductServiceDAO(); 
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.로그인 2.회원가입 3.아이디 찾기 4.비밀번호 찾기 5.종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				System.out.print("아이디>> ");
				String id = scn.nextLine();

				System.out.print("비밀번호>> ");
				String pw = scn.nextLine();

				if (id.equals("1")) {
					// if (msc.logIn(id, pw).equals("admin")) {
					System.out.println("관리자 계정으로 로그인하였습니다");
					admin();
				} else {
					System.out.printf("%s님 환영합니다!\n", id);
					user();
				}
				
				run = false; // 로그인 후에 종료를 눌렀을 때 종료될 수 있게 반복문을 끝냄
				
				break;
			case 2:
				System.out.print("아이디>> ");
				String signid = scn.nextLine();

				System.out.print("비밀번호>> ");
				String signpw = scn.nextLine();
				
				
				break;
			case 3:

				break;
			case 4:

				break;
			case 5:
				
				return;
			} // switch ~ case
		} // while

	} // execute

	public void admin() {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.게시판 2.상품관리 3.재고관리 4.회원관리 5.로그아웃 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				break;

			case 5:
				execute();
			case 6:
				return;
			} // switch ~ case

		} // while
	} // admin

	public void user() {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.게시판 2.쇼핑하기 3.마이페이지 4.로그아웃 5.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				execute();
				
			case 5:
				return;
			} // switch ~ case

		} // while
	} // user
}

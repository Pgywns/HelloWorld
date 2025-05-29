package com.app;

import java.util.List;
import java.util.Scanner;

import com.service.BoardService;
import com.service.BoardServiceDAO;
import com.service.MemberService;
import com.service.MemberServiceDAO;
import com.vo.Board;
import com.vo.Member;

public class MainApp {
	Scanner scn = new Scanner(System.in);
	
	MemberService msc = new MemberServiceDAO();
	BoardService bsc = new BoardServiceDAO();
//	ProductService psc = new ProductServiceDAO(); 
	
	String admin; // 권한
	String user; // 로그인 아이디
	
	public void execute() {
		String id;
		String pw;
		String name;
		String phone;
		String email;
		
		boolean run = true;
		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.로그인 2.회원가입 3.아이디 찾기 4.비밀번호 찾기 5.종료");
			System.out.print("선택>> ");

			int menu = Integer.parseInt(scn.nextLine());
			
			switch (menu) {
			case 1:
				System.out.print("아이디>> ");
				id = scn.nextLine();

				System.out.print("비밀번호>> ");
				pw = scn.nextLine();
				
				admin = msc.logIn(id, pw);
				
				if (admin.equals("admin")) {
					System.out.println("관리자 계정으로 로그인하였습니다");					
					admin();
				} else if (admin.equals("user")) {
					System.out.printf("%s님 환영합니다!\n", id);
					user = id;
					user();						
				} else {
					System.out.println("로그인에 실패하였습니다.");
					break;
				}
				
				run = false; // 로그인 후에 종료를 눌렀을 때 종료될 수 있게 반복문을 끝냄
				
				break;
			case 2:
				System.out.print("아이디>> ");
				id = scn.nextLine();

				System.out.print("비밀번호>> ");
				pw = scn.nextLine();
				
				System.out.print("이름>> ");
				name = scn.nextLine();
				
				System.out.print("전화번호>> ");
				phone = scn.nextLine();
				
				System.out.print("이메일>> ");
				email = scn.nextLine();
				
				Member member = new Member(id, pw, name, phone, email);
				
				if (msc.addMember(member)) {
					System.out.println("회원가입을 완료하였습니다.");
				} else {
					System.out.println("회원가입에 실패하였습니다.");
				}
				break;
			case 3:
				System.out.print("이름>> ");
				name = scn.nextLine();
				
				System.out.print("전화번호>> ");
				phone = scn.nextLine();
				
				msc.findId(name, phone);
				break;
			case 4:
				System.out.print("아이디>> ");
				id = scn.nextLine();
				
				String pwd = msc.findPw(id);
				
				if (pwd != null) {
					System.out.printf("비밀번호는 %s 입니다.\n", pwd);
				}
				break;
			case 5:
				System.out.println("종료되었습니다.");
				return;
			default :
				System.out.println("다시 입력해주세요");
				break;
				
			} // switch ~ case
		} // while
	} // execute
	
	public void logout() {
		System.out.println("로그아웃 하였습니다.");
		execute();
	} // logout
	
	public void admin() {
		boolean run = true;

		while (run) {
			System.out.println("-------------------------------------------");
			System.out.println("1.게시판 2.상품관리 3.재고관리 4.회원관리 5.로그아웃 6.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());

			switch (menu) {
			case 1:
				boolean boardmanager = true;
				while (boardmanager) {
					System.out.println("-------------------------------------------");
					System.out.println("1.글 목록 2.글 삭제 3.돌아가기");
					System.out.print("선택>> ");
					int no = Integer.parseInt(scn.nextLine());
					
					List<Board> board = bsc.boardList();
					for (int i = 0; i < board.size(); i++) {
						System.out.printf("%s %s %s %s\n", board.get(i).getTitle(), board.get(i).getContent(), board.get(i).getUploaddate(), board.get(i).getWriter());
					}
					
					switch (no) {
					case 1:
						
						break;
						
					case 2:
						break;
						
					case 3:
						boardmanager = false;
						break;
						
					default :
						System.out.println("다시 입력해주세요");
						break;
					
					}
				}
				break;

			case 2:
				break;

			case 3:
				break;

			case 4:
				boolean memmanger = true;
				while (memmanger) {
					System.out.println("-------------------------------------------");
					System.out.println("1.회원목록 2.회원삭제 3.돌아가기");
					System.out.print("선택>> ");
					int no = Integer.parseInt(scn.nextLine());
					
					switch (no) {
					case 1:
						System.out.println("ID         NAME   PHONE        EMAIL");
						List<Member> member = msc.memberList();
						for (int i = 0; i < member.size(); i++) {
							if (!member.get(i).getAdmin().equals("admin")) {
								System.out.printf("%-10s %-5s %-11s %s\n", member.get(i).getId(), member.get(i).getName(), member.get(i).getPhone(), member.get(i).getEmail());
							}
						}					
						break;
						
					case 2:
						System.out.print("삭제할 아이디를 입력해주세요>> ");
						String id = scn.nextLine();
						
						if (msc.removeMember(id)) {
							System.out.println("삭제되었습니다.");
						} else {
							System.out.println("삭제에 실패하였습니다.");
						}
						
						break;
						
					case 3:
						memmanger = false;
						break;
						
					default :
						System.out.println("다시 입력해주세요");
						break;
					} // switch
				} // while
				
				break;

			case 5:
				logout();
				return;
			case 6:
				System.out.println("종료되었습니다.");
				return;
			default :
				System.out.println("다시 입력해주세요");
				break;
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
				boolean memmanger = true;
				
				while (memmanger) {
					System.out.println("-------------------------------------------");
					System.out.println("1.정보수정 2.회원탈퇴 3.돌아가기");
					System.out.print("선택>> ");
					int no = Integer.parseInt(scn.nextLine());
					
					switch (no) {
					case 1 :
						System.out.print("비밀번호>> ");
						String pw = scn.nextLine();
						
						System.out.print("이름>> ");
						String name = scn.nextLine();
						
						System.out.print("전화번호>> ");
						String phone = scn.nextLine();
						
						System.out.print("이메일>> ");
						String email = scn.nextLine();
						
						Member member = new Member(user, pw, name, phone, email);
						
						if (msc.modifyMember(member)) {
							System.out.println("회원 정보를 변경하였습니다.");
						} else {
							System.out.println("정보 변경에 실패하였습니다.");
						}
						
						break;
						
					case 2 :
						System.out.print("정말 탈퇴하시겠습니까? (Y / N)>> ");
						String msg = scn.nextLine();
						
						if (msg.equals("Y")) {
							msc.removeMember(user);
							System.out.println("탈퇴가 완료되었습니다.");
							execute();
							return;
						}
						
						break;
						
					case 3 :
						memmanger = false;
						break;
					
					default : 
						System.out.println("다시 입력해주세요");
						break;
					}
				}
				break;

			case 4:
				logout();
				return;
			case 5:
				System.out.println("종료되었습니다.");
				return;
				
			default :
				System.out.println("다시 입력해주세요");
				break;
			} // switch ~ case
		} // while
		
	} // user
}

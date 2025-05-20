package com.yedam.board;

import java.util.Scanner;

/*
	추가, 수정, 삭제, 목록
*/

public class BoardExe {
	// 필드
	private Board[] boards;
	private Scanner scn = new Scanner(System.in);
	
	// 생성자
	public BoardExe() {
		boards = new Board[100];
	}
	
	// 메소드
	void execute() {
		boolean run = true;
		
		while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5.종료");
			System.out.println("------------------------------------");
			System.out.print("선택>> ");
			int selectNo = Integer.parseInt(scn.nextLine());
			
			switch(selectNo) {
			case 1: // 추가
				addBoard();			
				break;
			case 2: // 수정
				
				break;
			case 3: // 삭제
							
				break;
			case 4: // 목록 조회
				boardList();
				break;
			case 5: // 종료							
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택하세요.");
			} // switch
			
		} // while
		
		System.out.println("종료되었습니다.");
	} // execute;
	
	// 글 번호를 입력하세요>> 1
	// 제목을 입력하세요 >> ~~
	// 내용을 입력하세요 >> ~~~
	// 작성자를 입력하세요 >>
	void addBoard() {
		System.out.print("글 번호를 입력하세요>> ");
		int boardNo = Integer.parseInt(scn.nextLine());
		
		System.out.print("제목을 입력하세요>> ");
		String title = scn.nextLine();
		
		System.out.print("내용을 입력하세요>> ");
		String content = scn.nextLine();
		
		System.out.print("작성자를 입력하세요>> ");
		String writer = scn.nextLine();
		
		Board board = new Board(boardNo, title, content, writer);
		
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				System.out.println("글을 등록했습니다.");
				break;
			}
		}
		
	} // addBoard
	
	// 글번호  제목      작성자
	// ======================
	// 1     날씨가 굿  홍길동    
	void boardList() {
		boolean result = false;
		
		System.out.printf("%3s %11s %5s\n", "글번호", "제목", "작성자");
		System.out.println("====================================");
		
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null) {
				boards[i].showInfo();
				result = true;
			}
		}
		
		if (!result) {
			System.out.println("글이 없습니다.");
			return;
		}
		
		System.out.println("------------------------------------");
		System.out.print("상세보기: 글 번호입력, 메뉴로 이동(q)>> ");
		String str = scn.nextLine();
		System.out.println("------------------------------------");
		
		// 메뉴, 상세
		if(str.equals("q")) {
			return;
		} else {
			int no = Integer.parseInt(str);
			// 배열에서 조회
			for (int i = 0; i < boards.length; i++) {
				if (boards[i] != null && boards[i].getBoardNo() == no) {
					boards[i].showAllInfo();
				}
			}
		} // if
				
	} // boardList
	
}
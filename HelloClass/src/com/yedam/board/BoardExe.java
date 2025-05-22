package com.yedam.board;

import java.util.Scanner;
import com.yedam.Calendar;

/*
	추가 (addBoard)
	수정 (modifyBoard) 글 번호 -> 바뀔 내용, 바뀔 제목
	삭제 (removeBoard) 글 번호 -> 삭제
	목록 (boardList)
	
	조회 (gerBoard) 글 번호 -> 글 반환
	순번부여 (nextSequence) 현재 글 번호 + 1
*/

public class BoardExe {
	// 필드
	private Board[] boards = new Board[100];
	private Scanner scn = new Scanner(System.in);

	// 생성자
	public BoardExe() {
//		boards = new Board[100];
		boards[0] = new Board(1, "11", "11", "11");
		boards[1] = new Board(2, "22", "22", "22");
		boards[2] = new Board(3, "33", "33", "33");
		boards[3] = new Board(4, "44", "44", "44");
		boards[4] = new Board(5, "55", "55", "55");
		boards[5] = new Board(6, "66", "66", "66");
		boards[6] = new Board(7, "77", "77", "77");
		boards[7] = new Board(8, "88", "88", "88");
		boards[8] = new Board(9, "99", "99", "99");
		boards[9] = new Board(10, "10", "10", "10");
		boards[10] = new Board(11, "11", "11", "11");
		boards[11] = new Board(12, "12", "12", "12");
	}

	// loginCheck()
	boolean loginCheck() {
		int count = 0;

		while (true) {
			// 아이디 입력
			String id = userMessage("아이디를 입력해주세요");
			// 비밀번호 입력
			String pw = userMessage("비밀번호를 입력해주세요");

			if (!UserExe.login(id, pw)) {
				count++;
				if (count == 3) {
					System.out.println("로그인 시도가 3회로 종료되었습니다.");
					return false;
				}
				System.out.println("회원정보를 다시 확인해주세요");
			} else {
				System.out.printf("%s님 환영합니다.\n\n", id);
				return true;
			}
		} // while

	} // loginCheck

	// 메소드
	void execute() {
		boolean run = true;

		if (!loginCheck()) {
			return;
		}

		while (run) {
			System.out.println("-------------------------------------------------");
			System.out.println("1.추가 | 2.수정 | 3.삭제 | 4.목록 | 5. 달력 | 6.종료");
			System.out.println("-------------------------------------------------");
			int selectNo = 0;

			try {
				selectNo = userMenu("선택");
			} catch (NumberFormatException e) {
				System.out.println("1 ~ 5번중에 선택");
				continue;
			}

			switch (selectNo) {
			case 1: // 추가
				addBoard();
				break;
			case 2: // 수정
				modifyBoard();
				break;
			case 3: // 삭제
				removeBoard();
				sort();
				break;
			case 4: // 목록
				boardList();
				break;
			case 5: // 달력
				Calendar.showMonth();
				break;
			case 6: // 종료
				run = false;
				break;
			default:
				System.out.println("1 ~ 5번중에 선택");
			} // switch

		} // while

		System.out.println("종료되었습니다.");
	} // execute;

	// 글 번호를 입력하세요>> 1
	// 제목을 입력하세요 >> ~~
	// 내용을 입력하세요 >> ~~~
	// 작성자를 입력하세요 >>
	void addBoard() {
		int boardNo = nextSequence();
		String title = userMessage("제목을 입력하세요");
		String content = userMessage("내용을 입력하세요");
		String writer = userMessage("작성자를 입력하세요");

		Board board = new Board(boardNo, title, content, writer);

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] == null) {
				boards[i] = board;
				System.out.println("글을 등록했습니다.");
				break;
			}
		}

	} // addBoard

	// 글번호 제목 작성자
	// ======================
	// 1 날씨가 굿 홍길동
	void boardList() {
		boolean result = false;
		int page = 1;

		while (true) {

			int start = (page - 1) * 5;
			int end = page * 5;

			System.out.printf("%3s %11s %5s\n", "글번호", "제목", "작성자");
			System.out.println("=================================================");

			for (int i = start; i < end; i++) {
				if (boards[i] != null) {
					boards[i].showInfo();
					result = true;
				}
			}

			if (!result) {
				System.out.println("글이 없습니다.");
				break;
			}

			System.out.println("-------------------------------------------------");
			String str = userMessage("상세보기: 글 번호입력, 이전(p), 다음(n), 메뉴로 이동(q)");
			System.out.println("-------------------------------------------------");

			// 메뉴, 상세
			if (str.equals("q")) {
				break;
			} else if (str.equals("n")) {
				page++;
			} else if (str.equals("p")) {
				if (start > 0) {
					page--;
				}
			} else {
				int no = 0;

				try {
					no = Integer.parseInt(str);
				} catch (NumberFormatException e) {
					System.out.println("글 번호를 다시 입력하세요!\n");
					continue;
				}

				// 배열에서 조회
				Board sboard = getBoard(no);
				if (sboard == null) {
					System.out.println("조회 결과가 없습니다.");
					break;
				}

				sboard.showAllInfo();
			} // if
		}
		System.out.println();
	} // boardList

	void modifyBoard() {
		int bno = 0;

		while (true) {
			try {
				bno = userMenu("수정할 글 번호 입력");
			} catch (NumberFormatException e) {
				System.out.println("글 번호를 입력하세요");
				continue;
			}
			break;
		}

		Board result = getBoard(bno);
		if (result == null) {
			System.out.println("조회한 결과가 없습니다.");
			return;
		}

		String title = userMessage("수정할 제목 입력");
		String content = userMessage("수정할 내용 입력");

		result.setTitle(title);
		result.setContent(content);
		System.out.println("수정이 완료되었습니다.");

	} // modifyBoard

	void removeBoard() {
		boolean result = false;
		int bno = 0;

		while (true) {
			try {
				bno = userMenu("삭제할 글 번호를 입력하세요");
			} catch (Exception e) {
				System.out.println("글 번호를 입력하세요!!!");
				continue;
			}
			break;
		}

		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				boards[i] = null;
				System.out.println("삭제되었습니다.");
				result = true;
			}
		}

		if (!result) {
			System.out.println("해당하는 글이 없습니다.");
		}

	} // removeBoard

	// 조회
	Board getBoard(int bno) {
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && boards[i].getBoardNo() == bno) {
				return boards[i];
			}
		}

		return null; // 조건에 맞는 정보가 없으면 null 반환
	} // getBoard

	// 사용자의 입력값을 반환
	String userMessage(String msg) {
		System.out.print(msg + ">> ");
		return scn.nextLine();
	} // userMessage

	// 사용자의 입력값을 반환
	int userMenu(String msg) {
		System.out.print(msg + ">> ");
		return Integer.parseInt(scn.nextLine());
	} // userMessage

	// 현재 마지막 글 번호에서 + 1
	int nextSequence() {
		int max = 0;
		for (int i = 0; i < boards.length; i++) {
			if (boards[i] != null && max < boards[i].getBoardNo()) {
				max = boards[i].getBoardNo();
			}
		}
		return max + 1;
	} // nextSequence

	// 글 번호를 순서에 맞게 변경해줌
	void sort() {
		for (int i = 0; i < boards.length - 1; i++) {
			if (boards[i] == null && boards[i + 1] != null) {
				boards[i] = boards[i + 1];
				boards[i].setBoardNo(boards[i + 1].getBoardNo() - 1);
				boards[i + 1] = null;
			}
		}
	} // sort

} // end of class